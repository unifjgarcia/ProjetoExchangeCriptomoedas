/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Random;


/**
 *
 * @author Jpsab
 */
public abstract class Moedas {
    protected String nome;
    protected double saldo;

    public Moedas(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void adicionarSaldo(double quantidade) {
        this.saldo += quantidade;
    }
    
    public boolean retirarSaldo(double quantidade) {
        if (quantidade <= saldo) {
            saldo -= quantidade;
            return true;
        }
        return false;
    }
    
    public void variarCotacao() {
        Random random = new Random();
        double variacao = -0.05 + (0.05 + 0.05) * random.nextDouble();
        saldo += saldo * variacao;
    }

    @Override
    public String toString() {
        return "Moedas{" + "nome=" + nome + ", saldo=" + saldo + '}';
    }
    
    
}
