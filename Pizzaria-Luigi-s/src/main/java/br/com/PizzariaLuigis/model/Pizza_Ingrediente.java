package br.com.PizzariaLuigis.model;

public class Pizza_Ingrediente {
    private Pizza IDPizza;
    private Ingredientes IDIngrediente;

    public void setIDPedido(int idPizza) {
        this.IDPizza = new Pizza(idPizza);
    }

    public Pizza getIDPizza() {
        return IDPizza;
    }

    public Ingredientes getIDIngrediente() {
        return IDIngrediente;
    }

    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = new Ingredientes(IDIngrediente);
    }
}
