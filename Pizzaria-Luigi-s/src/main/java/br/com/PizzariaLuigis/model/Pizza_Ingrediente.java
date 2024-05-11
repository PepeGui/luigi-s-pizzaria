package br.com.PizzariaLuigis.model;

public class Pizza_Ingrediente {
    private Pizza IDPizza;
    private Ingrediente IDIngrediente;

    public void setIDPedido(int idPizza) {
        this.IDPizza = new Pizza(idPizza);
    }

    public Pizza getIDPizza() {
        return IDPizza;
    }

    public Ingrediente getIDIngrediente() {
        return IDIngrediente;
    }

    public void setIDIngrediente(int IDIngrediente) {
        this.IDIngrediente = new Ingrediente(IDIngrediente);
    }
}
