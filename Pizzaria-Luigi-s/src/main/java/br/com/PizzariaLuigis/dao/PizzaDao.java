package br.com.PizzariaLuigis.dao;
import br.com.PizzariaLuigis.model.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PizzaDao {

    public static void createPizza(Pizza pizza){

        String SQL = "INSERT INTO PIZZA (NOME, PRECO, DESCRICAO, IMAGEM ) VALUES (?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1,pizza.getNome());
            preparedStatement.setDouble(2,pizza.getPreco());
            preparedStatement.setString(3,pizza.getDescricao());
            preparedStatement.setString(4, pizza.getImagePath());

            preparedStatement.execute();

            System.out.println("success in insert pizza");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
        }
    }

}
