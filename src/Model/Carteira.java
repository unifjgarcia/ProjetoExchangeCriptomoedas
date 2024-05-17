/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jpsab
 */
public class Carteira {
    private int investidorId;
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Carteira(int investidorId ,double saldoReal, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        this.investidorId = investidorId;
        this.real = new Real(saldoReal);
        this.bitcoin = new Bitcoin(saldoBitcoin);
        this.ethereum = new Ethereum(saldoEthereum);
        this.ripple = new Ripple(saldoRipple);
    }
    
    public int getInvestidorId() {
        return investidorId;
    }
    
    public Real getReal() {
        return real;
    }

    public void setReal(double saldoReal) {
        this.real = real;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double saldoBitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(double saldoEthereum) {
        this.ethereum = ethereum;
    }

    public Ripple getRipple() {
        return ripple;
    }

    public void setRipple(double saldoRipple) {
        this.ripple = ripple;
    }
    
    public void atualizarCotacoes() {
        bitcoin.variarCotacao();
        ethereum.variarCotacao();
        ripple.variarCotacao();
    }

    @Override
    public String toString() {
        return "Carteira{" + "investidorId=" + investidorId + "real=" + real + ", bitcoin=" + bitcoin + ", ethereum=" + ethereum + ", ripple=" + ripple + '}';
    }
    
    
}
