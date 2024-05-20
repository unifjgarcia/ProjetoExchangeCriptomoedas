
package projetoexchangecripto;

import DAO.ConexaoBancoDados;
import View.Login;

/**
 *
 * @author Jpsab
 */
public class ProjetoExchangeCripto {
    public static void main(String[] args) {
        ConexaoBancoDados conexao = new ConexaoBancoDados();
        conexao.inicializarCotacoes(337431.49, 15659.13, 2.6);
        Login janelaLogin = new Login();
        janelaLogin.setVisible(true);
    }
    
}
