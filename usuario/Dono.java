package usuario;
import java.util.ArrayList;
import java.util.Scanner;
import loja.Loja;
import loja.Produto;

public class Dono extends User {
    private Loja Loja;

    public Dono(String nome, String cpf, String cep, String numero, Loja loja, String senha) {
        super(nome, cpf, cep, numero, senha);
        this.Loja = loja;
    }

    private transient Scanner scan = new Scanner(System.in);

    @Override
    public User cadastrar(User user, ArrayList<Loja> lojas) {

        Dono dono = (Dono) user;

        System.out.print("\nCadatro Dono de Loja\nNome: ");
        dono.setNome(scan.nextLine());

        System.out.print("CPF:");
        dono.setCPF(scan.next());

        System.out.print("CEP:");
        dono.setCEP(scan.next());

        System.out.print("Numero do endereço:");
        dono.setNumeroCep(scan.next());

        System.out.print("Senha:");
        dono.setNumeroCep(scan.next());
        scan.nextLine();

        int indexLojaDono;
        
        for(indexLojaDono = 0; indexLojaDono < lojas.size(); ++indexLojaDono) {
            System.out.println(indexLojaDono + " - " + lojas.get(indexLojaDono).getNome());
        }

        dono.setLoja(lojas.get(scan.nextInt()));
        scan.nextLine();
        
        return dono;
    }

    public Loja novoProduto(String nome, Float preco, Integer quantidade, Loja loja) {
        Produto produto = new Produto(nome, preco, quantidade, this.Loja);
        loja.getProdutos().add(produto);
        System.out.println("\nProduto registrado com sucesso!");
        return loja;
    }

    public void retirarProduto(Produto produto) {
        System.out.println("\nProduto retirado com sucesso");
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
