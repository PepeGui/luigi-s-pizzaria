package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.PizzaDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-pizza")
public class DeletarPizzaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pizzaId = req.getParameter("id");

        System.out.println("ta ligado");

        new PizzaDao().deletarPizza(pizzaId);

        resp.sendRedirect("/find-all-pizzas");
    }
}
