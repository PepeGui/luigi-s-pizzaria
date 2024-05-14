package br.com.PizzariaLuigis.model;

public class Pedido {
    private int PedidoID;
    private Cliente ClienteID;
    private String Status;

    public Pedido(int pedidoID) {
        this.setPedidoID(pedidoID);
    }

    public Pedido(int pedidoID, int clienteID, String
                  status) {
        this.setPedidoID(pedidoID);
        this.setClienteID(clienteID);
        this.setStatus(status);
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
