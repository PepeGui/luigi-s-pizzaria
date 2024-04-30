package br.com.PizzariaLuigis.model;

public class Pedido {
    private int PedidoID;
    private Cliente ClienteID;
    private String DataPedido;

    public Pedido(int pedidoID) {
        this.setPedidoID(pedidoID);
    }

    public int getPedidoID() {
        return PedidoID;
    }

    public void setPedidoID(int pedidoID) {
        PedidoID = pedidoID;
    }

    public Cliente getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int clienteID) {
        ClienteID = new Cliente(clienteID);
    }

    public String getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(String dataPedido) {
        DataPedido = dataPedido;
    }
}
