/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Random;


/**
 * A classe Moedas é uma classe abstrata que é superclasse das classes de todas
 * as moedas, direcionando a elas os métodos de adicionar e retirar saldo e de 
 * variar as cotações das criptos.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public abstract class Moedas {
    protected String nome;
    protected double saldo;
    
    /**
     * Construtor da classe Moedas.
     * 
     * @param nome O nome da moeda.
     * @param saldo O saldo inicial da moeda.
     */
    
    public Moedas(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }
    
    /**
     * Obtém o nome da moeda.
     * 
     * @return O nome da moeda.
     */
    
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome da moeda.
     * 
     * @param nome O novo nome da moeda.
     */
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o saldo da moeda.
     * 
     * @return O saldo da moeda.
     */
    
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Define o saldo da moeda.
     * 
     * @param saldo O novo saldo da moeda.
     */
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /**
     * Adiciona uma quantidade ao saldo da moeda.
     * 
     * @param quantidade A quantidade a ser adicionada ao saldo.
     */
    
    public void adicionarSaldo(double quantidade) {
        this.saldo += quantidade;
    }
    
    /**
     * Retira uma quantidade do saldo da moeda, se houver saldo suficiente.
     * 
     * @param quantidade A quantidade a ser retirada do saldo.
     * @return true se a quantidade foi retirada com sucesso, false se não há saldo suficiente.
     */
    
    public boolean retirarSaldo(double quantidade) {
        if (quantidade <= saldo) {
            saldo -= quantidade;
            return true;
        }
        return false;
    }
    
    /**
     * Varia a cotação da moeda aleatoriamente entre -5% e +5%.
     */
    
    public void variarCotacao() {
        Random random = new Random();
        double variacao = -0.05 + (0.05 + 0.05) * random.nextDouble();
        saldo += saldo * variacao;
    }
    
    /**
     * Retorna uma representação em string da moeda.
     * 
     * @return Uma string representando a moeda.
     */
    
    @Override
    public String toString() {
        return "Moedas{" + "nome=" + nome + ", saldo=" + saldo + '}';
    }
    
    
}
