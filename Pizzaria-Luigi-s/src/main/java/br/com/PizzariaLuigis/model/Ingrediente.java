package br.com.PizzariaLuigis.model;

public class Ingrediente {
    private int IDIngrediente;
    private String nome;
    private double quantidadeEstoque;
    private String descricao;


    public Ingrediente(int idIngrediente) {
        this.setIDIngrediente(idIngrediente);
    }
    public Ingrediente() {this(0);}
    public Ingrediente(String nome, double qtd, String desc){
        this.nome = nome;
        this.quantidadeEstoque = qtd;
        this.descricao = desc;
    }
    public Ingrediente(int id,String nome, double qtd, String desc){
        this.IDIngrediente = id;
        this.nome = nome;
        this.quantidadeEstoque = qtd;
        this.descricao = desc;
    }



    public int getIDIngrediente() {
        return IDIngrediente;
    }


    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = IDIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }
}
