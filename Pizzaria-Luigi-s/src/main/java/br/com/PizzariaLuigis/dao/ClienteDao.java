package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteDao {

    public static void createCliente(Cliente cliente){

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
        }
        catch (Exception err){
            System.out.println("fail in client insertion");
            err.getMessage();
            err.printStackTrace();
        }
    }
}
