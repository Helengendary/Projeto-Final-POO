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
                        System.out.println("ESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 1;
                    }
                    break;

                case 2:
                    System.out.println("\nMenu Dono da Loja\n5 - Entrar\n6 - Cadastrar\n1 - Voltar\n");
                    locate = scan.nextInt();

                    if (locate != 5 && locate != 6 && locate != 1) {
                        System.out.println("ESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 2;
                    }
                    break;

                case 3:
                    System.out.println("\nMenu Usuário\n7 - Entrar\n8 - Cadastrar\n1 - Voltar\n");
                    locate = scan.nextInt();

                    if (locate != 7 && locate != 8 && locate != 1) {
                        System.out.println("ESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 3;
                    }
                    break;

                case 4:
                    System.out.println("\nMenu Registrar Loja\n18 - Ver\n19 - Registrar\n1 - Voltar");
                    locate = scan.nextInt();
                    if (locate != 18 && locate != 19 && locate != 1) {
                        System.out.println("ESTA OPÇÃO NÃO É VÁLIDA!");
                        locate = 4;
                    }
                    break;

                case 5:
                    int indexDonoAtual;
                    for(indexDonoAtual = 0; indexDonoAtual < Donos.size(); ++indexDonoAtual) {
                        Donos.get(indexDonoAtual).verPerfil(indexDonoAtual);
                    }

                    indexDonoAtual = scan.nextInt();
                    atual = (Dono)Donos.get(indexDonoAtual);
                    System.out.println("Entrado como " + atual.getNome());
                    locate = 9;
                    break;

                default:
                    System.out.println("Ta no default");
            }
        }
    }
}