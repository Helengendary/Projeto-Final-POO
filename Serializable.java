import java.io.*;
import java.util.ArrayList;
import loja.Loja;
import usuario.User;

public class Serializable {

    private static ArrayList<User> clientes = new ArrayList<>();
    private static ArrayList<User> donos = new ArrayList<>();
    private static ArrayList<Loja> lojas = new ArrayList<>();

    public static Integer sizeClientes() throws ClassNotFoundException, IOException {
        clientes = carregarCliente();
        return clientes.size();
    }
    
    public static Integer sizeDonos() throws ClassNotFoundException, IOException {
        donos = carregarDono();
        return donos.size();
    }
    
    public static Integer sizeLojas() throws ClassNotFoundException, IOException {
        lojas = carregarLoja();
        return lojas.size();
    }
    
    public static void salvarCliente(User p) throws IOException, ClassNotFoundException {
        clientes = carregarCliente();
        FileOutputStream fos = new FileOutputStream("clientes.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        clientes.add(p);

        os.writeObject(clientes);
        os.close();
        fos.close();
    }

    public static ArrayList<User> carregarCliente() throws IOException,
    ClassNotFoundException {
        FileInputStream fis = new FileInputStream("clientes.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<User> p = (ArrayList<User>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
    
    public static User getCliente(Integer i) throws IOException,
    ClassNotFoundException {
        return clientes.get(i);
    }

    public static void salvarDono(User p) throws IOException, ClassNotFoundException {
        donos = carregarDono();
        FileOutputStream fos = new FileOutputStream("donos.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        donos.add(p);

        os.writeObject(donos);
        os.close();
        fos.close();
    }

    public static ArrayList<User> carregarDono() throws IOException,
    ClassNotFoundException {
        FileInputStream fis = new FileInputStream("donos.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<User> p = (ArrayList<User>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
    
    public static User getDono(Integer i) throws IOException,
    ClassNotFoundException {
        return donos.get(i);
    }

    public static void salvarLoja(Loja p) throws IOException, ClassNotFoundException {
        lojas = carregarLoja();
        FileOutputStream fos = new FileOutputStream("lojas.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        lojas.add(p);

        os.writeObject(lojas);
        os.close();
        fos.close();
    }

    public static ArrayList<Loja> carregarLoja() throws IOException,
    ClassNotFoundException {
        FileInputStream fis = new FileInputStream("lojas.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ArrayList<Loja> p = (ArrayList<Loja>) is.readObject();

        is.close();
        fis.close();
        return p;
    }
    
    public static Loja getLoja(Integer i) throws IOException,
    ClassNotFoundException {
        return lojas.get(i);
    }
}