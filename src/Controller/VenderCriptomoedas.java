/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.CotacoesVendeCripto;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Jpsab
 */
public class VenderCriptomoedas {
    private CotacoesVendeCripto view;

    public VenderCriptomoedas(CotacoesVendeCripto view) {
        this.view = view;
    }
    
    public void vendeCripto(){
        String cpf = SessaoInvestidor.getInvestidor().getCpf();
        String criptomoeda = view.getCriptomoeda();
        double valor = Double.parseDouble(view.getTxtValorVendaCripto().getText());
        
        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);

            double cotacao = conectado.obterCotacaoCriptomoeda(criptomoeda);
            double saldoCriptomoeda = conectado.obterSaldoCriptomoeda(cpf, criptomoeda);

            if (saldoCriptomoeda >= valor) {
                double valorVenda = cotacao * valor;
                double taxa = conectado.aplicarTaxaVenda(criptomoeda, valor);
                conectado.atualizarSaldo(cpf, criptomoeda, saldoCriptomoeda - valor);
                double saldoReais = conectado.obterSaldoReais(cpf);
                conectado.atualizarSaldoReais(cpf, saldoReais + (valorVenda - taxa));
                conectado.registrarTransacao(cpf, "Vender Criptomoedas", criptomoeda, valor);
                JOptionPane.showMessageDialog(view, "Venda realizada com sucesso! Verifique seu saldo em 'Consultar Saldo'!");
            } else {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente de " + criptomoeda + " para realizar a venda.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao realizar a venda: " + e.getMessage());
        }
    }
}

