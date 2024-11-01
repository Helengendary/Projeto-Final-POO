package usuario;
public abstract class User {
    private String Nome;
    private String CPF;
    private String CEP;
    private Integer NumeroCep;

    public User(String nome, String cpf, String cep, Integer numeroCep) {
        this.Nome = nome;
        this.CPF = cpf;
        this.CEP = cep;
        this.NumeroCep = numeroCep;
    }

    public abstract void verPerfil(int index);

    public String getNome() {
        return this.Nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getCEP() {
        return this.CEP;
    }

    public Integer getNumeroCep() {
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

    public void setNumeroCep(Integer numeroCep) {
        this.NumeroCep = numeroCep;
    }
}
