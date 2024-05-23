
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * A classe ConexaoBancoDados é responsável por gerenciar a conexão com o banco de dados PostgreSQL
 * e inicializar as cotações das criptomoedas caso ainda não estejam inseridas na tabela.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */

/**
     * Estabelece e retorna uma conexão com o banco de dados PostgreSQL.
     *
     * @return A conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro ao estabelecer a conexão.
 */
public class ConexaoBancoDados {
    public Connection getConnection() throws SQLException{
        Connection conexaoBancoDados = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/investidores",
        "postgres", "fei");
        return conexaoBancoDados;
    }
    
    
    /**
     * Inicializa as cotações das criptomoedas no banco de dados, caso a tabela esteja vazia.
     *
     * @param bitcoin O valor inicial do Bitcoin.
     * @param ethereum O valor inicial do Ethereum.
     * @param ripple O valor inicial do Ripple.
     */
    
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
