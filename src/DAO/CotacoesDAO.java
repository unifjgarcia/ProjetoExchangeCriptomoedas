/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Jpsab
 */
public class CotacoesDAO {
    private Connection conexao;

    public CotacoesDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void variarCotacao() throws SQLException {
        Random random = new Random();
        String sqlSelect = "SELECT cotacao_bitcoin, cotacao_ethereum, cotacao_ripple FROM cotacoes ORDER BY data_atualizacao DESC LIMIT 1";
        String sqlUpdate = "UPDATE cotacoes SET cotacao_bitcoin = ?, cotacao_ethereum = ?, cotacao_ripple = ?, data_atualizacao = current_timestamp";

        try (PreparedStatement statementSelect = conexao.prepareStatement(sqlSelect);
             PreparedStatement statementUpdate = conexao.prepareStatement(sqlUpdate);
             ResultSet resultSet = statementSelect.executeQuery()) {

            if (resultSet.next()) {
                double cotacaoBitcoin = resultSet.getDouble("cotacao_bitcoin");
                double cotacaoEthereum = resultSet.getDouble("cotacao_ethereum");
                double cotacaoRipple = resultSet.getDouble("cotacao_ripple");

                cotacaoBitcoin += cotacaoBitcoin * (-0.05 + (0.05 + 0.05) * random.nextDouble());
                cotacaoEthereum += cotacaoEthereum * (-0.05 + (0.05 + 0.05) * random.nextDouble());
                cotacaoRipple += cotacaoRipple * (-0.05 + (0.05 + 0.05) * random.nextDouble());

                statementUpdate.setDouble(1, cotacaoBitcoin);
                statementUpdate.setDouble(2, cotacaoEthereum);
                statementUpdate.setDouble(3, cotacaoRipple);
                statementUpdate.executeUpdate();
            }
        }
    }
    
    public double getCotacaoBitcoin() throws SQLException {
        return getCotacao("cotacao_bitcoin");
    }

    public double getCotacaoEthereum() throws SQLException {
        return getCotacao("cotacao_ethereum");
    }

    public double getCotacaoRipple() throws SQLException {
        return getCotacao("cotacao_ripple");
    }

    private double getCotacao(String coluna) throws SQLException {
        String sql = "SELECT " + coluna + " FROM cotacoes ORDER BY data_atualizacao DESC LIMIT 1";
        try (PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getDouble(coluna);
            } else {
                throw new SQLException("Cotação não encontrada para a coluna: " + coluna);
            }
        }
    }
}
