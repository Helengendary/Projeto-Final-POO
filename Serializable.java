import java.io.*;
import java.util.ArrayList;
import loja.Loja;
import usuario.User;

public class Serializable {

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
    
    public static void salvarCliente(User p, ArrayList<User>) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("clientes.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        clientes.add(p);

        os.writeObject(clientes);
        os.close();
        fos.close();
    }

    @SuppressWarnings("unchecked")
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

        if (carregarDono() == null) {
            System.out.println("É NULLOOO");
        }
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
        try (FileOutputStream fos = new FileOutputStream("lojas.txt"); ObjectOutputStream os = new ObjectOutputStream(fos)) {
            
            lojas.add(p);
            
            os.writeObject(lojas);
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Loja> carregarLoja() throws IOException,
    ClassNotFoundException {
        try {
            ObjectInputStream is;
            try (FileInputStream fis = new FileInputStream("lojas.txt")) {
                is = new ObjectInputStream(fis);
                is.close();
            }
            return (ArrayList<Loja>) is.readObject();
        } catch (EOFException | FileNotFoundException e) {
            return lojas;
        }
    }
    
    public static Loja getLoja(Integer i) throws IOException,
    ClassNotFoundException {
        return lojas.get(i);
    }
}