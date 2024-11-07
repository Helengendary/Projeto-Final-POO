import java.io.*;
import usuario.User;

public class Serializable {
    public static void salvarCliente(User p) throws IOException {
        // Criamos um objeto que irá especificar o arquivo onde o objeto 'p'
        // será salvo. A extensão do arquivo não precisa ser necessariamente '.p'.
        // Eu poderia colocar qualquer extensão.
        FileOutputStream fos = new FileOutputStream("clientes.txt");
        // Aqui criamos um outro objeto que é responsável por converter nosso
        // objeto 'p' em um formato que pode ser reconstruído posteriormente
        ObjectOutputStream os = new ObjectOutputStream(fos);
        // Escreve o objeto 'p' no arquivo
        os.writeObject(p);
        // Fecha o objeto de serialização
        os.close();
        // Fechamos o arquivo
        fos.close();
    }

    public static User carregarCliente() throws IOException,
    ClassNotFoundException {
        // Criamos um objeto que irá especificar o arquivo onde está salvo um objeto.
        FileInputStream fis = new FileInputStream("clientes.txt");
        // Aqui criamos um objeto que irá reconstruir o objeto armazenado no
        // 'fis' criado anteriormente
        ObjectInputStream is = new ObjectInputStream(fis);
        // Lemos o objeto e convertemos ele do arquivo 'pessoa.txt'. Na sequência nós
        // convertemos o objeto para o tipo 'Pessoa'
        User p = (User) is.readObject();
        // Fechamos o objeto de serialização
        is.close();
        // Fechamos o arquivo
        fis.close();
        return p;
    }
    
    public static void salvarDono(User p) throws IOException {
        // Criamos um objeto que irá especificar o arquivo onde o objeto 'p'
        // será salvo. A extensão do arquivo não precisa ser necessariamente '.p'.
        // Eu poderia colocar qualquer extensão.
        FileOutputStream fos = new FileOutputStream("donos.txt");
        // Aqui criamos um outro objeto que é responsável por converter nosso
        // objeto 'p' em um formato que pode ser reconstruído posteriormente
        ObjectOutputStream os = new ObjectOutputStream(fos);
        // Escreve o objeto 'p' no arquivo
        os.writeObject(p);
        // Fecha o objeto de serialização
        os.close();
        // Fechamos o arquivo
        fos.close();
    }

    public static User carregarDono() throws IOException,
    ClassNotFoundException {
        // Criamos um objeto que irá especificar o arquivo onde está salvo um objeto.
        FileInputStream fis = new FileInputStream("donos.txt");
        // Aqui criamos um objeto que irá reconstruir o objeto armazenado no
        // 'fis' criado anteriormente
        ObjectInputStream is = new ObjectInputStream(fis);
        // Lemos o objeto e convertemos ele do arquivo 'pessoa.txt'. Na sequência nós
        // convertemos o objeto para o tipo 'Pessoa'
        User p = (User) is.readObject();
        // Fechamos o objeto de serialização
        is.close();
        // Fechamos o arquivo
        fis.close();
        return p;
    }
}