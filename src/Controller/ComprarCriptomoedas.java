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
 * A classe ComprarCriptomoedas é responsável por gerenciar o processo de compra de criptomoedas 
 * pelos investidores. 
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class ComprarCriptomoedas {
    private CotacoesCompraCripto view;
    
    /**
     * Construtor da classe ComprarCriptomoedas.
     * 
     * @param view A referência à janela de CotacoesCompraCripto.
     */
    
    public ComprarCriptomoedas(CotacoesCompraCripto view) {
        this.view = view;
    }
    
    /**    
    * Ela verifica o saldo do investidor, aplica a taxa de compra, atualiza os saldos 
    * e registra a transação no banco de dados. Se a compra for bem-sucedida, uma mensagem de sucesso 
    * é exibida; caso contrário, uma mensagem de erro é exibida.
    */
    
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
