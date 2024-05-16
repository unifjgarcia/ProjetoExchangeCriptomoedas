/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.InvestidorConectado;
import Model.Carteira;
import java.sql.SQLException;

/**
 *
 * @author Jpsab
 */
public class DepositoInvestidor {
    private InvestidorConectado investidorConectado;
    private String investidorId;

    public DepositoInvestidor(InvestidorConectado investidorConectado, String investidorId) {
        this.investidorConectado = investidorConectado;
        this.investidorId = investidorId;
    }

//    public void depositar(double valor) throws SQLException, IllegalArgumentException {
//        if (valor <= 0) {
//            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
//        }
//        investidorConectado.depositar(investidorId, valor);
//    }

//    public Carteira obterSaldos() throws SQLException {
//        return investidorConectado.getSaldo(investidorId);
//    }
//
//    private String formatarSaldos(Carteira carteira) {
//        return String.format("Reais: %.2f\nBitcoin: %.4f\nEthereum: %.4f\nRipple: %.4f",
//            carteira.getReal(), carteira.getBitcoin(), carteira.getEthereum(), carteira.getRipple());
//    }
//
//    public String realizarDepositoEObterSaldos(double valor) {
//        try {
//            depositar(valor);
//            Carteira carteira = obterSaldos();
//            return "Depósito realizado com sucesso!\n" + formatarSaldos(carteira);
//        } catch (IllegalArgumentException | SQLException e) {
//            return "Erro: " + e.getMessage();
//        }
//    }
}
