
package Model;

/**
 *
 * @author Jpsab
 */
public class Investidor extends Pessoa{
    private Carteira carteira;
    
    
    public Investidor(String nome, String idade, String cpf, String senha, Carteira carteira) {
        super(nome, idade, cpf, senha);
        this.carteira = carteira;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "Investidor{" + "carteira=" + carteira + '}';
    }
    
    
    
    
}
