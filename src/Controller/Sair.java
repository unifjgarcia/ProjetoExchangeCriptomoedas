/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Login;
import View.Menu;
import javax.swing.JOptionPane;

/**
 *
 * @author Jpsab
 */
public class Sair {
    private Menu view;

    public Sair(Menu view) {
        this.view = view;
    }
    
    public void sairMenu(){
        JOptionPane.showMessageDialog(view, "Você saiu!");
        SessaoInvestidor.encerrarSessao();
        view.dispose();
        Login janelaLogin = new Login();
        janelaLogin.setVisible(true);
    }
}
