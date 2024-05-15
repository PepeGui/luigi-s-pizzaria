package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.IngredienteDao;
import br.com.PizzariaLuigis.model.Ingrediente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
    @WebServlet("/find-all-ingredientes")

    public class BuscarIngredienteServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

            List<Ingrediente> i = new IngredienteDao().listarIngredientes();

            req.setAttribute("ingredientes", i);

            req.getRequestDispatcher("/ADM/Estoque/Estoque.jsp").forward(req,resp);
        }
    }
