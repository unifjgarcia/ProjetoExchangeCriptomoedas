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
 *
 * @author Jpsab
 */
public class VerificarSenhaExtrato {
    private SenhaExtrato view;

    public VerificarSenhaExtrato(SenhaExtrato view) {
        this.view = view;
    }
    
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

