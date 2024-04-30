package br.com.PizzariaLuigis.model;

public class Ingredientes {
    private int IDIngrediente;
    private String Nome;
    private int QuantidadeEstoque;
    private int UnidadeMedida;

    public Ingredientes(int idIngrediente) {
        this.setIDIngrediente(idIngrediente);
    }
    public Ingredientes() {this(0);}

    public int getIDIngrediente() {
        return IDIngrediente;
    }

    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = IDIngrediente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getQuantidadeEstoque() {
        return QuantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        QuantidadeEstoque = quantidadeEstoque;
    }

    public int getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        UnidadeMedida = unidadeMedida;
    }
}
