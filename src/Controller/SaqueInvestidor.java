/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Investidor;
import Model.Moedas;
import View.Sacar;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Jpsab
 */
public class SaqueInvestidor {
    private Sacar view;
    private InvestidorConectado dao;
    private Moedas moedas;

    public SaqueInvestidor(Sacar view, InvestidorConectado dao, Moedas moedas) {
        this.view = view;
        this.dao = dao;
        this.moedas = moedas;
    }
    
    public void sacar() {
        int investidorId = SessaoInvestidor.getInvestidorId(); // Obter o ID do investidor da sessão
        double valor = Double.parseDouble(view.getTxtValorSaque().getText()); // Obtém o valor a ser sacado

        // Mensagens de depuração
        System.out.println("ID do Investidor: " + investidorId);
        System.out.println("Valor a ser sacado: " + valor);

        // Criar objeto Investidor com os dados necessários
        Investidor investidor = new Investidor(investidorId, null, null, null, null, null);

        ConexaoBancoDados conectar = new ConexaoBancoDados();
        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            
            // Obter o saldo atual
            ResultSet resultado = conectado.carteiraSaldos(investidorId);
            if (resultado.next()) {
                double saldoAtual = resultado.getDouble("saldo_real");

                // Verificar se há saldo suficiente
                if (saldoAtual >= valor) {
                    // Atualizar o saldo localmente
                    if (moedas.retirarSaldo(valor)) {
                        // Persistir a alteração no banco de dados
                        boolean sucesso = conectado.sacarReais(investidorId, valor);
                        if (sucesso) {
                            // Registrar a transação
                            conectado.registrarTransacao(investidorId, "Saque", "Real", valor);

                            JOptionPane.showMessageDialog(view, "Saque realizado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(view, "Erro ao realizar saque.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Erro ao atualizar o saldo localmente.");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente para saque.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Investidor não encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
        }
    }
}
