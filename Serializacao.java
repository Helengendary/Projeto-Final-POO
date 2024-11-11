import java.io.*;
import java.util.ArrayList;
import usuario.User;

public class Serializacao {

    public static void salvarCliente(User p, ArrayList<User> lista) throws IOException {

        FileOutputStream fos = new FileOutputStream("clientes.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        lista.add(p);

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
}