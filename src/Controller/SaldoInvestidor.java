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
    private InvestidorConectado investidorConectado;
    private String investidorId; // ID do investidor logado

    public SaldoInvestidor(InvestidorConectado investidorConectado, String investidorId) {
        this.investidorConectado = investidorConectado;
        this.investidorId = investidorId;
    }

    public String verificarSenhaEObterSaldos(String senha) {
        try {
            if (investidorConectado.verificarSenha(investidorId, senha)) {
                Carteira carteira = investidorConectado.getSaldo(investidorId);
                return formatarSaldos(carteira);
            } else {
                return "Senha incorreta";
            }
        } catch (SQLException e) {
            return "Erro ao acessar o banco de dados: " + e.getMessage();
        }
    }

    private String formatarSaldos(Carteira carteira) {
        return String.format("Reais: %.2f, Bitcoin: %.4f, Ethereum: %.4f, Ripple: %.4f",
            carteira.getReal(), carteira.getBitcoin(), carteira.getEthereum(), carteira.getRipple());
    }
}
