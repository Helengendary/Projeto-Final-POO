package loja;

import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable{

    private  String Nome;
    private  ArrayList<Produto> Produtos;
    private  Integer TotalVendas;
    private static final long serialVersionUID = 1002L;

    public Loja(String nome) {
        this.Nome = nome;
        this.TotalVendas = 0;
        this.Produtos = new ArrayList<>();
    }

    public void MostrarProdutos() {

        if (Produtos == null) {
            return;
        }

        for (int i = 0; i < Produtos.size(); i++) {

            System.out.println(i + " - "  + Produtos.get(i).getNome() + ", R$" + Produtos.get(i).getPreco());
        }
    }

    public void venderProduto(Produto oldProduto) {
        if (oldProduto.getQuantidade() == 0) {
            System.out.println("Produto Indisponível");
            return;
        }

        oldProduto.setQuantidade(oldProduto.getQuantidade()-1);
        TotalVendas++;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        Produtos = produtos;
    }

    public Integer getTotalVendas() {
        return TotalVendas;
    }

    public void setTotalVendas(Integer totalVendas) {
        TotalVendas = totalVendas;
    }

    
}