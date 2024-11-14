package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import loja.Loja;


public class User implements Serializable {
    private String Nome;
    private String CPF;
    private String CEP;
    private String NumeroCep;
    private String Senha;
    private static final long serialVersionUID = 1001L;

    public User(String nome, String cpf, String cep, String numeroCep, String senha) {
        this.Nome = nome;
        this.CPF = cpf;
        this.CEP = cep;
        this.NumeroCep = numeroCep;
        this.Senha = senha;
    }


    private transient Scanner scan = new Scanner(System.in);

    public User cadastrar(User user, ArrayList<Loja> array){
        
        System.out.print("\nCadatro:\nNome: ");
        user.setNome(scan.nextLine());
        
        System.out.print("CPF:");
        user.setCPF(scan.next());
        
        System.out.print("CEP:");
        user.setCEP(scan.next());
        
        System.out.print("Numero do endereço: ");
        user.setNumeroCep(scan.next());
        
        System.out.print("Senha: ");
        user.setSenha(scan.next());
        scan.nextLine();
        return user;
    }

    public String getNome() {
        return this.Nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getCEP() {
        return this.CEP;
    }

    public String getNumeroCep() {
        return this.NumeroCep;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setCPF(String cPF) {
        this.CPF = cPF;
    }

    public void setCEP(String cEP) {
        this.CEP = cEP;
    }

    public void setNumeroCep(String numeroCep) {
        this.NumeroCep = numeroCep;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
