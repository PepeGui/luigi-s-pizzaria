package br.com.PizzariaLuigis.model;

public class Ingrediente {
    private int IDIngrediente;
    private String Nome;
    private double QuantidadeEstoque;
    private String Descricao;


    public Ingrediente(int idIngrediente) {
        this.setIDIngrediente(idIngrediente);
    }
    public Ingrediente() {this(0);}
    public Ingrediente(String nome, double qtd, String desc){
        this.Nome = nome;
        this.QuantidadeEstoque = qtd;
        this.Descricao = desc;
    }
    public Ingrediente(int id,String nome, double qtd, String desc){
        this.IDIngrediente = id;
        this.Nome = nome;
        this.QuantidadeEstoque = qtd;
        this.Descricao = desc;
    }



    public int getIDIngrediente() {
        return IDIngrediente;
    }


    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = IDIngrediente;
    }

    public String getNome() {
        return Nome;
    }

    public double getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public String getDescricao() {
        return Descricao;
    }
}
