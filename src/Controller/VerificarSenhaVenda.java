/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.CotacoesCompraCripto;
import View.CotacoesVendeCripto;
import View.SenhaVendeCripto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jpsab
 */
public class VerificarSenhaVenda {
    private SenhaVendeCripto view;

    public VerificarSenhaVenda(SenhaVendeCripto view) {
        this.view = view;
    }
    
    public void verificaSenhaVenda() {
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
                CotacoesVendeCripto janelaVende = new CotacoesVendeCripto(cotacoes);
                janelaVende.setVisible(true);
                view.dispose(); 
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao verificar senha: " + e.getMessage());
        }
    }
}
