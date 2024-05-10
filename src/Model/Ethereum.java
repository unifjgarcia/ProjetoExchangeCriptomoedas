/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jpsab
 */
public class Ethereum extends Moedas implements Tarifacao{
    public Ethereum(double saldoInicial) {
        super("Ethereum", saldoInicial);
    }
    
    public double taxaCompra(double comprarCripto){
        double taxa = comprarCripto * 0.01; 
        this.saldo -= taxa;
        return taxa;
    }
    
    public double taxaVenda(double venderCripto){
        double taxa = venderCripto * 0.02;
        this.saldo -= taxa;
        return taxa;
    }
}