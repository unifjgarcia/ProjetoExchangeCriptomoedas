
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
 *
 * @author Jpsab
 */
public class CadastroCorreto {
    private Cadastro view;

    public CadastroCorreto(Cadastro view) {
        this.view = view;
    }
    
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
        int investidorId = SessaoInvestidor.getInvestidorId();
        Investidor investidor = new Investidor(investidorId, nome, idade, cpf, senha, null);
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
