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
import java.util.Random;

/**
 * A classe InvestidorConectado possui todos os parametros que fazem a interação
 * do codigo com o banco de dados postgreSQL.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class InvestidorConectado {
    private Connection conexao;

    /**
     * Construtor da classe InvestidorConectado.
     * 
     * @param conexao A conexão com o banco de dados.
     */
    public InvestidorConectado(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Obtém as informações do investidor (nome, idade, senha, saldos) do banco de dados.
     * 
     * @param investidor O investidor cujas informações serão obtidas.
     * @return Um ResultSet contendo as informações do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public ResultSet infoInvestidor(Investidor investidor) throws SQLException {
        String sql = "SELECT nome, idade, senha, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple " +
                     "FROM investidor JOIN saldos ON investidor.cpf = saldos.cpf " +
                     "WHERE investidor.cpf = ? AND investidor.senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        return statement.executeQuery();
    }

    /**
     * Adiciona um novo investidor e cria uma carteira de saldos associada no banco de dados.
     * 
     * @param investidor O investidor a ser adicionado.
     * @return true se o investidor e a carteira foram adicionados com sucesso, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean adicionaInvestidorECarteira(Investidor investidor) throws SQLException {
        String sqlInvestidor = "INSERT INTO investidor (nome, idade, cpf, senha) VALUES (?, ?, ?, ?)";
        String sqlCarteira = "INSERT INTO saldos (cpf, saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple) VALUES (?, 0.0, 0.0, 0.0, 0.0)";

        conexao.setAutoCommit(false);  // Iniciar transação
        try (PreparedStatement stmtInvestidor = conexao.prepareStatement(sqlInvestidor);
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

            // Configura e executa o statement da carteira
            stmtCarteira.setString(1, investidor.getCpf());
            stmtCarteira.executeUpdate();

            conexao.commit();  // Confirma a transação
            return true;
        } catch (SQLException e) {
            conexao.rollback();  // Reverte a transação em caso de erro
            throw e;
        } finally {
            conexao.setAutoCommit(true);  // Restaura o modo auto-commit
        }
    }

    /**
     * Obtém os saldos da carteira do investidor do banco de dados.
     * 
     * @param investidor O investidor cujos saldos serão obtidos.
     * @return Um ResultSet contendo os saldos da carteira do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public ResultSet carteiraSaldos(Investidor investidor) throws SQLException {
        String sql = "SELECT saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple " +
                     "FROM saldos WHERE cpf = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        return statement.executeQuery();
    }

    /**
     * Busca um investidor no banco de dados pelo CPF.
     * 
     * @param cpf O CPF do investidor a ser buscado.
     * @return O objeto Investidor encontrado, ou null se não for encontrado.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public Investidor buscarInvestidorPorCPF(String cpf) throws SQLException {
        String sqlInvestidor = "SELECT nome, idade, cpf, senha FROM investidor WHERE cpf = ?";
        String sqlCarteira = "SELECT saldo_real, saldo_bitcoin, saldo_ethereum, saldo_ripple FROM saldos WHERE cpf = ?";

        try (PreparedStatement stmtInvestidor = conexao.prepareStatement(sqlInvestidor);
             PreparedStatement stmtCarteira = conexao.prepareStatement(sqlCarteira)) {

            stmtInvestidor.setString(1, cpf);
            ResultSet resultadoInvestidor = stmtInvestidor.executeQuery();

            if (resultadoInvestidor.next()) {
                String nome = resultadoInvestidor.getString("nome");
                String idade = resultadoInvestidor.getString("idade");
                String senha = resultadoInvestidor.getString("senha");

                stmtCarteira.setString(1, cpf);
                ResultSet resultadoCarteira = stmtCarteira.executeQuery();

                if (resultadoCarteira.next()) {
                    double saldoReal = resultadoCarteira.getDouble("saldo_real");
                    double saldoBitcoin = resultadoCarteira.getDouble("saldo_bitcoin");
                    double saldoEthereum = resultadoCarteira.getDouble("saldo_ethereum");
                    double saldoRipple = resultadoCarteira.getDouble("saldo_ripple");

                    Carteira carteira = new Carteira(saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
                    return new Investidor(nome, idade, cpf, senha, carteira);
                }
            }
            return null;
        }
    }

    /**
     * Realiza um depósito na conta do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @param valor O valor a ser depositado.
     * @return true se o depósito for realizado com sucesso, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean depositar(String cpf, double valor) throws SQLException {
        String sqlAtualizarSaldo = "UPDATE saldos SET saldo_real = saldo_real + ? WHERE cpf = ?";
        String sqlRegistrarTransacao = "INSERT INTO transacoes (cpf, tipo_transacao, moeda, valor, data_hora) VALUES (?, 'Depósito', 'Real', ?, current_timestamp)";

        conexao.setAutoCommit(false);
        try (PreparedStatement stmtAtualizarSaldo = conexao.prepareStatement(sqlAtualizarSaldo);
             PreparedStatement stmtRegistrarTransacao = conexao.prepareStatement(sqlRegistrarTransacao)) {

            stmtAtualizarSaldo.setDouble(1, valor);
            stmtAtualizarSaldo.setString(2, cpf);
            int linhasAfetadas = stmtAtualizarSaldo.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar saldo.");
            }

            stmtRegistrarTransacao.setString(1, cpf);
            stmtRegistrarTransacao.setDouble(2, valor);
            stmtRegistrarTransacao.executeUpdate();

            conexao.commit();
            return true;
        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        } finally {
            conexao.setAutoCommit(true);
        }
    }

    /**
     * Realiza um saque da conta do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @param valor O valor a ser sacado.
     * @return true se o saque for realizado com sucesso, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean sacar(String cpf, double valor) throws SQLException {
        String sqlVerificarSaldo = "SELECT saldo_real FROM saldos WHERE cpf = ?";
        String sqlAtualizarSaldo = "UPDATE saldos SET saldo_real = saldo_real - ? WHERE cpf = ? AND saldo_real >= ?";
        String sqlRegistrarTransacao = "INSERT INTO transacoes (cpf, tipo_transacao, moeda, valor, data_hora) VALUES (?, 'Saque', 'Real', ?, current_timestamp)";

        conexao.setAutoCommit(false);
        try (PreparedStatement stmtVerificarSaldo = conexao.prepareStatement(sqlVerificarSaldo);
             PreparedStatement stmtAtualizarSaldo = conexao.prepareStatement(sqlAtualizarSaldo);
             PreparedStatement stmtRegistrarTransacao = conexao.prepareStatement(sqlRegistrarTransacao)) {

            stmtVerificarSaldo.setString(1, cpf);
            ResultSet resultado = stmtVerificarSaldo.executeQuery();
            if (!resultado.next() || resultado.getDouble("saldo_real") < valor) {
                throw new SQLException("Saldo insuficiente.");
            }

            stmtAtualizarSaldo.setDouble(1, valor);
            stmtAtualizarSaldo.setString(2, cpf);
            stmtAtualizarSaldo.setDouble(3, valor);
            int linhasAfetadas = stmtAtualizarSaldo.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar saldo.");
            }

            stmtRegistrarTransacao.setString(1, cpf);
            stmtRegistrarTransacao.setDouble(2, valor);
            stmtRegistrarTransacao.executeUpdate();

            conexao.commit();
            return true;
        } catch (SQLException e) {
            conexao.rollback();
            throw e;
        } finally {
            conexao.setAutoCommit(true);
        }
    }

    /**
     * Registra uma transação no banco de dados.
     * 
     * @param cpf O CPF do investidor.
     * @param tipoTransacao O tipo da transação (por exemplo, "Depósito", "Saque").
     * @param moeda A moeda envolvida na transação (por exemplo, "Real", "Bitcoin").
     * @param valor O valor da transação.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void registrarTransacao(String cpf, String tipoTransacao, String moeda, double valor) throws SQLException {
        String sql = "INSERT INTO transacoes (cpf, tipo_transacao, moeda, valor, data_hora) VALUES (?, ?, ?, ?, current_timestamp)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.setString(2, tipoTransacao);
        statement.setString(3, moeda);
        statement.setDouble(4, valor);
        statement.executeUpdate();
    }

    /**
     * Aplica uma variação nas cotações das criptomoedas.
     * 
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void variarCotacao() throws SQLException {
        String sql = "SELECT bitcoin, ethereum, ripple FROM cotacoes ORDER BY data_hora DESC LIMIT 1";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                double bitcoin = rs.getDouble("bitcoin");
                double ethereum = rs.getDouble("ethereum");
                double ripple = rs.getDouble("ripple");

                // Atualizar os valores com a variação
                bitcoin = aplicarVariacao(bitcoin);
                ethereum = aplicarVariacao(ethereum);
                ripple = aplicarVariacao(ripple);

                // Insira os novos valores no banco de dados
                String insertSql = "INSERT INTO cotacoes (bitcoin, ethereum, ripple) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = conexao.prepareStatement(insertSql)) {
                    insertStmt.setDouble(1, bitcoin);
                    insertStmt.setDouble(2, ethereum);
                    insertStmt.setDouble(3, ripple);
                    insertStmt.executeUpdate();
                }
            }
        }
    }

    /**
     * Aplica uma variação aleatória entre -5% e +5% ao valor atual.
     * 
     * @param valorAtual O valor atual da criptomoeda.
     * @return O novo valor com a variação aplicada.
     */
    private double aplicarVariacao(double valorAtual) {
        Random random = new Random();
        double variacao = -0.05 + (0.1 * random.nextDouble()); // Gera uma variação entre -0.05 e 0.05
        return valorAtual + (valorAtual * variacao);
    }

    /**
     * Obtém as cotações mais recentes das criptomoedas.
     * 
     * @return Um ResultSet contendo as cotações mais recentes.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public ResultSet obterCotacoes() throws SQLException {
        String sql = "SELECT bitcoin, ethereum, ripple FROM cotacoes ORDER BY data_hora DESC LIMIT 1";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        return stmt.executeQuery();
    }

    /**
     * Obtém a cotação mais recente de uma criptomoeda específica.
     * 
     * @param criptomoeda O nome da criptomoeda.
     * @return A cotação mais recente da criptomoeda.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public double obterCotacaoCriptomoeda(String criptomoeda) throws SQLException {
        String sql = "SELECT " + criptomoeda.toLowerCase() + " FROM cotacoes ORDER BY data_hora DESC LIMIT 1";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble(criptomoeda.toLowerCase());
        }
        return 0;
    }

    /**
     * Verifica se a senha fornecida corresponde à senha do investidor com o CPF fornecido.
     * 
     * @param cpf O CPF do investidor.
     * @param senha A senha fornecida.
     * @return true se a senha estiver correta, false caso contrário.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public boolean verificarSenha(String cpf, String senha) throws SQLException {
        String sql = "SELECT senha FROM investidor WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("senha").equals(senha);
        }
        return false;
    }

    /**
     * Obtém o saldo em reais do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @return O saldo em reais do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public double obterSaldoReais(String cpf) throws SQLException {
        String sql = "SELECT saldo_real FROM saldos WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("saldo_real");
        }
        return 0;
    }

    /**
     * Obtém o saldo de uma criptomoeda específica do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @param criptomoeda O nome da criptomoeda.
     * @return O saldo da criptomoeda do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public double obterSaldoCriptomoeda(String cpf, String criptomoeda) throws SQLException {
        String sql = "SELECT saldo_" + criptomoeda.toLowerCase() + " FROM saldos WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("saldo_" + criptomoeda.toLowerCase());
        }
        return 0;
    }

    /**
     * Atualiza o saldo em reais do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @param novoSaldo O novo saldo em reais do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void atualizarSaldoReais(String cpf, double novoSaldo) throws SQLException {
        String sql = "UPDATE saldos SET saldo_real = ? WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, novoSaldo);
        stmt.setString(2, cpf);
        stmt.executeUpdate();
    }

    /**
     * Atualiza o saldo de uma criptomoeda específica do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @param criptomoeda O nome da criptomoeda.
     * @param novoSaldo O novo saldo da criptomoeda do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void atualizarSaldo(String cpf, String criptomoeda, double novoSaldo) throws SQLException {
        String sql = "UPDATE saldos SET saldo_" + criptomoeda.toLowerCase() + " = ? WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, novoSaldo);
        stmt.setString(2, cpf);
        stmt.executeUpdate();
    }

    /**
     * Aplica a taxa de compra para uma criptomoeda específica.
     * 
     * @param criptomoeda O nome da criptomoeda.
     * @param quantidade A quantidade de criptomoeda a ser comprada.
     * @return O valor da taxa de compra.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public double aplicarTaxaCompra(String criptomoeda, double quantidade) throws SQLException {
        double taxa = 0;
        if (criptomoeda.equalsIgnoreCase("Bitcoin")) {
            taxa = quantidade * 0.02;
        } else if (criptomoeda.equalsIgnoreCase("Ethereum")) {
            taxa = quantidade * 0.01;
        } else if (criptomoeda.equalsIgnoreCase("Ripple")) {
            taxa = quantidade * 0.01;
        }
        return taxa;
    }

    /**
     * Aplica a taxa de venda para uma criptomoeda específica.
     * 
     * @param criptomoeda O nome da criptomoeda.
     * @param quantidade A quantidade de criptomoeda a ser vendida.
     * @return O valor da taxa de venda.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public double aplicarTaxaVenda(String criptomoeda, double quantidade) throws SQLException {
        double taxa = 0;
        if (criptomoeda.equalsIgnoreCase("Bitcoin")) {
            taxa = quantidade * 0.03;
        } else if (criptomoeda.equalsIgnoreCase("Ethereum")) {
            taxa = quantidade * 0.02;
        } else if (criptomoeda.equalsIgnoreCase("Ripple")) {
            taxa = quantidade * 0.01;
        }
        return taxa;
    }

    /**
     * Obtém o extrato das transações do investidor.
     * 
     * @param cpf O CPF do investidor.
     * @return Um ResultSet contendo o extrato das transações do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public ResultSet obterExtrato(String cpf) throws SQLException {
        String sql = "SELECT data_hora, tipo_transacao, moeda, valor FROM transacoes WHERE cpf = ? ORDER BY data_hora DESC";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        return stmt.executeQuery();
    }

    /**
     * Obtém o nome do investidor com base no CPF fornecido.
     * 
     * @param cpf O CPF do investidor.
     * @return O nome do investidor.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public String obterNomeInvestidor(String cpf) throws SQLException {
        String sql = "SELECT nome FROM investidor WHERE cpf = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("nome");
        }
        return null;
    }
}
    


    
