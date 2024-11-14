package usuario;
import java.util.ArrayList;
import loja.Loja;
import loja.Produto;

public class Cliente extends User {
    private ArrayList<Produto> Carrinho = new ArrayList();

    public Cliente(String nome, String cpf, String cep, String numero) {
        super(nome, cpf, cep, numero);
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
            System.out.println("" + i + " - " + (Lojas.get(i)).getNome());
            (Lojas.get(i)).MostrarProdutos();
        }

    }

    public void Comprar(ArrayList<Loja> Lojas) {
    
        for (Loja loja : Lojas) {
            for (Produto produto : this.Carrinho) {
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
