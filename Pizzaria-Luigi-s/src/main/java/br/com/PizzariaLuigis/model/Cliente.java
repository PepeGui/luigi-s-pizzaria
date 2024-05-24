package br.com.PizzariaLuigis.model;

public class Cliente {
    private int clienteID;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private int numero;
    private String cep;

    public Cliente(int clienteID) {
        this.setClienteID(clienteID);
    }

    public Cliente(String cep, int numero, String endereco, String telefone, String cpf, String nome) {
        this.cep = cep;
        this.numero = numero;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Cliente() {this(0);}

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String CEP) {
        this.cep = CEP;
    }
}
