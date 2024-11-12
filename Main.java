import exception.Exceptions;
import exception.VerifyExcepiton;
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
        User atual = new Dono(null, null, null, null, null);
        User atualCliente = new Cliente(null, null, null, null);
        boolean dentro = true;
        String locate = "1";
        String beforeLocate = "";
        Exceptions err = new Exceptions();
        Serializable serial = new Serializable();
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
                
                    if (Serializable.sizeDonos() == 0) {
                        System.out.println("\nNENHUM DONO CADASTRADO");
                        locate = "2";
                        break;
                    }

                    int indexDonoAtual;
                    for(indexDonoAtual = 0; indexDonoAtual < Serializable.sizeDonos(); ++indexDonoAtual) {
                        Serializable.getDono(indexDonoAtual).verPerfil(indexDonoAtual);
                    }

                    indexDonoAtual = scan.nextInt();
                    scan.nextLine();

                    atual = Serializable.getDono(indexDonoAtual);
                    System.out.println("Entrado como " + atual.getNome());
                    


                    locate = "2";
                    break;
                    
                case "6":
                    
                    if (Serializable.sizeLojas() == 0) {
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
                    for(indexLojaDono = 0; indexLojaDono < Serializable.sizeLojas(); ++indexLojaDono) {
                        System.out.println(indexLojaDono + " - " + (Serializable.getDono(indexLojaDono)).getNome());
                    }

                    indexLojaDono = scan.nextInt();
                    scan.nextLine();

                    atual = new Dono(nomeDono, cpfDono, cepDono, numeroDono, Serializable.getLoja(indexLojaDono));
                    System.out.println("Cadastrado e entrado como " + atual.getNome());
                    Serializable.salvarDono(atual);

                    //arrumar
                    locate = "2";
                    break;
                
                case "7":

                    if (Serializable.sizeClientes() == 0) {
                        System.out.println("\nNÃO TEM NENHUM CADASTRO");
                        locate = "3";
                        break;
                    }

                    int indexClienteAtual;

                    for(indexClienteAtual = 0; indexClienteAtual < Serializable.sizeClientes(); ++indexClienteAtual) {
                        Serializable.getCliente(indexClienteAtual).verPerfil(indexClienteAtual);
                    }

                    indexClienteAtual = scan.nextInt();
                    scan.nextLine();

                    atualCliente = Serializable.getCliente(indexClienteAtual);
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
                    Serializable.salvarCliente(atualCliente);
                    System.out.println("Cadastrado e entrado como " + atualCliente.getNome());       
                    
                    scan.useDelimiter("");
                    locate = "3";
                    break;
                
                case "9":

                    if (Serializable.sizeLojas() == 0) {
                        System.out.println("NÃO HÁ LOJAS CADASTRADAS");
                    }

                    for(int i = 0; i < Serializable.sizeLojas(); ++i) {
                        
                        System.out.println("Nome: " + Serializable.getLoja(i).getNome());
                        Serializable.getLoja(i).MostrarProdutos();
                        System.out.println("Total de vendas: " + Serializable.getLoja(i).getTotalVendas() + "\n");
                    }

                    locate = "4";
                    break;
                
                case "10":
                    System.out.print("\nNome: ");
                    String newLojaNome = scan.nextLine();

                    Loja newLoja = new Loja(newLojaNome);
                    Serializable.salvarLoja(newLoja);
                    
                    System.out.println("\nLoja inserida com sucesso.");
                    locate = "4";
                    break;

                default:
                    System.out.println("Ta no default");
                
            }
        }
    }
}