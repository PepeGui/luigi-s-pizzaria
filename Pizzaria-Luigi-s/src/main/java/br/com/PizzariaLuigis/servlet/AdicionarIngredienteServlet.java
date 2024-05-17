package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.IngredienteDao;
import br.com.PizzariaLuigis.model.Ingrediente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/adicionar-ingrediente")

public class AdicionarIngredienteServlet extends HttpServlet {


        protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws  ServletException, IOException {

                String ingredienteNome = request.getParameter("nome-ingrediente");
                String ingredienteQtdStr = request.getParameter("quantidade-ingrediente");
                String ingredienteDescricao = request.getParameter("descricao-ingrediente");
                String id = request.getParameter("id");

                double ingredienteQtd = Double.parseDouble(ingredienteQtdStr);

                Ingrediente i = new Ingrediente(ingredienteNome, ingredienteQtd, ingredienteDescricao);

                System.out.println(ingredienteNome + "\n" + ingredienteQtd + "\n" + ingredienteDescricao);

                if (id == null || id.isBlank()) {
                        IngredienteDao.createIngrediente(i);

                } else {
                        i.setIDIngrediente(Integer.parseInt(id));
                        IngredienteDao.updateIngrediente(i);
                }

                request.getRequestDispatcher("/ADM/AREA-ADM1/Area-adm1.html").forward(request, response);

        }
}
