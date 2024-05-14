package br.com.PizzariaLuigis.dao;
import br.com.PizzariaLuigis.model.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<Pizza> BuscarPizzas() {

        String SQL = "SELECT * FROM PIZZA";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pizza> pizzas = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("IDPizza");
                String nome = resultSet.getString("Nome");
                String preco = resultSet.getString("Preco");
                String descricao = resultSet.getString("Descricao");

                Pizza pizza = new Pizza(Integer.parseInt(id),nome,Double.parseDouble(preco),descricao);

                pizzas.add(pizza);

            }

            System.out.println("success in busca");
            connection.close();
            return pizzas;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }
    }
    public static void updatePizza(Pizza pizza){
        String SQL = "UPDATE PIZZA SET NOME = ?, PRECO = ?, DESCRICAO = ?, IMAGEM = ? WHERE IDPizza = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1,pizza.getNome());
            preparedStatement.setDouble(2,pizza.getPreco());
            preparedStatement.setString(3,pizza.getDescricao());
            preparedStatement.setString(4, pizza.getImagePath());
            preparedStatement.setInt(5, pizza.getIDPizza());

            preparedStatement.execute();

            System.out.println("success in update pizza");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
        }
    }

}
