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
 *
 * @author Jpsab
 */
public class SaqueInvestidor {
    private Sacar view;
    private InvestidorConectado dao;
    private Moedas moedas;

    public SaqueInvestidor(Sacar view, InvestidorConectado dao, Moedas moedas) {
        this.view = view;
        this.dao = dao;
        this.moedas = moedas;
    }
    
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
