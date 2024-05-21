/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.CotacoesCompraCripto;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Jpsab
 */
public class ComprarCriptomoedas {
    private CotacoesCompraCripto view;

    public ComprarCriptomoedas(CotacoesCompraCripto view) {
        this.view = view;
    }
    
    public void comprarCriptomoeda() {
        String cpf = SessaoInvestidor.getInvestidor().getCpf();
        String criptomoeda = view.getCriptomoeda();
        double valor = Double.parseDouble(view.getTxtValorCompraCripto().getText());

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            conectado.obterCotacoes();

            double cotacao = conectado.obterCotacaoCriptomoeda(criptomoeda);
            double saldoReais = conectado.obterSaldoReais(cpf);
            double custo = cotacao * valor;

            if (saldoReais >= custo) {
                double taxa = conectado.aplicarTaxaCompra(criptomoeda, valor);
                conectado.atualizarSaldo(cpf, criptomoeda, conectado.obterSaldoCriptomoeda(cpf, criptomoeda) + (valor - taxa));
                conectado.atualizarSaldoReais(cpf, saldoReais - custo);
                conectado.registrarTransacao(cpf, "Comprar Criptomoeda", criptomoeda, valor - taxa);
                JOptionPane.showMessageDialog(view, "Compra realizada com sucesso! Verifique seu saldo em 'Consultar Saldo'!");
                
            } else {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente para realizar a compra.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao realizar a compra: " + e.getMessage());
        }
    }
}
