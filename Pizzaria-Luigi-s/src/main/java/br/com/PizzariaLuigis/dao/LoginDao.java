package br.com.PizzariaLuigis.dao;

import br.com.PizzariaLuigis.model.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
    public Boolean VerificacaoLogin(Usuarios user) {

        String SQL = "SELECT * FROM USUARIOS";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuarios> userios = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("NOMEUSUARIO");
                String senha = resultSet.getString("SENHA");

                System.out.println("passou aqui"+nome);
                System.out.println("passou aqui"+senha);

                Usuarios usuario = new Usuarios();
                usuario.setNomeUsuario(nome);
                usuario.setSenha(senha);

                userios.add(usuario);

            }
            for (Usuarios us : userios) {
                if(us.getNomeUsuario().equals(user.getNomeUsuario())  && us.getSenha().equals(user.getSenha()) ){
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
