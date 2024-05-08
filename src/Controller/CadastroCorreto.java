
package Controller;

import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import Model.Investidor;
import View.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Jpsab
 */
public class CadastroCorreto {
    private Cadastro view;

    public CadastroCorreto(Cadastro view) {
        this.view = view;
    }
    
    public void salvarInvestidor(){
    String nome = view.getTxtNomeCadastro().getText();
    String idade = view.getTxtIdadeCadastro().getText();
    String cpf = view.getTxtCpfCadastro().getText();
    String senha = view.getTxtSenhaCadastro().getText();
    
    if (!cpf.matches("\\d+")) {
        JOptionPane.showMessageDialog(view, "CPF não pode conter caracteres especiais!");
        return;
    }
    
    // Verifica se a senha tem exatamente 6 dígitos
    if (senha.length() != 6 || !senha.matches("\\d+")) {
        JOptionPane.showMessageDialog(view, "Senha deve conter exatamente 6 dígitos!");
        return;
    }
    
    Investidor investidor = new Investidor(nome, idade, cpf, senha);
    ConexaoBancoDados conectar = new ConexaoBancoDados();
    
    try {
        Connection conexao = conectar.getConnection();
        InvestidorConectado conectado = new InvestidorConectado(conexao);
        conectado.adicionaInvestidor(investidor);
        JOptionPane.showMessageDialog(view, "Parabéns, você é um novo investidor!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro ao cadastrar!");
    }
}
}
