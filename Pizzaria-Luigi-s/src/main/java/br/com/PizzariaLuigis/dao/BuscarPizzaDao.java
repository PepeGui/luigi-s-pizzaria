package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Pizza;
import br.com.PizzariaLuigis.model.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuscarPizzaDao {
    public List<Pizza> BuscarPizzas() {

        String SQL = "SELECT * FROM PIZZA";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pizza> pizzas = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("Nome");
                String preco = resultSet.getString("Preco");
                String descricao = resultSet.getString("Descricao");

                Pizza pizza = new Pizza(nome,Double.parseDouble(preco),descricao);

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
}
