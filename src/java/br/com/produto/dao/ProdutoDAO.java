/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.dao;

import br.com.produto.entity.Produto;
import br.com.produto.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class ProdutoDAO {

    private final String INSERT = "INSERT INTO Produto (nome, marcar, quantidade, valor) values (?,?,?,?)";
    private final String SELECT = "SELECT * FROM Produto ORDER BY nome";
    private final String DELETE = "DELETE FROM Produto WHERE id = ?";

    public Produto salvar(Produto produto) {
        Conexao conexao = new Conexao();
        PreparedStatement ps;

        try {
            ps = conexao.conectar().prepareStatement(INSERT);

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getMarca());
            ps.setInt(3, produto.getQuantidade());
            ps.setDouble(4, produto.getValor());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);

        } finally {
            conexao.desconectar();
        }

        return produto;
    }

    public List<Produto> listar() {
        Conexao conexao = new Conexao();
        List<Produto> produtos = new ArrayList<Produto>();
        PreparedStatement ps;

        try {
            ps = conexao.conectar().prepareStatement(SELECT);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setMarca(rs.getString("marcar"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("valor"));
                produto.setId(rs.getInt("id"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);

        } finally {
            conexao.desconectar();
        }
        return produtos;
    }

    public void deletar(int id) {
        Conexao conexao = new Conexao();
        PreparedStatement ps;

        try {
            ps = conexao.conectar().prepareStatement(DELETE);

            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);

        } finally {
            conexao.desconectar();
        }

    }
}
