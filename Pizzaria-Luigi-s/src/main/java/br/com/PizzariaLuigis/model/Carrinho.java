package br.com.PizzariaLuigis.model;

public class Carrinho {
    private Pedido IDPedido;
    private String FormaPagamento;

    public Pedido getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int idPedido) {
        this.IDPedido = new Pedido(idPedido);
    }

    public String getFormaPagamento() {
        return FormaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        FormaPagamento = formaPagamento;
    }
}
