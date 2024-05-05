
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
