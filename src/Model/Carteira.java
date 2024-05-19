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

    public Carteira(double saldoReal, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        this.real = new Real(saldoReal);
        this.bitcoin = new Bitcoin(saldoBitcoin);
        this.ethereum = new Ethereum(saldoEthereum);
        this.ripple = new Ripple(saldoRipple);
    }

    public Real getReal() {
        return real;
    }

    public void setReal(double saldoReal) {
        this.real.setSaldo(saldoReal);
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double saldoBitcoin) {
        this.bitcoin.setSaldo(saldoBitcoin);
    }

    public Ethereum getEthereum() {
        return ethereum;
    }

    public void setEthereum(double saldoEthereum) {
        this.ethereum.setSaldo(saldoEthereum);
    }

    public Ripple getRipple() {
        return ripple;
    }

    public void setRipple(double saldoRipple) {
        this.ripple.setSaldo(saldoRipple);
    }

    public void adicionarSaldo(double valor) {
        this.real.adicionarSaldo(valor);
    }

    public boolean retirarSaldo(double valor) {
        return this.real.retirarSaldo(valor);
    }

    public void atualizarCotacoes() {
        bitcoin.variarCotacao();
        ethereum.variarCotacao();
        ripple.variarCotacao();
    }

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