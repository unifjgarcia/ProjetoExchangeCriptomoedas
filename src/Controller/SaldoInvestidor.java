/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Investidor;
import View.Saldo;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;




/**
 *
 * @author Jpsab
 */
public class SaldoInvestidor {
    private Saldo view;

    public SaldoInvestidor(Saldo view) {
        this.view = view;
    }

    public void ConsultarSaldo() {
        String senha = view.getTxtSenhaSaldo().getText(); // Obtém a senha da view

        // Obtenha o investidor da sessão
        Investidor investidor = SessaoInvestidor.getInvestidor();

        if (investidor != null) {
            // Verifique se a senha fornecida corresponde à senha do investidor
            if (investidor.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(view, "Senha correta!");

                ConexaoBancoDados conectar = new ConexaoBancoDados();
                try {
                    Connection conexao = conectar.getConnection();
                    InvestidorConectado conectado = new InvestidorConectado(conexao);
                    ResultSet resultado = conectado.carteiraSaldos(investidor);

                    if (resultado.next()) {
                        // Obter saldos da carteira
                        double saldoReal = resultado.getDouble("saldo_real");
                        double saldoBitcoin = resultado.getDouble("saldo_bitcoin");
                        double saldoEthereum = resultado.getDouble("saldo_ethereum");
                        double saldoRipple = resultado.getDouble("saldo_ripple");

                        // Exibir saldos na view
                        view.getTxtMostraSaldos().setText(
                            "Nome: " + investidor.getNome() + "\n" +
                            "CPF: " + investidor.getCpf() + "\n" +
                            "Reais: " + saldoReal + "\n" +
                            "Bitcoin: " + saldoBitcoin + "\n" +
                            "Ethereum: " + saldoEthereum + "\n" +
                            "Ripple: " + saldoRipple
                        );
                    } else {
                        JOptionPane.showMessageDialog(view, "Não foi possível obter os saldos.");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(view, "Erro ao consultar saldos: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta, tente novamente");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Investidor não autenticado.");
        }
    }
}
    

