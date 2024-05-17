
package Model;

/**
 *
 * @author Jpsab
 */
public class Pessoa {
    private String nome, idade, cpf, senha;

    public Pessoa() {
    }

    public Pessoa(String nome, String idade, String cpf, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
    
    
}
