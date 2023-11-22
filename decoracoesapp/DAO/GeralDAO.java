package com.example.decoracoesapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.example.decoracoesapp.Model.Cliente;
import com.example.decoracoesapp.View.Conexao;


public class GeralDAO {
    private Connection conexao;

    public GeralDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionarCliente(Cliente cliente) {
        String sql = "insert into cliente (nome, telefone) values (?,?)";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void adicionarProduto(String nome, double valor, int quantidade) {
        String sql = "INSERT INTO produto (nome, valor, quantidade) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setInt(3, quantidade);

            stmt.execute();

            System.out.println("Produto adicionado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public LinkedList<Cliente> listar() {
        String sql = "select * from cliente";

        try {
            LinkedList<Cliente> clientes = new LinkedList<Cliente>();
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando o objeto Funcionario
                Cliente f = new Cliente(rs.getString("nome"), rs.getString("telefone"));
                f.setId(rs.getInt("id"));

                // Adicionando o objeto à lista
                clientes.add(f);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Cliente> procurar(String nome) {
        String sql = "select * from cliente where nome like ?";

        try {
            LinkedList<Cliente> clientes = new LinkedList<Cliente>();
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, '%' + nome + '%');
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("telefone")
                );
                cliente.setId(rs.getInt("id"));
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente procurar(int telefone) {
        String sql = "select * from cliente where telefone = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, telefone);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("telefone")
                );
                cliente.setId(rs.getInt("id"));

                rs.close();
                stmt.close();

                return cliente;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Cliente cliente) {
        String sql = "update funcionario set nome=?, email=?, cargo=? where id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setLong(4, cliente.getId());// ?????????????????????????????????????????????????????????????????????????????????????????????
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Cliente cliente) {
        String sql = "delete from funcionario where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> listarnomes() {
        String sql = "select nome from cliente";

        try {
            LinkedList<String> nomes = new LinkedList<String>();
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Adicionando o objeto à lista
                nomes.add(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            return nomes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
