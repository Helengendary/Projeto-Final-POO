package loja;

import java.io.Serializable;

public class Produto implements Serializable {
    private String Nome;
    private Float Preco;
    private Integer Quantidade;
    private Loja Loja;

    public Produto(String nome, Float preco, Integer quantidade, Loja loja) {
        this.Nome = nome;
        this.Preco = preco;
        this.Quantidade = quantidade;
        this.Loja = loja;
    }

    private static final long serialVersionUID = 1L;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Float getPreco() {
        return Preco;
    }

    public void setPreco(Float preco) {
        Preco = preco;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }

    public Loja getLoja() {
        return Loja;
    }

    public void setLoja(Loja loja) {
        Loja = loja;
    }

    
}