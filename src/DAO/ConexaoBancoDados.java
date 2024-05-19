
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO cotacoes (bitcoin, ethereum, ripple) VALUES (?, ?, ?)";
        try (Connection conexao = getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDouble(1, bitcoin);
            stmt.setDouble(2, ethereum);
            stmt.setDouble(3, ripple);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar cotações: ", e);
        }
    }
}
