/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Controller.SessaoInvestidor;
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
        String sql = "select investidor_id from investidor where cpf = ? and senha = ?";
        String sqlSaldo = "select saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple from saldos where investidor_id = investidor.investidor_id";
        PreparedStatement statement = conexao.prepareStatement(sql);
        //corrigindo problema injeção sql
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
    }
    
    public ResultSet carteiraSaldos(int investidorId) throws SQLException{
        String sql = "SELECT s.saldo_real, s.saldo_bitcoin, s.saldo_ethereum, s.saldo_ripple, i.senha " +
                 "FROM saldos s " +
                 "JOIN investidor i ON s.investidor_id = i.investidor_id " +
                 "WHERE s.investidor_id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, investidorId);
        return statement.executeQuery();
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
    
    public boolean depositarReais(int investidorId, double valor) throws SQLException {
        String sql = "UPDATE saldos SET saldo_real = saldo_real + ? WHERE investidor_id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setInt(2, investidorId);
        int linhasAfetadas = statement.executeUpdate();
        return linhasAfetadas > 0;
    }
    
    public void registrarTransacao(int investidorId, String tipoTransacao, String moeda, double valor) throws SQLException {
        String sql = "INSERT INTO transacoes (investidor_id, tipo_transacao, moeda, valor, data_hora) VALUES (?, ?, ?, ?, current_timestamp)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, investidorId);
        statement.setString(2, tipoTransacao);
        statement.setString(3, moeda);
        statement.setDouble(4, valor);
        statement.executeUpdate();
    }
    
    public boolean sacarReais(int investidorId, double valor) throws SQLException {
        String sql = "UPDATE saldos SET saldo_real = saldo_real - ? WHERE investidor_id = ? AND saldo_real >= ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setDouble(1, valor);
        statement.setInt(2, investidorId);
        statement.setDouble(3, valor);
        int linhasAfetadas = statement.executeUpdate();
        return linhasAfetadas > 0;
    }
    
    
}
    


    
