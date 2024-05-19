/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Investidor;

/**
 *
 * @author Jpsab
 */
public class SessaoInvestidor {
    private static Investidor investidor;

    public static Investidor getInvestidor() {
        return investidor;
    }

    public static void setInvestidor(Investidor investidor) {
        SessaoInvestidor.investidor = investidor;
    }
}
