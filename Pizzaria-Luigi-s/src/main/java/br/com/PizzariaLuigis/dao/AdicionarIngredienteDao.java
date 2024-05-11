package br.com.PizzariaLuigis.dao;
import br.com.PizzariaLuigis.model.Ingrediente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdicionarIngredienteDao {

    public static void createIngrediente(Ingrediente ingrediete){
        String SQL = "INSERT INTO INGREDIENTES (NOME, QUANTIDADEESTOQUE, DESCRICAO) VALUES (?,?,?)";

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
        catch (Exception err){
            System.out.println("fail in database connection");
        }
    }

}
