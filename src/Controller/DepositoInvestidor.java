/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Carteira;
import Model.Investidor;
import Model.Moedas;
import View.Deposito;
import View.Saldo;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jpsab
 */
public class DepositoInvestidor {
    private Deposito view;
    private InvestidorConectado dao;
    private Moedas moedas;

    public DepositoInvestidor(Deposito view, InvestidorConectado dao, Moedas moedas) {
        this.view = view;
        this.dao = dao;
        this.moedas = moedas;
    }

    public void depositar() {
        int investidorId = SessaoInvestidor.getInvestidorId(); // Obter o ID do investidor da sessão
        String senha = view.getTxtDigitaSenha().getText(); // Obtém a senha da view
        double valor = Double.parseDouble(view.getTxtValorDeposito().getText()); // Obtém o valor a ser depositado

        Investidor investidor = new Investidor(investidorId, null, null, null,senha,null);

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            
            // Validar a senha
            ResultSet resultado = conectado.carteiraSaldos(investidorId);
            if (resultado.next()) {
                String senhaBanco = resultado.getString("senha");
                if (senha.equals(senhaBanco)) {
                    // Atualizar o saldo localmente
                    moedas.adicionarSaldo(valor);
                    System.out.println("Saldo atualizado localmente: " + moedas.getSaldo()); // Depuração

                    // Persistir a alteração no banco de dados
                    boolean sucesso = conectado.depositarReais(investidorId, valor);
                    if (sucesso) {
                        conectado.registrarTransacao(investidorId, "Depósito", "Real", valor);
                        JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(view, "Erro ao realizar depósito.");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Senha incorreta, tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Investidor não encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
        }
    }
}

    

