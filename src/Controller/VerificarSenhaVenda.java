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
 * A classe VerificarSenhaVenda é responsável por verificar a senha do investidor
 * antes de permitir a venda de criptomoedas.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class VerificarSenhaVenda {
    private SenhaVendeCripto view;
    
    
    /**
     * Construtor da classe VerificarSenhaVenda.
     * 
     * @param view A referência à janela de confirmação de senha para venda de criptomoedas.
     */
    
    public VerificarSenhaVenda(SenhaVendeCripto view) {
        this.view = view;
    }
    
    /**
     * Verifica a senha do investidor. Se a senha estiver correta, obtém as cotações
     * atualizadas das criptomoedas, abre a janela de venda de criptomoedas e exibe
     * as cotações. Caso contrário, exibe uma mensagem de erro.
     */
    
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
