/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Investidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String sql = "select * from investidor where usuario = ? and senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        //corrigindo problema injeção sql
        statement.setString(1, investidor.getNome());
        statement.setString(2, investidor.getIdade());
        statement.setString(2, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void adicionaInvestidor(Investidor investidor) throws SQLException{
        String sql = "insert into investidor (nome, idade, cpf, senha) values ('" +
                        investidor.getNome() + "', '" +
                        investidor.getIdade() + "', '" +
                        investidor.getCpf() + "', '" +
                        investidor.getSenha() + "')";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    }
    
    public void excluirInvestidor(Investidor investidor) throws SQLException{
        String sql = "delete from investidor where cpf = ? and senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        conexao.close();
    }
}
