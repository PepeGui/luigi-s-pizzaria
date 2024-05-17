package br.com.PizzariaLuigis.dao;
import br.com.PizzariaLuigis.model.Ingrediente;
import br.com.PizzariaLuigis.model.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IngredienteDao {

    public static void createIngrediente(Ingrediente ingrediete){
        String SQL = "INSERT INTO INGREDIENTE (NOME, QUANTIDADEESTOQUE, DESCRICAO) VALUES (?,?,?)";

        try{
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1,ingrediete.getNome());
            preparedStatement.setDouble(2,ingrediete.getQuantidadeEstoque());
            preparedStatement.setString(3,ingrediete.getDescricao());

            preparedStatement.execute();

            System.out.println("success in insert ingrediente");

            con.close();
        }
        catch (Exception e){
            System.out.println("fail in database connection");
            System.err.println("Error inserting ingredient into database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateIngrediente(Ingrediente ingrediente) {
        String SQL = "UPDATE INGREDIENTE SET NOME = ?, QUANTIDADEESTOQUE = ?, DESCRICAO = ? WHERE IDINGREDIENTE = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            preparedStatement.setString(1, ingrediente.getNome());
            preparedStatement.setDouble(2, ingrediente.getQuantidadeEstoque());
            preparedStatement.setString(3, ingrediente.getDescricao());
            preparedStatement.setInt(4, ingrediente.getIDIngrediente());

            preparedStatement.execute();

            System.out.println("success in update ingrediente");

            con.close();
        } catch (Exception e) {
            System.out.println("fail in database connection");
            System.out.println("fail in database connection");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public List<Ingrediente> listarIngredientes(){

        String SQL = "SELECT * FROM INGREDIENTE";

        try{
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Ingrediente> ingredientes = new ArrayList<>();

            while (resultSet.next()){

                String id = resultSet.getString("IDIngrediente");
                String nome = resultSet.getString("Nome");
                String qtd= resultSet.getString("QuantidadeEstoque");
                String descricao = resultSet.getString("Descricao");

                Ingrediente i = new Ingrediente(Integer.parseInt(id), nome, Double.parseDouble(qtd), descricao);

                ingredientes.add(i);
            }

            System.out.println("success in busca");
            con.close();
            return ingredientes;
        }
        catch (Exception err){
            System.out.println("fail in database connection");
            err.getMessage();
            err.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void deletarIngrediente(String ingredienteId){

        String SQL = "DELETE FROM INGREDIENTE WHERE IDINGREDIENTE = ?";

        try{

            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1,ingredienteId);
            preparedStatement.execute();

            System.out.println("success on delete ingrediente with id: " + ingredienteId);

            con.close();
        }
        catch (Exception e){
            System.out.println("Erro ao excluir a ingrediente com ID: " + ingredienteId);
            e.getMessage();
            e.printStackTrace();
        }
    }

}
