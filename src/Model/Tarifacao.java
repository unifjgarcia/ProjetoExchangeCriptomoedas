/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 * A interface Tarifacao é responsavel por criar os parametros iniciais de 
 * taxa de compra e de venda.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public interface Tarifacao {
    
    /**
     * Calcula a taxa de compra para a quantidade especificada de criptomoeda.
     * 
     * @param comprarCripto A quantidade de criptomoeda a ser comprada.
     * @return O valor da taxa de compra.
     */
    double taxaCompra(double comprarCripto);

    /**
     * Calcula a taxa de venda para a quantidade especificada de criptomoeda.
     * 
     * @param venderCripto A quantidade de criptomoeda a ser vendida.
     * @return O valor da taxa de venda.
     */
    double taxaVenda(double venderCripto);
}

