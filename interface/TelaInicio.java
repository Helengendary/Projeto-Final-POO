import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class TelaInicio {
    JFrame frame;

    public TelaInicio() {
        frame = new JFrame("Bem-vindo à Loja Virtual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Carregar a imagem de fundo
        ImageIcon fundoImagem = new ImageIcon("./interface/imagens/image.png"); // Substitua o caminho da imagem
        JLabel label = new JLabel("Seja muito Bem-Vindo a EShop", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE); // Cor do texto da label

        // Criar o carrinho vazio
        ArrayList<Produto> carrinho = new ArrayList<>();

        // Botão para ver os produtos
        JButton btnProdutos = new JButton("Acessar");
        btnProdutos.addActionListener(e -> {
            frame.dispose();  // Fecha a tela de início
            new TelaProdutos(carrinho);  // Passa o carrinho para a tela de produtos
        });

        // Painel para a tela de início
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Desenha a imagem de fundo
                g.drawImage(fundoImagem.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new BorderLayout());

        // Adicionando a label e o botão ao painel
        panel.add(label, BorderLayout.CENTER);
        panel.add(btnProdutos, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setVisible(true);  // Torna a tela visível
    }

    public static void main(String[] args) {
        // Inicia a tela de boas-vindas
        SwingUtilities.invokeLater(TelaInicio::new);
    }
}
