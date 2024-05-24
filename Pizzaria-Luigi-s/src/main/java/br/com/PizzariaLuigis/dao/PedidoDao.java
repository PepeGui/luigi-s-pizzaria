package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.ItemPedido;
import br.com.PizzariaLuigis.model.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class PedidoDao {
    public List<Pedido> BuscarPedido() {

        String SQL = "SELECT * FROM PEDIDO WHERE STATUS IN (?,?) ";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,"Pedido Confirmado");
            preparedStatement.setString(2,"Pedido Realizado");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("PedidoID");
                //String idCliente = resultSet.getString("ClienteID");
                String status = resultSet.getString("Status");

                Pedido pedido = new Pedido(Integer.parseInt(id),status);

                pedidos.add(pedido);

            }

            System.out.println("success in busca");
            connection.close();
            return pedidos;

        } catch (Exception e) {

            System.out.println("fail in buscar pedido");
            e.getMessage();
            e.getStackTrace();
            return Collections.emptyList();

        }
    }

    public Pedido BuscarPedidoPorId(int pId) {

        String SQL = "SELECT * FROM PEDIDO WHERE PEDIDOID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1,pId);


            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("PedidoID");
                //String idCliente = resultSet.getString("ClienteID");
                String status = resultSet.getString("Status");

                Pedido ped = new Pedido(Integer.parseInt(id),status);

                pedidos.add(ped);

            }

            Pedido pedido = new Pedido();
            pedido = pedidos.get(0);

            System.out.println("success in busca pedido por id porra");
            connection.close();
            return pedido;

        } catch (Exception e) {

            e.getMessage();
            e.getStackTrace();
            System.out.println("fail in database connection buscar pedido por id");

            return new Pedido();

        }
    }

    public static void updatePedido(Pedido pedido, String status){
        String SQL = "UPDATE PEDIDO SET Status = ? WHERE PedidoID = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1,status);
            preparedStatement.setDouble(2,pedido.getPedidoID());

            preparedStatement.execute();

            System.out.println("success in update pedido");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
            e.getMessage();
            e.getStackTrace();
        }
    }
    public Pedido createPedido(){

        String SQL = "INSERT INTO PEDIDO (STATUS) VALUES (?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1,"Pedido No Carrinho");

            preparedStatement.execute();

            System.out.println("success in insert pedido");

            con.close();

            return this.BuscarPedidoCriado();

        }
        catch (Exception e){
            System.out.println("fail in database connection insert pedido");
            e.getMessage();
            e.getStackTrace();
            return new Pedido();

        }
    }
    public Pedido BuscarPedidoCriado() {

        String SQL = "SELECT TOP 1* FROM PEDIDO ORDER BY PEDIDOID DESC ";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            //preparedStatement.setString(1,"Pedido No Carrinho");
            System.out.println("passou aqui");
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("passou aqui 1");
            List<Pedido> pedidos = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("PedidoID");
                //String idCliente = resultSet.getString("ClienteID");
                String status = resultSet.getString("Status");

                Pedido ped = new Pedido(Integer.parseInt(id),status);

                pedidos.add(ped);

            }
            System.out.println("passou aqui 3");
            Pedido pedido = new Pedido();
            pedido = pedidos.get(0);

            System.out.println("success in busca pedido Criado");
            connection.close();
            return pedido;

        } catch (Exception e) {

            System.out.println("fail in database connection busca pedido Criado");
            e.getMessage();
            e.getStackTrace();
            return new Pedido();

        }
    }
    public static void createItemPedido(int idPedido, String nomePizza){

        String SQL = "INSERT INTO ItemPedido (PedidoID,NomeProduto,Quantidade) VALUES (?,?,?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setInt(1,idPedido);
            preparedStatement.setString(2,nomePizza);
            preparedStatement.setInt(3,1);

            preparedStatement.execute();

            System.out.println("success in insert item pedido");

            con.close();

        }
        catch (Exception e){
            System.out.println("fail in database connection insert item pedido");
            e.getMessage();
            e.getStackTrace();
        }
    }

    public List<ItemPedido> BuscarItemPedido(int idPedido){

        String SQL = "SELECT * FROM ITEMPEDIDO WHERE PEDIDOID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, idPedido);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<ItemPedido> itens = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("PedidoID");
                String nomeProduto = resultSet.getString("nomeProduto");

                ItemPedido item = new ItemPedido(Integer.parseInt(id));
                item.setNomeProduto(nomeProduto);

                itens.add(item);

            }

            System.out.println("success in busca item pedido");
            connection.close();
            return itens;

        } catch (Exception e) {

            System.out.println("fail in database connection");
            e.getMessage();
            e.getStackTrace();
            return Collections.emptyList();

        }
    }
    public static void ConectarPedidoCliente(int pedidoID, int clienteId){

        String SQL = "UPDATE PEDIDO SET CLIENTEID = ? WHERE PEDIDOID = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setInt(1,clienteId);
            preparedStatement.setInt(2,pedidoID);

            preparedStatement.execute();

            System.out.println("success in update pedido");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
            e.getMessage();
            e.getStackTrace();
        }
    }
}
