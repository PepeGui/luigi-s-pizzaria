package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.PedidoDao;
import br.com.PizzariaLuigis.model.Cliente;
import br.com.PizzariaLuigis.dao.ClienteDao;
import br.com.PizzariaLuigis.model.Pedido;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fechar-pedido")
public class FecharPedidoServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String clienteNome = req.getParameter("nome-cliente");
        String clienteCpf = req.getParameter("cpf-cliente");
        String clienteTelefone = req.getParameter("telefone");
        String clienteEndereco = req.getParameter("endereco");
        String clienteNumero = req.getParameter("numero");
        String clienteCep = req.getParameter("cep");

        String pedidoId = req.getParameter("id");

        System.out.println("Received parameters:");
        System.out.println("Nome: " + clienteNome);
        System.out.println("CPF: " + clienteCpf);
        System.out.println("Telefone: " + clienteTelefone);
        System.out.println("Endereco: " + clienteEndereco);
        System.out.println("Numero: " + clienteNumero);
        System.out.println("CEP: " + clienteCep);
        System.out.println("Pedido ID: " + pedidoId);

        PedidoDao pedidoDao = new PedidoDao();
        Pedido p = new Pedido();

        p = pedidoDao.BuscarPedidoPorId(Integer.parseInt(pedidoId));

        PedidoDao.updatePedido(p,"Pedido Realizado");

        Cliente c = new Cliente(clienteCep, Integer.parseInt(clienteNumero), clienteEndereco, clienteTelefone,clienteCpf, clienteNome);
        ClienteDao clienteDao = new ClienteDao();

        System.out.println(clienteNome + "\n" + clienteCpf + "\n" + clienteTelefone + "\n" + clienteEndereco + "\n" + clienteNumero + "\n" + clienteCep );

        Cliente cliente = new Cliente(clienteDao.createCliente(c).getClienteID());

        pedidoDao.ConectarPedidoCliente(p.getPedidoID(),cliente.getClienteID());


        //req.getRequestDispatcher("/Confirmar-Compra/Confirmar-Compra.jsp").forward(req, resp);
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
