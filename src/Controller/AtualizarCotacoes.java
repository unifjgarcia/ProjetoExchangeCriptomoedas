/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.Cotacoes;
import View.Menu;
import View.Saldo;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


/**
 *
 * @author Jpsab
 */
public class AtualizarCotacoes {
    private Menu view;

    public AtualizarCotacoes(Menu view) {
        this.view = view;
    }
    
    public void atualizarCotacao() {
        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            conectado.variarCotacao();

            // Mostrar mensagem de sucesso
            JOptionPane.showMessageDialog(view, "Cotações atualizadas com sucesso!");

            // Obter as cotações atualizadas
            ResultSet rs = conectado.obterCotacoes();
            String cotacoes = "";
            if (rs.next()) {
                cotacoes = String.format(
                    "Bitcoin: %.2f\nEthereum: %.2f\nRipple: %.2f",
                    rs.getDouble("bitcoin"),
                    rs.getDouble("ethereum"),
                    rs.getDouble("ripple")
                );
            }
            Cotacoes janelaCotacoes = new Cotacoes();
            janelaCotacoes.setCotacoes(cotacoes);
            janelaCotacoes.setVisible(true);
            //view.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cotações: " + e.getMessage());
        }
    }
}
