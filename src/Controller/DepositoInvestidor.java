/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Carteira;
import Model.Investidor;
import Model.Moedas;
import View.Deposito;
import View.Saldo;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *  * A classe DepositoInvestidor é responsável por gerenciar o processo de depósito de reais 
 * na conta do investidor.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class DepositoInvestidor {
    private Deposito view;
    
    /**
     * Construtor da classe DepositoInvestidor.
     * 
     * @param view A referência à janela de Deposito.
     */
    
    public DepositoInvestidor(Deposito view) {
        this.view = view;
    }
    
    /**
     * Realiza o depósito de reais na conta do investidor. Verifica a senha fornecida pelo 
     * investidor, e se estiver correta, atualiza o saldo na carteira do investidor e no banco 
     * de dados, registrando o depósito.
     */
    
    public void depositarReais() {
        String cpf = SessaoInvestidor.getInvestidor().getCpf();
        String senha = view.getTxtDigitaSenha().getText();
        double valor = Double.parseDouble(view.getTxtValorDeposito().getText());

        if (SessaoInvestidor.getInvestidor().getSenha().equals(senha)) {
            ConexaoBancoDados conectar = new ConexaoBancoDados();
            try {
                Connection conexao = conectar.getConnection();
                InvestidorConectado conectado = new InvestidorConectado(conexao);
                boolean sucesso = conectado.depositar(cpf, valor);

                if (sucesso) {
                    // Atualizar saldo na sessão
                    SessaoInvestidor.getInvestidor().getCarteira().adicionarSaldo(valor);
                    JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso! Consulte seu saldo para conferir os novos valores!");
                } else {
                    JOptionPane.showMessageDialog(view, "Erro ao realizar depósito.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view, "Senha incorreta.");
        }
    }
}

    

