/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * A classe Carteira representa a carteira de investimentos de um investidor,
 * contendo saldos de várias moedas, incluindo moeda real e criptomoedas.
 * A classe permite a adição e retirada de saldos, bem como a atualização das cotações das criptomoedas.
 * 
 * @author João Pedro Sabino Garcia
 * @version 1.0
 * 
 */
public class Carteira {
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;
    
    /**
     * Construtor da classe Carteira.
     * 
     * @param saldoReal O saldo inicial em reais.
     * @param saldoBitcoin O saldo inicial em Bitcoin.
     * @param saldoEthereum O saldo inicial em Ethereum.
     * @param saldoRipple O saldo inicial em Ripple.
     */
    
    public Carteira(double saldoReal, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        this.real = new Real(saldoReal);
        this.bitcoin = new Bitcoin(saldoBitcoin);
        this.ethereum = new Ethereum(saldoEthereum);
        this.ripple = new Ripple(saldoRipple);
    }
    
    /**
     * Obtém o saldo em reais.
     * 
     * @return O saldo em reais.
     */
    
    public Real getReal() {
        return real;
    }
    
    /**
     * Define o saldo em reais.
     * 
     * @param saldoReal O novo saldo em reais.
     */
    
    public void setReal(double saldoReal) {
        this.real.setSaldo(saldoReal);
    }
    
    /**
     * Obtém o saldo em Bitcoin.
     * 
     * @return O saldo em Bitcoin.
     */
    
    public Bitcoin getBitcoin() {
        return bitcoin;
    }
    
    /**
     * Define o saldo em Bitcoin.
     * 
     * @param saldoBitcoin O novo saldo em Bitcoin.
     */
    
    public void setBitcoin(double saldoBitcoin) {
        this.bitcoin.setSaldo(saldoBitcoin);
    }
    
    /**
     * Obtém o saldo em Ethereum.
     * 
     * @return O saldo em Ethereum.
     */
    
    public Ethereum getEthereum() {
        return ethereum;
    }
    
    /**
     * Define o saldo em Ethereum.
     * 
     * @param saldoEthereum O novo saldo em Ethereum.
     */
    
    public void setEthereum(double saldoEthereum) {
        this.ethereum.setSaldo(saldoEthereum);
    }
    
    /**
     * Obtém o saldo em Ripple.
     * 
     * @return O saldo em Ripple.
     */
    
    public Ripple getRipple() {
        return ripple;
    }

    /**
     * Define o saldo em Ripple.
     * 
     * @param saldoRipple O novo saldo em Ripple.
     */
    
    public void setRipple(double saldoRipple) {
        this.ripple.setSaldo(saldoRipple);
    }
    
    /**
     * Adiciona saldo em reais à carteira.
     * 
     * @param valor O valor a ser adicionado.
     */
    
    public void adicionarSaldo(double valor) {
        this.real.adicionarSaldo(valor);
    }
    
    /**
     * Retira saldo em reais da carteira.
     * 
     * @param valor O valor a ser retirado.
     * @return true se o saldo foi retirado com sucesso, false caso contrário.
     */
    
    public boolean retirarSaldo(double valor) {
        return this.real.retirarSaldo(valor);
    }
    
    /**
     * Atualiza as cotações das criptomoedas na carteira.
     */

    
    public void atualizarCotacoes() {
        bitcoin.variarCotacao();
        ethereum.variarCotacao();
        ripple.variarCotacao();
    }
    
    /**
     * Retorna uma representação em string da carteira.
     * 
     * @return Uma string representando a carteira.
     */
    
    @Override
    public String toString() {
        return "Carteira{" +
                "real=" + real +
                ", bitcoin=" + bitcoin +
                ", ethereum=" + ethereum +
                ", ripple=" + ripple +
                '}';
    }
}