import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import loja.Loja;
import usuario.Cliente;
import usuario.Dono;
import usuario.User;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Scanner scan = new Scanner(System.in);


        // Criando um objeto Pessoa
        User p1 = new Cliente("helkena", "cpf", "cep", "numero");
        // Salvando o objeto pessoa (isso irá salvar no seu disco)
        Serializable.salvarCliente(p1);
        // Carregando a pessoa que salvamos (aqui carregamos do disco)
        User p2 = Serializable.carregarCliente();
        // Imprimindo informações da pessoa que foi carregada do arquivo 'pessoa.txt'
        System.out.println(p2);


        ArrayList<Loja> Lojas = new ArrayList();
        ArrayList<Dono> Donos = new ArrayList();
        ArrayList<Cliente> Clientes = new ArrayList();
        Dono atual = new Dono(null, null, null, null, null);
        Cliente atualCliente = new Cliente(null, null, null, null);
        boolean dentro = true;
        String locate = "1";
        String beforeLocate = "";
        Exceptions err = new Exceptions();

        FileInputStream stream = new FileInputStream("apresentacao.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while(linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        while(dentro) {
            switch (locate) {
                case "0":
                    dentro = false;
                    
                    break;
                case "1":
                    System.out.print("\nMenu Principal\n2 - Dono de loja\n3 - Usuário\n4 - Registrar Loja\n0 - Fechar\nR:");
                    beforeLocate = scan.next();

                    try {
                        err.verificarValor(beforeLocate, "2|3|4|0|");
                    } catch (VerifyExcepiton e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    locate = beforeLocate;

                    break;

                case "2":
                    System.out.print("\nMenu Dono da Loja\n5 - Entrar\n6 - Cadastrar\n1 - Voltar\nR:");
                    
                    beforeLocate = scan.next();

                    try {
                        err.verificarValor(beforeLocate, "1|5|6|");
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
                        err.verificarValor(beforeLocate, "7|8|1|");
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
                        err.verificarValor(beforeLocate, "1|9|10|");
                    } catch (VerifyExcepiton e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    
                    locate = beforeLocate;
                    break;

                case "5":
                
                    if (Donos.size() == 0) {
                        System.out.println("\nNENHUM DONO CADASTRADO");
                        locate = "2";
                        break;
                    }

                    int indexDonoAtual;
                    for(indexDonoAtual = 0; indexDonoAtual < Donos.size(); ++indexDonoAtual) {
                        Donos.get(indexDonoAtual).verPerfil(indexDonoAtual);
                    }

                    indexDonoAtual = scan.nextInt();
                    scan.nextLine();

                    atual = Donos.get(indexDonoAtual);
                    System.out.println("Entrado como " + atual.getNome());
                    
                    locate = "2";
                    break;
                    
                case "6":
                    
                    if (Lojas.size() == 0) {
                        System.out.println("\nNÃO EXISTEM LOJAS");
                        locate = "2";
                        break;
                    }

                    System.out.print("\nCadatro Dono de Loja\nNome: ");
                    String nomeDono = scan.nextLine();

                    System.out.print("CPF:");
                    String cpfDono = scan.next();

                    System.out.print("CEP:");
                    String cepDono = scan.next();

                    System.out.print("Numero do endereço:");
                    String numeroDono = scan.next();
                    scan.nextLine();

                    int indexLojaDono;
                    for(indexLojaDono = 0; indexLojaDono < Lojas.size(); ++indexLojaDono) {
                        System.out.println(indexLojaDono + " - " + (Lojas.get(indexLojaDono)).getNome());
                    }

                    indexLojaDono = scan.nextInt();
                    scan.nextLine();

                    atual = new Dono(nomeDono, cpfDono, cepDono, numeroDono, Lojas.get(indexLojaDono));
                    System.out.println("Cadastrado e entrado como " + atual.getNome());
                    Donos.add(atual);

                    //arrumar
                    locate = "2";
                    break;
                
                case "7":

                    if (Clientes.size() == 0) {
                        System.out.println("\nNÃO TEM NENHUM CADASTRO");
                        locate = "3";
                        break;
                    }

                    int indexClienteAtual;

                    for(indexClienteAtual = 0; indexClienteAtual < Clientes.size(); ++indexClienteAtual) {
                        Clientes.get(indexClienteAtual).verPerfil(indexClienteAtual);
                    }

                    indexClienteAtual = scan.nextInt();
                    scan.nextLine();

                    atualCliente = Clientes.get(indexClienteAtual);
                    System.out.println("Entrado como " + atualCliente.getNome());

                    locate = "3";
                    break;

                case "8":
                    System.out.print("\nCadatro:\nNome: ");
                    String nomeCliente = scan.nextLine();
                    
                    System.out.print("CPF:");
                    String cpfCliente = scan.next();
                    
                    System.out.print("CEP:");
                    String cepCliente = scan.next();
                    
                    System.out.print("Numero do endereço: ");
                    String numeroCliente = scan.next();
                    scan.nextLine();
                    
                    atualCliente = new Cliente(nomeCliente, cpfCliente, cepCliente, numeroCliente);
                    Clientes.add(atualCliente);
                    System.out.println("Cadastrado e entrado como " + atualCliente.getNome());       
                    
                    scan.useDelimiter("");
                    locate = "3";
                    break;
                
                case "9":

                    if (Lojas.size() == 0) {
                        System.out.println("NÃO HÁ LOJAS CADASTRADAS");
                    }

                    for(int i = 0; i < Lojas.size(); ++i) {
                        
                        System.out.println("Nome: " + Lojas.get(i).getNome());
                        Lojas.get(i).MostrarProdutos();
                        System.out.println("Total de vendas: " + Lojas.get(i).getTotalVendas() + "\n");
                    }

                    locate = "4";
                    break;
                
                case "10":
                    System.out.print("\nNome: ");
                    String newLojaNome = scan.nextLine();

                    Loja newLoja = new Loja(newLojaNome);
                    Lojas.add(newLoja);
                    
                    System.out.println("\nLoja inserida com sucesso.");
                    locate = "4";
                    break;

                default:
                    System.out.println("Ta no default");
                
            }
        }
    }
}