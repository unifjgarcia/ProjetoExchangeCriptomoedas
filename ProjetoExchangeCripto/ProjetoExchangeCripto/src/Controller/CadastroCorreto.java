
package Controller;

import Model.Pessoa;

/**
 *
 * @author Jpsab
 */
public class CadastroCorreto {
    
    public static Pessoa dadosCadastroPessoa(String cpf, String senha){
        Pessoa pessoaCadastrada = new Pessoa();
        pessoaCadastrada.setCpf(cpf);
        pessoaCadastrada.setSenha(senha);
        
        if(pessoaCadastrada.getCpf().equals(cpf) && pessoaCadastrada.getSenha().equals(senha)){
            return pessoaCadastrada;
    }return null; 
    

}
}
