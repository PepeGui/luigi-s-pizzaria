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

@WebServlet("/criar-pedido")
public class CriandoPedidoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pedido pedido = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();

        String idPizza = request.getParameter("idPizza");
        String idPedido = request.getParameter("idPedido");
        String nomePizza = request.getParameter("nome");

        if(idPedido == null || idPedido.isBlank()){

            pedido = pedidoDao.createPedido();
        }else{
            pedido = pedidoDao.BuscarPedidoPorId(Integer.parseInt(idPedido));
        }

        pedidoDao.createItemPedido(pedido.getPedidoID(),nomePizza);

        request.setAttribute("pedido", pedido);

        request.getRequestDispatcher("/").forward(request, response);
    }
}
