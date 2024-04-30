package br.com.PizzariaLuigis.model;

public class ItemPedido {
    private int ItemID;
    private Pedido PedidoID;
    private String NomeProduto;
    private String Quantidade;

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public Pedido getPedidoID() {
        return PedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.PedidoID = new Pedido(pedidoID);
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String quantidade) {
        Quantidade = quantidade;
    }
}
