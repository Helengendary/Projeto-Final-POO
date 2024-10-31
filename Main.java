import java.util.ArrayList;
import java.util.Scanner;
import loja.Loja;
import usuario.Cliente;
import usuario.Dono;


public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Loja> Lojas = new ArrayList();
        ArrayList<Dono> Donos = new ArrayList();
        ArrayList<Cliente> Clientes = new ArrayList();
        Dono atual = new Dono((String)null, (String)null, (String)null, (Integer)null, (Loja)null);
        Cliente atualCliente = new Cliente((String)null, (String)null, (String)null, (Integer)null);
        boolean dentro = true;
        int locate = 1;

        System.out.println("primeiro vc deve criar uma loja\ndepois um dono de loja\nprodutos\ndepois usuario");

        while(dentro) {
            switch (locate) {
                case 0:
                    dentro = false;
                    
                    break;
                case 1:
                    System.out.print("\nMenu Principal\n2 - Dono de loja\n3 - Usuário\n4 - Registrar Loja\n0 - Fechar\n");
                    locate = scan.nextInt();

                    if (locate != 2 && locate != 3 && locate != 4 && locate != 0) {
                        System.out.println("\nESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 1;
                    }
                    break;

                case 2:
                    System.out.print("\nMenu Dono da Loja\n5 - Entrar\n6 - Cadastrar\n1 - Voltar\n");
                    locate = scan.nextInt();

                    if (locate != 5 && locate != 6 && locate != 1) {
                        System.out.println("\nESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 2;
                    }
                    break;

                case 3:
                    System.out.print("\nMenu Usuário\n7 - Entrar\n8 - Cadastrar\n1 - Voltar\n");
                    locate = scan.nextInt();

                    if (locate != 7 && locate != 8 && locate != 1) {
                        System.out.println("\nESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 3;
                    }
                    break;

                case 4:
                    System.out.println("\nMenu Registrar Loja\n18 - Ver\n19 - Registrar\n1 - Voltar");
                    locate = scan.nextInt();
                    if (locate != 18 && locate != 19 && locate != 1) {
                        System.out.println("\nESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 4;
                    }
                    break;

                case 5:
                
                    if (Donos.size() == 0) {
                        System.out.println("\nNENHUM DONO CADASTRADO");
                        locate = 2;
                        break;
                    }

                    int indexDonoAtual;
                    for(indexDonoAtual = 0; indexDonoAtual < Donos.size(); ++indexDonoAtual) {
                        Donos.get(indexDonoAtual).verPerfil(indexDonoAtual);
                    }

                    indexDonoAtual = scan.nextInt();

                    atual = Donos.get(indexDonoAtual);
                    System.out.println("Entrado como " + atual.getNome());

                    //arrumar
                    locate = 9;
                    break;

                case 6:

                    if (Lojas.size() == 0) {
                        System.out.println("\nNÃO EXISTEM LOJAS");
                        locate = 2;
                        break;
                    }

                    System.out.print("\nCadatro Dono de Loja\nNome: ");
                    String nomeDono = scan.nextLine();
                    scan.nextLine();

                    System.out.print("CPF:");
                    String cpfDono = scan.next();
                    scan.nextLine();

                    System.out.print("CEP:");
                    String cepDono = scan.next();
                    scan.nextLine();

                    System.out.print("Numero do endereço:");
                    int numeroDono = scan.nextInt();
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
                    locate = 3;
                    break;
                
                case 7:

                    if (Clientes.size() == 0) {
                        System.out.println("\nNÃO TEM NENHUM CADASTRO");
                        locate = 3;
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

                    //arrumar
                    locate = 3;
                    break;

                case 8:
                    System.out.print("\nCadatro:\nNome: ");
                    String nomeCliente = scan.nextLine();
                    scan.nextLine();

                    System.out.print("CPF:");
                    String cpfCliente = scan.nextLine();

                    System.out.print("CEP:");
                    String cepCliente = scan.nextLine();

                    System.out.print("Numero do endereço:");
                    int numeroCliente = scan.nextInt();
                    scan.nextLine();

                    atualCliente = new Cliente(nomeCliente, cpfCliente, cepCliente, numeroCliente);
                    System.out.println("Cadastrado e entrado como " + atualCliente.getNome());

                    //arrumar
                    locate = 3;
                    break;

                default:
                    System.out.println("Ta no default");
            }
        }
    }
}