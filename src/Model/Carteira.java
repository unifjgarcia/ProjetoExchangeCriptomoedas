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
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Carteira(double saldoInicialReal, double saldoInicialBitcoin, double saldoInicialEthereum, double saldoInicialRipple) {
        this.real = new Real(saldoInicialReal);
        this.bitcoin = new Bitcoin(saldoInicialBitcoin);
        this.ethereum = new Ethereum(saldoInicialEthereum);
        this.ripple = new Ripple(saldoInicialRipple);
    }

    public Real getReal() {
        return real;
    }

    public void setReal(Real real) {
        this.real = real;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    public Ripple getRipple() {
        return ripple;
    }

    public void setRipple(Ripple ripple) {
        this.ripple = ripple;
    }
    
    public void atualizarCotacoes() {
        bitcoin.variarCotacao();
        ethereum.variarCotacao();
        ripple.variarCotacao();
    }

    @Override
    public String toString() {
        return "Carteira{" + "real=" + real + ", bitcoin=" + bitcoin + ", ethereum=" + ethereum + ", ripple=" + ripple + '}';
    }
    
    
}
