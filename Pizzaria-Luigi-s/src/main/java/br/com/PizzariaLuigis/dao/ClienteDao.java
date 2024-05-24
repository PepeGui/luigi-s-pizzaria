package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Cliente;
import br.com.PizzariaLuigis.model.ItemPedido;
import br.com.PizzariaLuigis.model.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteDao {

    public Cliente createCliente(Cliente cliente){

        String SQL = "INSERT INTO CLIENTE (NOME, CPF, TELEFONE, ENDERECO, NUMERO, CEP) VALUES (?,?,?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCEP());

            preparedStatement.execute();

            System.out.println("success on insert client");

            return this.BuscarCLienteCriado();
        }
        catch (Exception err){
            System.out.println("fail in client insertion");
            err.getMessage();
            err.printStackTrace();
            return new Cliente();
        }
    }
    public Cliente BuscarCLienteCriado() {

        String SQL = "SELECT TOP 1* FROM CLIENTE ORDER BY CLIENTEID DESC";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {

                String idCliente = resultSet.getString("ClienteID");


                Cliente c = new Cliente(Integer.parseInt(idCliente));

                clientes.add(c);

            }
            Cliente cli = new Cliente();
            cli = clientes.get(0);

            System.out.println("success in busca pedido Criado");
            connection.close();
            return cli;

        } catch (Exception e) {

            System.out.println("fail in database connection busca pedido Criado");
            e.getMessage();
            e.getStackTrace();
            return new Cliente();

        }
    }
    public Cliente BuscarCliente(int idCliente){

        String SQL = "SELECT * FROM CLIENTE WHERE CLIENTEID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, idCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("ClienteID");
                String nome = resultSet.getString("Nome");
                String cpf = resultSet.getString("CPF");
                String endereco = resultSet.getString("Endereco");
                String telefone = resultSet.getString("Telefone");
                String cep = resultSet.getString("CEP");
                String numero = resultSet.getString("Numero");

                Cliente c = new Cliente(Integer.parseInt(id),cep,Integer.parseInt(numero),endereco,telefone,cpf,nome);

                clientes.add(c);

            }
            Cliente cli = new Cliente();
            cli = clientes.get(0);

            System.out.println("success in busca pedido Criado");
            connection.close();
            return cli;

        } catch (Exception e) {

            System.out.println("fail in database connection busca pedido Criado");
            e.getMessage();
            e.getStackTrace();
            return new Cliente();

        }
    }
}
