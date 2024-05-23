/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Login;
import View.Menu;
import javax.swing.JOptionPane;

/**
 * A classe Sair é responsável por gerenciar a ação de sair do menu principal da aplicação.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class Sair {
    private Menu view;
    
    /**
     * Construtor da classe Sair.
     * 
     * @param view A referência à janela do menu principal.
     */
    
    public Sair(Menu view) {
        this.view = view;
    }
    
    /**
     * Realiza a ação de sair do menu principal.
     * Exibe uma mensagem de confirmação de saída, encerra a sessão do investidor,
     * fecha a janela do menu principal e abre a janela de login.
     */
    
    public void sairMenu(){
        JOptionPane.showMessageDialog(view, "Você saiu!");
        SessaoInvestidor.encerrarSessao();
        view.dispose();
        Login janelaLogin = new Login();
        janelaLogin.setVisible(true);
    }
}
