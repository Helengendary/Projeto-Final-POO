import java.io.*;
import java.util.ArrayList;
import loja.Loja;
import usuario.User;

public class Serializacao {
    
    // PARTE DO CLIENTE
    public static void salvarCliente( ArrayList<User> lista) throws IOException {

        FileOutputStream fos = new FileOutputStream("clientes.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(lista);
        os.close();
        fos.close();
    }

    public static ArrayList<User> carregarCliente() throws IOException,
    ClassNotFoundException {

        File file = new File("clientes.txt");
        
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        FileInputStream fis = new FileInputStream("clientes.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<User> p = (ArrayList<User>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
    
    
    // PARTE DO DONO
    public static void salvarDono( ArrayList<User> lista) throws IOException {

        FileOutputStream fos = new FileOutputStream("donos.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(lista);
        os.close();
        fos.close();
    }

    public static ArrayList<User> carregarDono() throws IOException,
    ClassNotFoundException {

        File file = new File("donos.txt");

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        FileInputStream fis = new FileInputStream("donos.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<User> p = (ArrayList<User>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
    
    
    // PARTE DA LOJA
    public static void salvarLoja( ArrayList<Loja> lista) throws IOException {

        FileOutputStream fos = new FileOutputStream("lojas.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(lista);
        os.close();
        fos.close();
    }

    public static ArrayList<Loja> carregarLoja() throws IOException,
    ClassNotFoundException {

        File file = new File("lojas.txt");

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        FileInputStream fis = new FileInputStream("lojas.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        @SuppressWarnings("unchecked")
        ArrayList<Loja> p = (ArrayList<Loja>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
}