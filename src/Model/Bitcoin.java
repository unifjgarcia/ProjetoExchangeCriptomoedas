/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * A classe Bitcoin representa uma criptomoeda específica (Bitcoin) e implementa 
 * a interface Tarifacao para aplicar taxas de compra e venda.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 * @see Moedas
 * @see Tarifacao
 */
    
/**
     * Construtor da classe Bitcoin.
     * 
     * @param saldo O saldo inicial de Bitcoin.
     */

public class Bitcoin extends Moedas implements Tarifacao{
    public Bitcoin(double saldo) {
        super("Bitcoin", saldo);
    }
    
    /**
     * Aplica a taxa de compra para a quantidade especificada de Bitcoin.
     * A taxa de compra é de 2% do valor da compra.
     * 
     * @param comprarCripto A quantidade de Bitcoin a ser comprada.
     * @return O valor da taxa de compra.
     */
    
    @Override
    public double taxaCompra(double comprarCripto){
        double taxa = comprarCripto * 0.02; 
        this.saldo -= taxa;
        return taxa;
    }
    
    /**
     * Aplica a taxa de venda para a quantidade especificada de Bitcoin.
     * A taxa de venda é de 3% do valor da venda.
     * 
     * @param venderCripto A quantidade de Bitcoin a ser vendida.
     * @return O valor da taxa de venda.
     */
    
    @Override
    public double taxaVenda(double venderCripto){
        double taxa = venderCripto * 0.03;
        this.saldo -= taxa;
        return taxa;
    }
}
