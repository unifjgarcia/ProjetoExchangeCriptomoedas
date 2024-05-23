/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import View.Extrato;
import View.SenhaExtrato;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe VerificarSenhaExtrato é responsável por verificar a senha do investidor
 * antes de permitir o acesso ao extrato.
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */

/**
     * Construtor da classe VerificarSenhaExtrato.
     * 
     * @param view A referência à janela de confirmação de senha para acesso ao extrato.
     */
public class VerificarSenhaExtrato {
    private SenhaExtrato view;

    public VerificarSenhaExtrato(SenhaExtrato view) {
        this.view = view;
    }
    
    
    /**
     * Verifica a senha do investidor. Se a senha estiver correta, obtém o nome e CPF 
     * do investidor, e então obtém e exibe o extrato do investidor na janela de extrato.
     * Caso contrário, exibe uma mensagem de erro.
     */
    
    public void extrato(){
        String senha = view.getTxtConfirmaSenha().getText();
        String cpf = SessaoInvestidor.getInvestidor().getCpf();

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            if (conectado.verificarSenha(cpf, senha)) {
                JOptionPane.showMessageDialog(view, "Senha correta!");

                // Obter nome e CPF do investidor
                String nome = conectado.obterNomeInvestidor(cpf);

                // Obter extrato do investidor
                ResultSet rs = conectado.obterExtrato(cpf);
                StringBuilder extrato = new StringBuilder();
                extrato.append("Nome: ").append(nome).append("\n")
                       .append("CPF: ").append(cpf).append("\n\n");
                while (rs.next()) {
                    extrato.append("Data: ").append(rs.getTimestamp("data_hora"))
                           .append(", Tipo: ").append(rs.getString("tipo_transacao"))
                           .append(", Moeda: ").append(rs.getString("moeda"))
                           .append(", Valor: ").append(rs.getDouble("valor"))
                           .append("\n");
                }

                // Abrir janela de extrato
                Extrato janelaExtrato = new Extrato(extrato.toString());
                janelaExtrato.setVisible(true);
                view.dispose(); // Fechar a janela de verificação de senha
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao verificar senha: " + e.getMessage());
        }
    }
}

