//package com.example.decoracoesapp.DAO;
//
//import com.example.decoracoesapp.Model.Cliente;
//import com.example.decoracoesapp.View.Conexao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedList;
//
//public class ProdutoDAO {
//    private Connection conexao;
//
//    public ProdutoDAO() {
//        this.conexao = Conexao.getConexao();
//    }
//
//    public void adicionar(Cliente cliente) {
//        String sql = "insert into cliente (nome, email, cargo) values (?,?,?)";
//
//        try {
//            // Criação do Prepared Statement para inserção de um novo Funcionário
//            PreparedStatement stmt = this.conexao.prepareStatement(sql);
//
//            // Setando os valores de acordo com o funcionário recebido por parâmetro
//            stmt.setString(1, cliente.getNome());
//            stmt.setString(3, cliente.getTelefone());
//
//            // Executa e após fecha
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public LinkedList<Cliente> listar() {
//        String sql = "select * from cliente";
//
//        try {
//            LinkedList<Cliente> clientes = new LinkedList<Cliente>();
//            PreparedStatement stmt = this.conexao.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                // Criando o objeto Funcionario
//                Cliente f = new Cliente(rs.getString("nome"), rs.getString("telefone"));
//                f.setId(rs.getInt("id"));
//
//                // Adicionando o objeto à lista
//                clientes.add(f);
//            }
//            rs.close();
//            stmt.close();
//            return clientes;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void remover(Cliente cliente) {
//        String sql = "delete from funcionario where id = ?";
//
//        try {
//            PreparedStatement stmt = conexao.prepareStatement(sql);
//            stmt.setInt(1, cliente.getId());
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
