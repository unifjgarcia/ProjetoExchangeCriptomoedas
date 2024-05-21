/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.CotacoesCompraCripto;
import View.SenhaCompraCripto;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jpsab
 */
public class VerificarSenhaCompra {
    private SenhaCompraCripto view;

    public VerificarSenhaCompra(SenhaCompraCripto view) {
        this.view = view;
    }
    
    public void verificaSenha() {
        String senha = view.getTxtConfirmaSenha().getText();
        String cpf = SessaoInvestidor.getInvestidor().getCpf();

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            if (conectado.verificarSenha(cpf, senha)) {
                JOptionPane.showMessageDialog(view, "Senha correta!");
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
                CotacoesCompraCripto janelaCompra = new CotacoesCompraCripto(cotacoes);
                janelaCompra.setVisible(true);
                view.dispose(); 
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao verificar senha: " + e.getMessage());
        }
    }
}