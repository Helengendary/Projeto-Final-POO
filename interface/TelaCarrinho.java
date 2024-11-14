import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaCarrinho {

    private JFrame frame;
    private ArrayList<Produto> carrinho;

    public TelaCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
        frame = new JFrame("Carrinho de Compras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        double total = 0;

        // Exibe os produtos no carrinho
        for (Produto produto : carrinho) {
            // Exibindo a imagem do produto
            JLabel imgLabel = new JLabel(new ImageIcon(produto.getImagem()));
            imgLabel.setHorizontalAlignment(JLabel.CENTER);

            // Exibindo nome e preço
            JLabel label = new JLabel(produto.getNome() + " - R$" + produto.getPreco());
            panel.add(imgLabel);
            panel.add(label);
            total += produto.getPreco();
        }

        // Exibe o total do carrinho
        JLabel totalLabel = new JLabel("Total: R$" + total);
        panel.add(totalLabel);

        // Painel para os botões
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new FlowLayout());  // Use FlowLayout para os botões ficarem bem distribuídos

        // Botão para voltar à tela de produtos
        JButton btnVoltar = new JButton("Voltar aos Produtos");
        btnVoltar.addActionListener(e -> {
            frame.dispose();
            new TelaProdutos(carrinho);  // Passa o carrinho para a tela de produtos
        });
        botaoPanel.add(btnVoltar);

        // Botão para finalizar a compra
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Compra Finalizada com Sucesso!");
            frame.dispose();  // Fecha a tela de carrinho
        });
        botaoPanel.add(btnFinalizarCompra);

        // Botão para cancelar um produto
        JButton btnCancelarProduto = new JButton("Cancelar Produto");
        btnCancelarProduto.addActionListener(e -> {
            if (!carrinho.isEmpty()) {
                Produto produtoRemovido = carrinho.remove(carrinho.size() - 1); // Remove o último produto
                JOptionPane.showMessageDialog(frame, "Produto " + produtoRemovido.getNome() + " removido do carrinho!");
                frame.dispose();
                new TelaCarrinho(carrinho);  // Atualiza a tela com o carrinho atualizado
            } else {
                JOptionPane.showMessageDialog(frame, "Carrinho vazio, não há produtos para remover.");
            }
        });
        botaoPanel.add(btnCancelarProduto);

        // Adiciona o painel de botões no painel principal
        panel.add(botaoPanel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
