package br.com.PizzariaLuigis.servlet;
import br.com.PizzariaLuigis.model.Pizza;
import  br.com.PizzariaLuigis.dao.PizzaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adicionar-pizza")
public class AdicionarPizzaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pizzaName = request.getParameter("nome-pizza");
        String pizzaPrecoStr = request.getParameter("preco-pizza");
        String pizzaDescricao = request.getParameter("descricao-pizza");

        System.out.println(pizzaName);
        System.out.println(pizzaDescricao);
        System.out.println(pizzaPrecoStr);

        double pizzaPreco = Double.parseDouble(pizzaPrecoStr);

        Pizza p = new Pizza(pizzaName, pizzaPreco, pizzaDescricao);

        PizzaDao.createPizza(p);

        request.getRequestDispatcher("AdicionarPizza.html").forward(request, response);

        System.out.println(pizzaName);
        System.out.println(pizzaDescricao);
        System.out.println(pizzaPreco);
    }

}