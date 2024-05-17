/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Investidor;
import View.Login;
import View.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jpsab
 */
public class LoginSucesso {
    private Login view;

    public LoginSucesso(Login view) {
        this.view = view;
    }

    public void LoginInvestidor(){
        int investidorId = SessaoInvestidor.getInvestidorId();
        Investidor investidor = new Investidor(investidorId, null,null, view.getTxtCPF().getText(),
                                                          view.getTxtSenha().getText(), null);
        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try{
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            ResultSet resultado = conectado.infoInvestidor(investidor);
            if(resultado.next()){
                JOptionPane.showMessageDialog(view, "Login realizado com sucesso!");
                Menu janelaMenu = new Menu();
                janelaMenu.setVisible(true);
                view.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(view, "Seu cpf ou senha estão errados ou não cadastrados");
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
}
        
    

