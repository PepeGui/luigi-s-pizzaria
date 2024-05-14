package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.PizzaDao;
import br.com.PizzariaLuigis.model.Pizza;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-pizzas")
public class BuscarPizzaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pizza> pizzas = new PizzaDao().BuscarPizzas();

        req.setAttribute("pizzas", pizzas);

        req.getRequestDispatcher("ADM/Cardapio/Cardapio.jsp").forward(req, resp);

    }

}