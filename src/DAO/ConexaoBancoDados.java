
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Jpsab
 */
public class ConexaoBancoDados {
    public Connection getConnection() throws SQLException{
        Connection conexaoBancoDados = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/investidores",
        "postgres", "fei");
        return conexaoBancoDados;
    }
    
    public void inicializarCotacoes(double bitcoin, double ethereum, double ripple) {
        String sqlVerificar = "SELECT COUNT(*) FROM cotacoes";
        String sqlInserir = "INSERT INTO cotacoes (bitcoin, ethereum, ripple) VALUES (?, ?, ?)";

        try (Connection conexao = getConnection();
             PreparedStatement stmtVerificar = conexao.prepareStatement(sqlVerificar);
             ResultSet rs = stmtVerificar.executeQuery()) {

            if (rs.next() && rs.getInt(1) == 0) {
                // A tabela está vazia, inserir valores iniciais
                try (PreparedStatement stmtInserir = conexao.prepareStatement(sqlInserir)) {
                    stmtInserir.setDouble(1, bitcoin);
                    stmtInserir.setDouble(2, ethereum);
                    stmtInserir.setDouble(3, ripple);
                    stmtInserir.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar cotações: ", e);
        }
    }
}
