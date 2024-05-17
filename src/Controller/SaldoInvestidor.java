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
    private InvestidorConectado dao;

    public SaldoInvestidor(Saldo view, InvestidorConectado dao) {
        this.view = view;
        this.dao = dao;
    }

    public void ConsultarSaldo() {
        Integer investidorId = SessaoInvestidor.getInvestidorId();
        String senha = view.getTxtSenhaSaldo().getText(); // Obtém a senha da view

        Investidor investidor = new Investidor(investidorId, null, null, null, senha, null);

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            ResultSet resultado = conectado.infoInvestidor(investidor);

            if (resultado.next()) {
                String senhaBanco = resultado.getString("senha");

                if (senha.equals(senhaBanco)) {
                    // Obter saldos
                    double saldoReal = resultado.getDouble("saldo_real");
                    double saldoBitcoin = resultado.getDouble("saldo_bitcoin");
                    double saldoEthereum = resultado.getDouble("saldo_ethereum");
                    double saldoRipple = resultado.getDouble("saldo_ripple");

                    // Exibir saldos na view
                    view.getTxtMostraSaldos().setText(
                        "Saldo Real: " + saldoReal + "\n" +
                        "Saldo Bitcoin: " + saldoBitcoin + "\n" +
                        "Saldo Ethereum: " + saldoEthereum + "\n" +
                        "Saldo Ripple: " + saldoRipple
                    );
                } else {
                    JOptionPane.showMessageDialog(view, "Senha incorreta, tente novamente");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Investidor não encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
        }
    }
}