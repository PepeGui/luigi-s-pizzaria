package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.IngredienteDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-ingrediente")
public class DeletarIngredienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String ingredienteId = req.getParameter("id");

        new IngredienteDao().deletarIngrediente(ingredienteId);

        resp.sendRedirect("/find-all-ingredientes");
    }
}
