package br.com.PizzariaLuigis.model;

public class Estoque {
    private int IDEstoque;
    private Ingrediente IDIngrediente;
    private int Quantidade;
    private String DataAtualizacao;

    public int getIDEstoque() {
        return IDEstoque;
    }

    public void setIDEstoque(int IDEstoque) {
        this.IDEstoque = IDEstoque;
    }
    public Ingrediente getIDIngrediente() {
        return IDIngrediente;
    }

    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = new Ingrediente(IDIngrediente);
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public String getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        DataAtualizacao = dataAtualizacao;
    }
}
