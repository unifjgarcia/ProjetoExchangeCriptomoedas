
package projetoexchangecripto;

import DAO.ConexaoBancoDados;
import View.Login;

/** 
 * A classe ProjetoExchangeCripto é a classe main do programa. Ao rodá-lo, 
 * A janela de login é demonstrada ao usuário e caso ainda não tenham sido
 * setados os valores iniciais das criptomoedas, os valores serão setados no 
 * banco de dados.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class ProjetoExchangeCripto {
    public static void main(String[] args) {
        ConexaoBancoDados conexao = new ConexaoBancoDados();
        conexao.inicializarCotacoes(337431.49, 15659.13, 2.6);
        Login janelaLogin = new Login();
        janelaLogin.setVisible(true);
    }
    
}
