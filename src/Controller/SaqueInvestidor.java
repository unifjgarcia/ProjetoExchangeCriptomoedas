/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Investidor;
import Model.Moedas;
import View.Sacar;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 * A classe SaqueInvestidor é responsável por gerenciar o processo de saque de reais 
 * da conta do investidor.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class SaqueInvestidor {
    private Sacar view;
    
    /**
     * Construtor da classe SaqueInvestidor.
     * 
     * @param view A referência à janela de saque.
     */
    
    public SaqueInvestidor(Sacar view) {
        this.view = view;
        
    }
    
    /**
     * Realiza o saque de reais da conta do investidor. Verifica se o investidor possui 
     * saldo suficiente, realiza o saque, atualiza o saldo na carteira do investidor e 
     * no banco de dados, e registra a transação. Em caso de sucesso, exibe uma mensagem 
     * de confirmação; caso contrário, exibe uma mensagem de erro.
     */
    
    public void sacarReais() {
        double valor = Double.parseDouble(view.getTxtValorSaque().getText());

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            boolean sucesso = conectado.sacar(SessaoInvestidor.getInvestidor().getCpf(), valor);

            if (sucesso) {
                // Atualizar saldo na sessão
                SessaoInvestidor.getInvestidor().getCarteira().retirarSaldo(valor);
                JOptionPane.showMessageDialog(view, "Saque realizado com sucesso! Consulte seu saldo para conferir os novos valores!");
            } else {
                JOptionPane.showMessageDialog(view, "Saldo insuficiente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
