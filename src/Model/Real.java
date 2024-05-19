/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jpsab
 */
public class Real extends Moedas implements Tarifacao {

    public Real(double saldo) {
        super("Real", saldo);
    }

    @Override
    public double taxaCompra(double comprarCripto) {
        // Implementação específica para Real, se necessário
        return 0;
    }

    @Override
    public double taxaVenda(double venderCripto) {
        // Implementação específica para Real, se necessário
        return 0;
    }
}
