import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaProdutos {

    private JFrame frame;
    private ArrayList<Produto> carrinho; // Agora o carrinho é passado como parâmetro

    public TelaProdutos(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho; // Recebe o carrinho da tela anterior
        frame = new JFrame("Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Definindo o fundo da tela
        JLabel background = new JLabel(new ImageIcon("./interface/imagens/image.png"));
        background.setLayout(new BorderLayout());
        frame.setContentPane(background);

        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10)); // Ajuste para 3 colunas
        panel.setOpaque(false); // Torna o painel transparente

        // Definindo os 12 produtos com nome, preço e imagem
        String[] produtos = {
            "Batom MAC Vermelho", "Lápis Melu", "Mascara de Cilios Melu", "Saga Harry Potter", "Óculos de Sol", "Porta Joias",
            "Carregador Iphone", "Creme Wella", "Natura Una", "Blusa Naruto", "Capinhas de celular personalizadas", "Luminárias e luzes LED decorativas"
        };

        double[] precos = {
            55.0, 12.0, 30.0, 210.0, 50.0, 30.0, 70.0, 110.0, 285.0, 60.0, 20.0, 120.0
        };

        String[] imagens = {
            "./interface/imagens/batom.jpeg", "./interface/imagens/lapis.jpeg", "./interface/imagens/rimel.jpg", 
            "./interface/imagens/sagaHP.jpeg", "./interface/imagens/oculos.jpeg", "./interface/imagens/joias.jpeg", 
            "./interface/imagens/carregador.jpeg", "./interface/imagens/wella.jpeg", "./interface/imagens/una.jpeg", 
            "./interface/imagens/naruto.jpeg", "./interface/imagens/capinha.jpeg", "./interface/imagens/luminaria.jpeg"
        };

        // Loop para criar os painéis de produtos
        for (int i = 0; i < produtos.length; i++) {
            JPanel produtoPanel = new JPanel(new BorderLayout());
            produtoPanel.setOpaque(false); // Transparente para exibir o fundo

            // Carregando a imagem do produto
            JLabel imgLabel = new JLabel(new ImageIcon(imagens[i]));
            imgLabel.setHorizontalAlignment(JLabel.CENTER); // Alinhamento da imagem

            // Exibindo o nome e preço do produto
            JLabel infoLabel = new JLabel(produtos[i] + " - R$" + precos[i], JLabel.CENTER);

            // Botão de adicionar ao carrinho
            JButton btnAdd = new JButton("Adicionar ao Carrinho");
            int index = i;
            btnAdd.addActionListener(e -> {
                // Criando o produto e passando o nome, preço e imagem
                Produto produto = new Produto(produtos[index], precos[index], imagens[index]);
                carrinho.add(produto);  // Adiciona o produto ao carrinho
                JOptionPane.showMessageDialog(frame, produtos[index] + " adicionado ao carrinho!");  // Exibe a mensagem
            });

            produtoPanel.add(imgLabel, BorderLayout.CENTER);
            produtoPanel.add(infoLabel, BorderLayout.NORTH);
            produtoPanel.add(btnAdd, BorderLayout.SOUTH);

            panel.add(produtoPanel);
        }

        // ScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Botão para ir ao carrinho
        JButton btnCarrinho = new JButton("Ver Carrinho");
        btnCarrinho.addActionListener(e -> {
            frame.dispose();  // Fecha a tela de produtos
            new TelaCarrinho(carrinho);  // Abre a tela do carrinho
        });

        // Organizando o layout no fundo
        background.add(scrollPane, BorderLayout.CENTER);
        background.add(btnCarrinho, BorderLayout.SOUTH);

        frame.setVisible(true);  // Torna a tela visível
    }
}
