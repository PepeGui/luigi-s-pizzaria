package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.ClienteDao;
import br.com.PizzariaLuigis.model.Cliente;
import br.com.PizzariaLuigis.model.ItemPedido;
import br.com.PizzariaLuigis.dao.PedidoDao;
import br.com.PizzariaLuigis.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find-detalhes")
public class BuscarDetalhesPedidosServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Pedido pedido = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();
        List<Cliente> c = new ArrayList<>();
        ClienteDao clienteDao = new ClienteDao();

        String idPedido = req.getParameter("id");//pedido
        List<ItemPedido> itemPedidos = null;

        System.out.println(idPedido);

        try {
            int parsedId = Integer.parseInt(idPedido);
            itemPedidos = new PedidoDao().BuscarItemPedido(parsedId);

        } catch (Exception e) {

            e.printStackTrace();
        }

        req.setAttribute("items", itemPedidos);

        pedido = pedidoDao.BuscarClientePedido(Integer.parseInt(idPedido));
        c.add(clienteDao.BuscarCliente(pedido.getClienteID()));

        req.setAttribute("id", pedido.getPedidoID());
        req.setAttribute("clientes", c);

        req.getRequestDispatcher("/ADM/Detalhes-Pedido/Detalhes-Pedido.jsp").forward(req, resp);

    }
}

