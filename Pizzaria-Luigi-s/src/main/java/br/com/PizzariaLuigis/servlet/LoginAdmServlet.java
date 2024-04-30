package br.com.PizzariaLuigis.servlet;

import br.com.PizzariaLuigis.dao.LoginDao;
import br.com.PizzariaLuigis.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-Adm")
public class LoginAdmServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("user");
        String pass = request.getParameter("pass");

        Usuarios user = new Usuarios();
        user.setNomeUsuario(nome);
        user.setSenha(pass);

        LoginDao logDao = new LoginDao();
        boolean retornoLogin = logDao.VerificacaoLogin(user);

        if (retornoLogin) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("Adm1.html?error=1");
        }
    }
}