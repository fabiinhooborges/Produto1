/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.bean;

import br.com.produto.dao.ProdutoDAO;
import br.com.produto.entity.Produto;
import br.com.produto.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author vinicius
 */

@ManagedBean(name="cadProdutoMB")
@ViewScoped
public class cadProduto {

    private Produto produto;
    private ProdutoDAO produtoDAO;
    private List<Produto> produtos;

    private boolean pnlListar;

    /**
     * Construtor
     */
    public cadProduto() {

        produto = new Produto();
        produtoDAO = new ProdutoDAO();
        produtos = new ArrayList<Produto>();

    }

    public void cadastrarProduto() {

        produtoDAO.salvar(produto);
        Util.mostrarMensagemSucesso("Sucesso!", "Registro Salvo com sucesso!");
    }
    
    public void limpar(){
        produto = new Produto();
    }

    public void deletar(Produto produto) {
        produtoDAO.deletar(produto.getId());
        produtos = produtoDAO.listar();
         Util.mostrarMensagemSucesso("Sucesso!", "Registro Excluído com sucesso!");
    }

    public void listarProdutos() {
        produtos = produtoDAO.listar();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
