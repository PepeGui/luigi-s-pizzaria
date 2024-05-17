package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.model.ItemPedido;
import br.com.PizzariaLuigis.dao.PedidoDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-items")
public class BuscarItemPedidoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        List<ItemPedido> itemPedidos = null;

        try {
            int parsedId = Integer.parseInt(id);
            itemPedidos = new PedidoDao().BuscarItemPedido(parsedId);

        } catch (NumberFormatException e) {

            e.printStackTrace();
            req.setAttribute("error", "Formato de ID inválido. Por favor, forneça um ID numérico.");
        }

        req.setAttribute("items", itemPedidos);

        req.getRequestDispatcher("/Confirmar-Compra/Confirmar-Compra.jsp").forward(req, resp);

    }
}
