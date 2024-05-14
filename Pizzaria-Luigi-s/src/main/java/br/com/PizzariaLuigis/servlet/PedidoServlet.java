package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.PedidoDao;
import br.com.PizzariaLuigis.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-pedidos")
public class PedidoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pedido> pedidos = new PedidoDao().BuscarPedido();
        req.setAttribute("pedidos", pedidos);

        req.getRequestDispatcher("ADM/Pedidos/pedidos.jsp").forward(req, resp);

    }
}
