
package Model;

/**
 *
 * @author Jpsab
 */
public class Investidor extends Pessoa{
    private Carteira carteira;
    private Integer id;
    
    public Investidor(Integer id, String nome, String idade, String cpf, String senha, Carteira carteira) {
        super(nome, idade, cpf, senha);
        this.id = id;
        this.carteira = carteira;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
