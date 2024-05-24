package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.model.ItemPedido;
import br.com.PizzariaLuigis.dao.PedidoDao;
import br.com.PizzariaLuigis.model.Pedido;


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

        Pedido pedido = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();

        String idPedido = req.getParameter("id");//pedido
        List<ItemPedido> itemPedidos = null;

        System.out.println(idPedido);

        try {
            int parsedId = Integer.parseInt(idPedido);
            itemPedidos = new PedidoDao().BuscarItemPedido(parsedId);

        } catch (NumberFormatException e) {

            e.printStackTrace();
            req.setAttribute("error", "Formato de ID inválido. Por favor, forneça um ID numérico.");
        }

        req.setAttribute("items", itemPedidos);

        pedido = pedidoDao.BuscarPedidoPorId(Integer.parseInt(idPedido));

        req.setAttribute("id", pedido.getPedidoID());

        req.getRequestDispatcher("/Confirmar-Compra/Confirmar-Compra.jsp").forward(req, resp);

    }
}
