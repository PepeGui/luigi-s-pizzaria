package br.com.PizzariaLuigis.model;

public class ItemPedido {
    private int ItemID;
    private Pedido pedidoID;
    private String nomeProduto;
    private String quantidade;

    public ItemPedido(int pedidoID) {
        this.setPedidoID(pedidoID);
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public Pedido getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = new Pedido(pedidoID);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
