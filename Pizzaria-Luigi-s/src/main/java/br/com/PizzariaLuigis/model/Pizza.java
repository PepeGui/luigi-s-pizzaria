package br.com.PizzariaLuigis.model;

public class Pizza {
    private int IDPizza;
    private String nome;
    private double preco;
    private String descricao;
    private String imagePath;

    public Pizza(int idPizza) {this.setIDPizza(idPizza);}
    public Pizza() {this(0);}

    public Pizza(String nome,double preco, String descricao, String imagePath){
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.imagePath = imagePath;
    }
    public Pizza(int id,String nome,double preco, String descricao ){
        this.IDPizza = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getIDPizza() {return IDPizza;}

    public void setIDPizza(int IDPizza) {this.IDPizza = IDPizza;}
}
