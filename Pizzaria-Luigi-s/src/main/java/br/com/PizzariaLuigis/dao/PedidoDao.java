package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoDao {
    public List<Pedido> BuscarPedido() {

        String SQL = "SELECT * FROM PEDIDO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("PedidoID");
                String idCliente = resultSet.getString("ClienteID");
                String status = resultSet.getString("Status");

                Pedido pedido = new Pedido(Integer.parseInt(id),Integer.parseInt(idCliente),status);

                pedidos.add(pedido);

            }

            System.out.println("success in busca");
            connection.close();
            return pedidos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }
    }
    public static void updatePedido(Pedido pedido, boolean confirmar){
        String SQL = "UPDATE PEDIDO SET Status = ? WHERE PedidoID = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            if(confirmar == true)
                preparedStatement.setString(1,"Pedido Confirmado");
            else
                preparedStatement.setString(1,"Pedido Cancelado");
            preparedStatement.setDouble(2,pedido.getPedidoID());

            preparedStatement.execute();

            System.out.println("success in update pedido");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
        }
    }
}
