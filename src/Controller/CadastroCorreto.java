
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Carteira;
import Model.Investidor;
import View.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 * A classe CadastroCorreto é responsável pelo processo de cadastro de novos investidores.
 
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class CadastroCorreto {
    private Cadastro view;
    
    /**
     * Construtor da classe CadastroCorreto.
     * 
     * @param view A referência à janela de Cadastro.
     */
    
    public CadastroCorreto(Cadastro view) {
        this.view = view;
    }
    
    /**
    * Ela valida os dados de entrada fornecidos pelo usuário, como CPF e senha, e então 
    * salva o novo investidor no banco de dados, juntamente com a criação de uma carteira.
    * Se o cadastro for bem-sucedido, uma mensagem de sucesso é exibida; caso contrário, 
    * uma mensagem de erro é exibida.
    */
    
    public void salvarInvestidor() {
        String nome = view.getTxtNomeCadastro().getText();
        String idade = view.getTxtIdadeCadastro().getText();
        String cpf = view.getTxtCpfCadastro().getText();
        String senha = view.getTxtSenhaCadastro().getText();

        if (!cpf.matches("\\d+")) {
            JOptionPane.showMessageDialog(view, "CPF não pode conter caracteres especiais!");
            return;
        }

        if (senha.length() != 6 || !senha.matches("\\d+")) {
            JOptionPane.showMessageDialog(view, "Senha deve conter exatamente 6 dígitos!");
            return;
        }
        Investidor investidor = new Investidor(nome, idade, cpf, senha, null);
        ConexaoBancoDados conectar = new ConexaoBancoDados();

        try {
            Connection conexao = conectar.getConnection();
            InvestidorConectado conectado = new InvestidorConectado(conexao);
            if (conectado.adicionaInvestidorECarteira(investidor)) {
                JOptionPane.showMessageDialog(view, "Parabéns, você é um novo investidor!");
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao criar investidor!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar! " + e.getMessage());
        }
    }
}
