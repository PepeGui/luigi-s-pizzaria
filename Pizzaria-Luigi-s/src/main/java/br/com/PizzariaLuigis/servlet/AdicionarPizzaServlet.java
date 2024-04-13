package br.com.PizzariaLuigis.servlet;

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

        super.doPost(request, response);

        String pizzaName = request.getParameter("nome da pizza");

        System.out.println(pizzaName);

        request.getRequestDispatcher("AdicionarPizza.html").forward(request, response);

    }

}