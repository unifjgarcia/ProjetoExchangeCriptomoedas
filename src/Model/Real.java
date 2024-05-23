/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * A classe Real apenas recebe os parametros criados em Moedas e Tarifacao.
 * Taxa de compra e venda são zero.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 * @see Moedas
 * @see Tarifacao
 */
public class Real extends Moedas implements Tarifacao {
    
    /**
     * Construtor da classe Real.
     * 
     * @param saldo O saldo inicial em Real.
     */
    public Real(double saldo) {
        super("Real", saldo);
    }

    /**
     * Aplica a taxa de compra para a quantidade especificada de Real.
     * Para a moeda Real, a taxa de compra é sempre zero.
     * 
     * @param comprarCripto A quantidade de Real a ser comprada.
     * @return O valor da taxa de compra, que é zero para Real.
     */
    @Override
    public double taxaCompra(double comprarCripto) {
        return 0;
    }

    /**
     * Aplica a taxa de venda para a quantidade especificada de Real.
     * Para a moeda Real, a taxa de venda é sempre zero.
     * 
     * @param venderCripto A quantidade de Real a ser vendida.
     * @return O valor da taxa de venda, que é zero para Real.
     */
    @Override
    public double taxaVenda(double venderCripto) {
        return 0;
    }
}
