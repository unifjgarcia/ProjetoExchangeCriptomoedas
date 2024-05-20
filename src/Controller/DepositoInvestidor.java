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
 *
 * @author Jpsab
 */
public class DepositoInvestidor {
    private Deposito view;

    public DepositoInvestidor(Deposito view) {
        this.view = view;
    }

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

    

