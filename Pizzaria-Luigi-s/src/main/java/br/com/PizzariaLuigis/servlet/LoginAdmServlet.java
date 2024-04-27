package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.LoginDao;
import br.com.PizzariaLuigis.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginAdmServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        super.doPost(request, response);

        String nome = request.getParameter("user");
        String pass = request.getParameter("pass");

        Login log = new Login();
        log.setNome(nome);
        log.setSenha(pass);

        LoginDao logDao = new LoginDao();
        boolean retornoLogin = logDao.VericacaoLogin(log);

        request.getRequestDispatcher("Adm1.html").forward(request, response);

    }
}
