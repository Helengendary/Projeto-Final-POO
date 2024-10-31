package usuario;
import loja.Loja;
import loja.Produto;

public class Dono extends User {
    private Loja Loja;

    public Dono(String nome, String cpf, String cep, Integer numero, Loja loja) {
        super(nome, cpf, cep, numero);
        this.Loja = loja;
    }

    @Override
    public void verPerfil(int index) {
        System.out.println(index + " - " + this.Nome + " (" + this.Loja.getNome() + ")");
    }

    public void novoProduto(String nome, Float preco, Integer quantidade, Loja loja) {
        Produto produto = new Produto(nome, preco, quantidade, this.Loja);
        loja.getProdutos().add(produto);
        System.out.println("Produto registrado com sucesso!");
    }

    public void retirarProduto(Produto produto) {
        System.out.println("Produto retirado com sucesso");
        this.Loja.getProdutos().remove(produto);
    }

    public Integer TotalVendasLoja() {
        return this.Loja.getTotalVendas();
    }

    public Loja getLoja() {
        return this.Loja;
    }

    public void setLoja(Loja loja) {
        this.Loja = loja;
    }
}
