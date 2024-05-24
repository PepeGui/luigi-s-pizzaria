package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.PedidoDao;
import br.com.PizzariaLuigis.dao.PizzaDao;
import br.com.PizzariaLuigis.model.Pedido;
import br.com.PizzariaLuigis.model.Pizza;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/mudarStatus-pedido")
public class MudarStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String status = request.getParameter("status");

        Pedido p = new Pedido(Integer.parseInt(id));
        if(Integer.parseInt(status) == 2){
            PedidoDao.updatePedido(p,"Pedido Confirmado");
        }else{
            PedidoDao.updatePedido(p,"Pedido Cancelado");
        }

        request.getRequestDispatcher("/find-all-pedidos").forward(request, response);
    }
}
