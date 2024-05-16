/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Carteira;
import Model.Investidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jpsab
 */
public class InvestidorConectado {
    private Connection conexao;

    public InvestidorConectado(Connection conexao) {
        this.conexao = conexao;
    }
    
    public ResultSet infoInvestidor(Investidor investidor) throws SQLException{
        String sql = "select * from investidor where cpf = ? and senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        //corrigindo problema injeção sql
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public boolean adicionaInvestidorECarteira(Investidor investidor) throws SQLException {
        String sqlInvestidor = "INSERT INTO investidor (nome, idade, cpf, senha) VALUES (?, ?, ?, ?)";
        String sqlCarteira = "INSERT INTO saldos (investidor_id, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple) VALUES (?, 0.0, 0.0, 0.0, 0.0)";
        
        conexao.setAutoCommit(false);  // Iniciar transação
        try (PreparedStatement stmtInvestidor = conexao.prepareStatement(sqlInvestidor, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtCarteira = conexao.prepareStatement(sqlCarteira)) {

            // Configura e executa o statement do investidor
            stmtInvestidor.setString(1, investidor.getNome());
            stmtInvestidor.setString(2, investidor.getIdade());
            stmtInvestidor.setString(3, investidor.getCpf());
            stmtInvestidor.setString(4, investidor.getSenha());
            int affectedRows = stmtInvestidor.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao criar Investidor.");
            }

            // Obtém o ID gerado
            try (ResultSet generatedKeys = stmtInvestidor.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int investidorId = generatedKeys.getInt(1);

                    // Configura e executa o statement da carteira
                    stmtCarteira.setInt(1, investidorId);
                    stmtCarteira.executeUpdate();
                } else {
                    throw new SQLException("Falha ao criar Investidor.");
                }
            }

            conexao.commit();  // Confirma a transação
            return true;
        } catch (SQLException e) {
            conexao.rollback();  // Reverte a transação em caso de erro
            throw e;
        } finally {
            conexao.setAutoCommit(true);  // Restaura o modo auto-commit
        }
    }
    
    public boolean verificarSenha(String investidorId, String senha) throws SQLException {
    String sql = "SELECT senha FROM investidor WHERE investidor_id = ?";
    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setInt(1, Integer.parseInt(investidorId));
        stmt.setString(1, senha);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return senha.equals(rs.getString("senha"));
        }
        return false;
    }
    }
    
    public Carteira getSaldo(String investidorId) throws SQLException {
    String sql = "SELECT saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple FROM saldos WHERE investidor_id = ?";
    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        stmt.setString(1, investidorId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Carteira(
                rs.getString("investidor_id"),
                rs.getDouble("saldo_real"),
                rs.getDouble("saldo_bitcoin"),
                rs.getDouble("saldo_ethereum"),
                rs.getDouble("saldo_ripple")
            );
        }
        return null; // Este retorno indica que não foram encontrados dados.
    } catch (SQLException e) {
        throw e; // Aqui você poderia também tratar a exceção ou logar o erro.
    }
}
}
    
