
package Model;

/**
 * A classe investidor é subclasse da classe Pessoa, e nela são armazenados 
 * todas as informações pessoais do investidor e sua carteira de saldos.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 * @see Pessoa
 */
public class Investidor extends Pessoa{
    private Carteira carteira;
    
    /**
     * Construtor da classe Investidor.
     * 
     * @param nome O nome do investidor.
     * @param idade A idade do investidor.
     * @param cpf O CPF do investidor.
     * @param senha A senha do investidor.
     * @param carteira A carteira de investimentos do investidor.
     */
    
    public Investidor(String nome, String idade, String cpf, String senha, Carteira carteira) {
        super(nome, idade, cpf, senha);
        
        this.carteira = carteira;
    }
    
    /**
     * Obtém a carteira de investimentos do investidor.
     * 
     * @return A carteira de investimentos do investidor.
     */
    
    public Carteira getCarteira() {
        return carteira;
    }
    
    /**
     * Define a carteira de investimentos do investidor.
     * 
     * @param carteira A nova carteira de investimentos do investidor.
     */
    
    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    
    /**
     * Retorna uma representação em string do investidor.
     * 
     * @return Uma string representando o investidor.
     */
    
    @Override
    public String toString() {
        return "Investidor{" + "carteira=" + carteira + '}';
    }
}
