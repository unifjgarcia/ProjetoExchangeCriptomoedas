/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jpsab
 */
public class Bitcoin extends Moedas implements Tarifacao{
    public Bitcoin(double saldo) {
        super("Bitcoin", saldo);
    }
    
    @Override
    public double taxaCompra(double comprarCripto){
        double taxa = comprarCripto * 0.02; 
        this.saldo -= taxa;
        return taxa;
    }
    
    @Override
    public double taxaVenda(double venderCripto){
        double taxa = venderCripto * 0.03;
        this.saldo -= taxa;
        return taxa;
    }
}
