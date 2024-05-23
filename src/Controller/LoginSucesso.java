/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Carteira;
import Model.Investidor;
import View.Login;
import View.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * A classe LoginSucesso é responsável por gerenciar o processo de login do investidor.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class LoginSucesso {
    private Login view;
    
    /**
     * Construtor da classe LoginSucesso.
     * 
     * @param view A referência à janela de Login.
     */
    
    public LoginSucesso(Login view) {
        this.view = view;
    }
    
    /**
     * Realiza o login do investidor. Verifica as credenciais (CPF e senha) fornecidas,
     * e se forem válidas, configura a sessão do investidor com as informações recuperadas
     * do banco de dados, incluindo o saldo das criptomoedas. Em seguida, abre o menu principal
     * da aplicação. Em caso de erro, exibe mensagens apropriadas.
     */
    
    public void LoginInvestidor(){
        Investidor investidor = new Investidor(null, null, view.getTxtCPF().getText(), view.getTxtSenha().getText(), null);
        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            ResultSet resultado = conectado.infoInvestidor(investidor);
            if (resultado.next()) {
                // Definir o investidor na sessão
                investidor.setNome(resultado.getString("nome"));
                investidor.setIdade(resultado.getString("idade"));
                investidor.setSenha(resultado.getString("senha"));
                Carteira carteira = new Carteira(
                    resultado.getDouble("saldo_real"),
                    resultado.getDouble("saldo_bitcoin"),
                    resultado.getDouble("saldo_ethereum"),
                    resultado.getDouble("saldo_ripple")
                );
                investidor.setCarteira(carteira);
                SessaoInvestidor.setInvestidor(investidor);

                JOptionPane.showMessageDialog(view, "Login realizado com sucesso!");
                Menu janelaMenu = new Menu();
                janelaMenu.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "Seu CPF ou senha estão errados ou não cadastrados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
        }
    }
}
        
    

