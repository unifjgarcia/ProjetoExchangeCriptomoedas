
package Model;

/**
 * A classe Pessoa é a superclasse de todo o projeto, que possui as informações
 * pessoais da pessoa que quer se tornar um investidor.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class Pessoa {
    private String nome, idade, cpf, senha;
    

    public Pessoa() {
    }
    
    
    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome O nome da pessoa.
     * @param idade A idade da pessoa.
     * @param cpf O CPF da pessoa.
     * @param senha A senha da pessoa.
     */
    public Pessoa(String nome, String idade, String cpf, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
    }

    /**
     * Obtém o nome da pessoa.
     * 
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a idade da pessoa.
     * 
     * @return A idade da pessoa.
     */
    public String getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     * 
     * @param idade A nova idade da pessoa.
     */
    public void setIdade(String idade) {
        this.idade = idade;
    }

    /**
     * Obtém o CPF da pessoa.
     * 
     * @return O CPF da pessoa.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     * 
     * @param cpf O novo CPF da pessoa.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém a senha da pessoa.
     * 
     * @return A senha da pessoa.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha da pessoa.
     * 
     * @param senha A nova senha da pessoa.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna uma representação em string da pessoa.
     * 
     * @return Uma string representando a pessoa.
     */
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
}
