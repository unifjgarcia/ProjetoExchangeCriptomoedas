/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *A classe Ethereum é uma subclasse de Moedas, implementada pela interface 
 * Tarifacao, e nela está presente suas respectivas taxas de compra e venda.
 * 
 * @author João Pedro Sabino Garcia
 * @version 1.0
 * @see Moedas
 * @see Tarifacao
 */
public class Ethereum extends Moedas implements Tarifacao{
    
    /**
     * Construtor da classe Ethereum.
     * 
     * @param saldo O saldo inicial de Ethereum.
     */
    
    public Ethereum(double saldo) {
        super("Ethereum", saldo);
    }
    
    /**
     * Aplica a taxa de compra para a quantidade especificada de Ethereum.
     * A taxa de compra é de 1% do valor da compra.
     * 
     * @param comprarCripto A quantidade de Ethereum a ser comprada.
     * @return O valor da taxa de compra.
     */
    
    @Override
    public double taxaCompra(double comprarCripto){
        double taxa = comprarCripto * 0.01; 
        this.saldo -= taxa;
        return taxa;
    }
    
    /**
     * Aplica a taxa de venda para a quantidade especificada de Ethereum.
     * A taxa de venda é de 2% do valor da venda.
     * 
     * @param venderCripto A quantidade de Ethereum a ser vendida.
     * @return O valor da taxa de venda.
     */
    
    @Override
    public double taxaVenda(double venderCripto){
        double taxa = venderCripto * 0.02;
        this.saldo -= taxa;
        return taxa;
    }
}
