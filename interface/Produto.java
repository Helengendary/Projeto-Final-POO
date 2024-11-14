public class Produto {
    private String nome;
    private double preco;
    private String imagem; // Adicionando o caminho da imagem

    public Produto(String nome, double preco, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }
}
