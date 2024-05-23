/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Investidor;

/**
 * A classe SessaoInvestidor gerencia a sessão do investidor logado no sistema.
 * Ela permite armazenar, recuperar e encerrar a sessão do investidor.

 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class SessaoInvestidor {
    private static Investidor investidor;
    
    /**
     * Obtém o investidor atualmente logado na sessão.
     * 
     * @return O investidor atualmente logado, ou null se não houver nenhum investidor na sessão.
     */
    
    public static Investidor getInvestidor() {
        return investidor;
    }
    
    /**
     * Define o investidor para a sessão atual.
     * 
     * @param investidor O investidor que será definido na sessão.
     */
    
    public static void setInvestidor(Investidor investidor) {
        SessaoInvestidor.investidor = investidor;
    }
    
    /**
     * Encerra a sessão do investidor, limpando o investidor armazenado.
     */
    
    public static void encerrarSessao() {
        investidor = null;
    }
}
