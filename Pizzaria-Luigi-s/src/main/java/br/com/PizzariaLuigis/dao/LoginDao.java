package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginDao {
    public void createLogin(Login log) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, log.getNome());
            preparedStatement.execute();

            System.out.println("success in insert car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
    public Boolean VericacaoLogin(Login log) {

        String SQL = "SELECT * FROM Usuarios";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Login> logs = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("name");

                Login car = new Login();

                logs.add(car);

            }
            for (Login lg : logs) {
                if(lg.getNome() == log.getNome() & lg.getSenha() == log.getSenha()){
                    System.out.println("success in login");
                    connection.close();
                    return true;
                }
            }

            System.out.println("fail in login");
            connection.close();
            return false;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return false;

        }
    }
}
