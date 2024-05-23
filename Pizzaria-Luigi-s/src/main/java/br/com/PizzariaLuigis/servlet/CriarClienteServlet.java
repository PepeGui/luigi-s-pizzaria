package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.model.Cliente;
import br.com.PizzariaLuigis.dao.ClienteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criar-cliente")
public class CriarClienteServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String clienteNome = req.getParameter("nome-cliente");
        String clienteCpf = req.getParameter("cpf-cliente");
        String clienteTelefone = req.getParameter("telefone");
        String clienteEndereco = req.getParameter("endereco");
        String clienteNumero = req.getParameter("numero");
        String clienteCep = req.getParameter("cep");

        Cliente c = new Cliente(clienteCep, Integer.parseInt(clienteNumero), clienteEndereco, clienteTelefone,clienteCpf, clienteNome);

        System.out.println(clienteNome + "\n" + clienteCpf + "\n" + clienteTelefone + "\n" + clienteEndereco + "\n" + clienteNumero + "\n" + clienteCep );

        ClienteDao.createCliente(c);

        //req.getRequestDispatcher("/Confirmar-Compra/Confirmar-Compra.jsp").forward(req, resp);
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
