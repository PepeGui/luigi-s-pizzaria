package br.com.PizzariaLuigis.model;

public class Pedido {
    private int pedidoID;
    private int clienteID;
    private String status;

    public Pedido(int pedidoID) {
        this.setPedidoID(pedidoID);
    }

    public Pedido() {this(0);}

    public Pedido(int pedidoID, int clienteID, String status) {
        this.setPedidoID(pedidoID);
        this.setClienteID(clienteID);
        this.setStatus(status);
    }

    public Pedido(int pedidoID, String
            status) {
        this.setPedidoID(pedidoID);
        this.setStatus(status);
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
