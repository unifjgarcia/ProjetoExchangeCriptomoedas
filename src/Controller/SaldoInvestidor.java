/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Carteira;
import View.Saldo;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;



/**
 *
 * @author Jpsab
 */
public class SaldoInvestidor {
    private Saldo view;
    private InvestidorConectado dao;


    public SaldoInvestidor(Saldo view, InvestidorConectado dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void consultarSaldo(String senha) {
        String resultado = dao.buscarSaldosPorSenha(senha);
        
    }
}
