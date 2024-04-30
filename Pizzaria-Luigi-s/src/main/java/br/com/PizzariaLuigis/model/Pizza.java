package br.com.PizzariaLuigis.model;

public class Pizza {
    private int IDPizza;
    private String nome;
    private double preco;
    private String descricao;

    public Pizza(int idPizza) {this.setIDPizza(idPizza);}
    public Pizza() {this(0);}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIDPizza() {return IDPizza;}

    public void setIDPizza(int IDPizza) {this.IDPizza = IDPizza;}
}
