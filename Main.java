import exception.Exceptions;
import exception.VerifyExcepiton;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import loja.Loja;
import loja.Produto;
import pagamento.Boleto;
import pagamento.Cartao;
import pagamento.Pix;
import usuario.Cliente;
import usuario.Dono;
import usuario.User;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        try (Scanner scan = new Scanner(System.in)) {
            User atualDono = new Dono(null, null, null, null, null, null);
            User atualCliente = new Cliente(null, null, null, null, null);

            ArrayList<User> clientes = new ArrayList<>();
            ArrayList<User> donos = new ArrayList<>();
            ArrayList<Loja> lojas = new ArrayList<>();
            ArrayList<Produto> produtos = new ArrayList<>();

            Boolean repete = false;
            String senhaInserida = "";
            boolean dentro = true;
            String locate = "1";
            String beforeLocate = "";
            Exceptions err = new Exceptions();
            FileInputStream stream = new FileInputStream("apresentacao.txt");
            InputStreamReader reader = new InputStreamReader(stream);
            try (BufferedReader br = new BufferedReader(reader)) {
                String linha = br.readLine();

                while(linha != null) {
                    System.out.println(linha);
                    linha = br.readLine();
                }
            }
            while(dentro) {
                switch (locate) {
                    case "0": 
                        dentro = false;
                        break;
                    case "1":
                        System.out.print("\nMenu Principal\n2 - Dono de loja\n3 - Usuário\n4 - Registrar Loja\n0 - Fechar\nR:");
                        beforeLocate = scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "2|3|4|0|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        locate = beforeLocate;
                        break;
                    case "2":
                        System.out.print("\nMenu Dono da Loja\n5 - Entrar\n6 - Cadastrar\n1 - Voltar\nR:");
                        beforeLocate = scan.nextLine();
                        

                        try {
                            Exceptions.verificarValor(beforeLocate, "1|5|6|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        locate = beforeLocate;
                        break;

                    case "3":
                        System.out.print("\nMenu Usuário\n7 - Entrar\n8 - Cadastrar\n1 - Voltar\nR:");
                        beforeLocate = scan.next();
                        scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "7|8|1|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        
                        locate = beforeLocate;
                        break;

                    case "4":
                        System.out.println("\nMenu Registrar Loja\n9 - Ver\n10 - Registrar\n1 - Voltar\nR:");
                        
                        beforeLocate = scan.next();
                        scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "1|9|10|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        
                        locate = beforeLocate;
                        break;

                    case "5":
                        donos = Serializacao.carregarDono();

                        if (donos.isEmpty()) {
                            System.out.println("\nNENHUM DONO CADASTRADO");
                            locate = "2";
                            break;
                        }

                        int indexDonoAtual;
                        for(indexDonoAtual = 0; indexDonoAtual < donos.size(); ++indexDonoAtual) {
                            Dono dono = (Dono) donos.get(indexDonoAtual);
                            System.out.println(indexDonoAtual + " - " + dono.getNome() + " (" + dono.getLoja().getNome() + ")");
                        }

                        indexDonoAtual = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Insira sua senha: ");
                        senhaInserida = scan.nextLine();
                        
                        if (senhaInserida.equals(donos.get(indexDonoAtual).getSenha())) {
                            atualDono = donos.get(indexDonoAtual);
                            System.out.println("Entrado como " + atualDono.getNome());
                            locate = "11";
                        } else {
                            System.out.println("Senha incorreta!");
                            locate = "2";
                        }   
                        break;
                        
                    case "6":
                        lojas = Serializacao.carregarLoja();

                        if (lojas.isEmpty()) {
                            System.out.println("\nNÃO EXISTEM LOJAS");
                            locate = "2";
                            break;
                        }

                        User dono = new Dono(null, null, null, null, null, null);

                        atualDono = dono.cadastrar(dono, lojas);

                        donos = Serializacao.carregarDono();

                        repete = false;

                        for (User donoNome : donos) {
                            if(atualDono.getNome().equals(donoNome.getNome())) {
                                repete = true;
                            }
                        }

                        if (repete) {
                            System.out.println("ESSE NOME JÁ EXISTE!");
                        } else {
                            System.out.println("Cadastrado e entrado como " + atualDono.getNome());
    
                            donos.add(atualDono);
                            Serializacao.salvarDono(donos);
                            locate = "11";
                        }


                        break;
                    
                    case "7":
                        clientes = Serializacao.carregarCliente();

                        if (clientes.isEmpty()) {
                            System.out.println("\nNÃO TEM NENHUM CADASTRO");
                            locate = "3";
                            break;
                        }

                        int indexClienteAtual;

                        for(indexClienteAtual = 0; indexClienteAtual < clientes.size(); ++indexClienteAtual) {
                            System.out.println(indexClienteAtual + " - " + clientes.get(indexClienteAtual).getNome());
                        }

                        indexClienteAtual = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Insira sua senha: ");
                        senhaInserida = scan.nextLine();
                        
                        if (senhaInserida.equals(clientes.get(indexClienteAtual).getSenha())) {
                            atualCliente = clientes.get(indexClienteAtual);
                            System.out.println("Entrado como " + atualCliente.getNome());
                            locate = "15";
                        } else {
                            System.out.println("Senha incorreta!");
                            locate = "3";
                        }   

                        break;

                    case "8":
                        Cliente newcli = new Cliente(null, null, null, null, null);

                        atualCliente = newcli.cadastrar(newcli, lojas);

                        repete = false;

                        clientes = Serializacao.carregarCliente();

                        for (User CliNome : clientes) {
                            if(atualCliente.getNome().equals(CliNome.getNome())) {
                                repete = true;
                            }
                        }

                        if (repete) {
                            System.out.println("ESSE NOME JÁ EXISTE!");
                        } else {
                            System.out.println("Cadastrado e entrado como " + atualCliente.getNome());
    
                            clientes.add(atualCliente);
                            Serializacao.salvarCliente(clientes);
                            System.out.println("Cadastrado e entrado como " + atualCliente.getNome());
                            
                            locate = "15";
                        }


                        clientes = Serializacao.carregarCliente();
                        clientes.add(atualCliente);
                        Serializacao.salvarCliente(clientes);
                        System.out.println("Cadastrado e entrado como " + atualCliente.getNome());
                        
                        locate = "15";
                        break;
                    
                    case "9":
                        lojas = Serializacao.carregarLoja();

                        if (lojas.isEmpty()) {
                            System.out.println("NÃO HÁ LOJAS CADASTRADAS");
                        }

                        for(int i = 0; i < lojas.size(); ++i) {
                            
                            System.out.println("Nome: " + lojas.get(i).getNome());
                            lojas.get(i).MostrarProdutos();
                            System.out.println("Total de vendas: " + lojas.get(i).getTotalVendas() + "\n");
                        }

                        locate = "4";
                        break;
                    
                    case "10":
                        lojas = Serializacao.carregarLoja();

                        System.out.print("\nNome: ");
                        String newLojaNome = scan.nextLine();

                        Loja newLoja = new Loja(newLojaNome);

                        lojas.add(newLoja);

                        Serializacao.salvarLoja(lojas);
                        
                        System.out.println("\nLoja inserida com sucesso.");
                        locate = "4";
                        break;
                    
                    case "11":
                        System.out.println("\nMENU DO DONO\n12 - Registrar Produto\n13 - Excluir Produto\n14 - Ver produtos\n2 - Voltar");
                        beforeLocate = scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "12|13|14|2|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        locate = beforeLocate;

                        break;
                    
                    case "12":

                        lojas = Serializacao.carregarLoja();

                        System.out.print("\nCadastro de Produto\nNome: ");
                        String nomeNewProduto = scan.next();
                        scan.nextLine();
                        System.out.print("Preço: ");
                        String precoStringToFloat = scan.nextLine();
                        Float precoNewProduto = Float.parseFloat(precoStringToFloat);
                        System.out.print("Quantidade: ");
                        int quantNewProduto = scan.nextInt();
                        scan.nextLine();

                        Dono donoProduto = (Dono) atualDono;

                        lojas = Serializacao.carregarLoja();

                        for (int i = 0; i < lojas.size(); i++) {
                            if (lojas.get(i).getNome().equals(donoProduto.getLoja().getNome())) {
                                lojas.set( i, donoProduto.novoProduto(nomeNewProduto, precoNewProduto, quantNewProduto, donoProduto.getLoja()));
                            }
                        }

                        for (int i = 0; i < donos.size(); i++) {
                            if (donos.get(i).equals(atualDono)) {
                                donos.set(i, donoProduto);
                            }
                        }

                        Serializacao.salvarLoja(lojas);
                        Serializacao.salvarDono(donos);

                        locate = "11";
                        break;

                    case "13":
                        Dono donoExcluir = (Dono) atualDono;
                        
                        produtos = donoExcluir.getLoja().getProdutos();

                        if (produtos.size() > 0) {
                            int indexProdutoExcluir;
                            for(indexProdutoExcluir = 0; indexProdutoExcluir < produtos.size(); ++indexProdutoExcluir) {
                                System.out.println("" + indexProdutoExcluir + " - " + produtos.get(indexProdutoExcluir).getNome());
                            }
    
                            String excloi = scan.nextLine();
                            // criar exception para validar se é do tamanho do array e se é numero e transformar em string
                            produtos.remove(indexProdutoExcluir);
                        } else {
                            System.out.println("NENHUM PRODUTO CADASTRADO!");
                        }
                        
                        locate = "11";
                        break;
                    
                    case "14":
                        Dono donoprodutos = (Dono) atualDono;
                        
                        produtos = donoprodutos.getLoja().getProdutos();

                        if (produtos.size() > 0) {
                            int indexProdutoExcluir;
                            for(indexProdutoExcluir = 0; indexProdutoExcluir < produtos.size(); ++indexProdutoExcluir) {
                                System.out.println(produtos.get(indexProdutoExcluir).getNome()+"\n\t"+"R$"+produtos.get(indexProdutoExcluir).getPreco()+"\n\t"+"Quantidade"+produtos.get(indexProdutoExcluir).getQuantidade());
                            }

                        } else {
                            System.out.println("NENHUM PRODUTO CADASTRADO!");
                        }
                        
                        locate = "11";
                        break; 
                    case "15":
                        System.out.println("\nMENU CLIENTE:\n16 - Ir as compras\n17 - Ver Carrinho\n3 - Voltar\n");
                        beforeLocate = scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "16|17|3|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        locate = beforeLocate;
                        break;
                    case "16":
                        lojas = Serializacao.carregarLoja();
                        Cliente clienteCatalogo = (Cliente) atualCliente;
                        clienteCatalogo.VerCatalogo(lojas);

                        System.out.println("Numero da loja que deseja comprar: ");
                        int compraLoja = scan.nextInt();
                        
                        System.out.println("Numero do produto que deseja adicionar ao carrinho: ");
                        int compraProduto = scan.nextInt();
                        scan.nextLine();

                        clienteCatalogo.AdicionarCarrinho(lojas.get(compraLoja).getProdutos().get(compraProduto));

                        clientes = Serializacao.carregarCliente();

                        for (int i = 0; i < clientes.size(); i++) {
                            if (clientes.get(i).getNome().equals(atualCliente.getNome())) {
                                clientes.set(i, clienteCatalogo);
                                System.err.println("\natualizou o cliente");
                            }
                        }

                        Serializacao.salvarCliente(clientes);

                        locate = "15";      
                        break;
                    case "17":
                        Cliente clienteCarrinho = (Cliente) atualCliente;

                        for (int i = 0; i < clienteCarrinho.getCarrinho().size(); i++) {
                            System.out.println(i + " - " + clienteCarrinho.getCarrinho().get(i).getNome() + ", R$ " + clienteCarrinho.getCarrinho().get(i).getPreco());
                        }
        
                        System.out.println("\nMEU CARRINHO\n18 - Realizar Compra\n19 - Esvaziar Carrinho\n15 - Voltar\n");
                        beforeLocate = scan.nextLine();

                        try {
                            Exceptions.verificarValor(beforeLocate, "18|19|15|");
                        } catch (VerifyExcepiton e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        locate = beforeLocate;
                        break;
                    case "18":
                        System.out.println("\nSELECIONE O MÉTODO DE PAGAMENTO\n1 - Cartão\n2 - Boleto\n3 - Pix\n");
                        int metodoPag = scan.nextInt();
                        scan.nextLine();

                        switch (metodoPag) {
                            case 1:
                                Cliente clientePagar = (Cliente) atualCliente;
                                
                                System.out.println("Número do cartão: ");
                                String numCad = scan.nextLine();
                                
                                System.out.println("Validade: ");
                                String vali = scan.nextLine();
                                
                                System.out.println("CVV: ");
                                String cvv = scan.nextLine();

                                double total = 0;
                                for (Produto prod : clientePagar.getCarrinho()) {
                                    total += prod.getPreco();
                                }

                                Cartao cartao = new Cartao(total, numCad, vali, cvv);

                                cartao.processarPagamento(cartao.autorizarPagamento(senhaInserida, clientePagar), clientePagar);
                                break;
                            case 2:
                                Cliente clienteBoleto = (Cliente) atualCliente;

                                double totalBoleto = 0;
                                for (Produto prod : clienteBoleto.getCarrinho()) {
                                    totalBoleto += prod.getPreco();
                                }

                                Boleto boleto = new Boleto(totalBoleto);

                                boleto.processarPagamento(boleto.autorizarPagamento(senhaInserida, clienteBoleto), clienteBoleto);

                                break;
                            case 3:
                                Cliente clientePix = (Cliente) atualCliente;

                                double totalPix = 0;
                                for (Produto prod : clientePix.getCarrinho()) {
                                    totalPix += prod.getPreco();
                                }

                                Pix pix = new Pix(totalPix);

                                pix.processarPagamento(pix.autorizarPagamento(senhaInserida, clientePix), clientePix);

                                break;
                            default:
                                throw new AssertionError();
                            }
                        locate = "15";
                        break;
                    default:
                        System.out.println("Ta no default");
                        break;
                }
            }

        }
    }
}