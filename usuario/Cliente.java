package usuario;
import java.util.ArrayList;
import java.util.Iterator;

import loja.Produto;
import loja.Loja.Loja;

public class Cliente extends User {
    private ArrayList<Produto> Carrinho = new ArrayList();

    public Cliente(String nome, String cpf, String cep, Integer numero) {
        super(nome, cpf, cep, numero);
    }

    @Override
    public void verPerfil(int index) {
        System.out.println(index + " - " + this.Nome);
    }

    public void AdicionarCarrinho(Produto prod) {
        if (prod.getQuantidade() > 0) {
            this.Carrinho.add(prod);
            System.out.println("Produto adicionado ao carrinho!");
        } else {
            System.out.println("Produto Indisponivel");
        }

    }

    public void VerCatalogo(ArrayList<Loja> Lojas) {
        for(int i = 0; i < Lojas.size(); ++i) {
            System.out.println("" + i + " - " + ((Loja)Lojas.get(i)).getNome());
            ((Loja)Lojas.get(i)).MostrarProdutos();
        }

    }

    public void Comprar(ArrayList<Loja> Lojas) {
        Iterator var2 = Lojas.iterator();

        while(var2.hasNext()) {
            Loja loja = (Loja)var2.next();
            Iterator var4 = this.Carrinho.iterator();

            while(var4.hasNext()) {
                Produto produto = (Produto)var4.next();
                loja.venderProduto(produto);
            }
        }

        this.Carrinho.clear();
        System.out.println("Compras feitas e carrinho vazio!! :)");
    }

    public void EsvaziarCarrinho() {
        this.Carrinho.clear();
        System.out.println("Carrinho vazio!! :)");
    }

    public ArrayList<Produto> getCarrinho() {
        return this.Carrinho;
    }
}
