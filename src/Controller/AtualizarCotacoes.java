/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.Cotacoes;
import View.Saldo;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Jpsab
 */
public class AtualizarCotacoes {
    private Saldo view;

    public AtualizarCotacoes(Saldo view) {
        this.view = view;
    }
    
    public void atualizarCotacao() {
        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            conectado.variarCotacao();
            JOptionPane.showMessageDialog(view, "Cotações atualizadas com sucesso!");
            Cotacoes janelaCotacoes = new Cotacoes();
            janelaCotacoes.setVisible(true);
            view.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cotações: " + e.getMessage());
        }
    }
}
