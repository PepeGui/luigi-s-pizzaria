package br.com.PizzariaLuigis.servlet;
import br.com.PizzariaLuigis.model.Pizza;
import  br.com.PizzariaLuigis.dao.PizzaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import java.util.UUID;

@WebServlet("/adicionar-pizza")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,    // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class AdicionarPizzaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pizzaName = request.getParameter("nome-pizza");
        String pizzaPrecoStr = request.getParameter("preco-pizza");
        String pizzaDescricao = request.getParameter("descricao-pizza");

        double pizzaPreco = Double.parseDouble(pizzaPrecoStr);

        InputStream fileContent = null;
        String imagePath = null;

        // Obter a imagem enviada no formulário
        Part filePart = request.getPart("imagem-pizza");
        if (filePart != null) {
            fileContent = filePart.getInputStream();
            // Salvar a imagem em algum diretório no servidor
            imagePath = saveImageToServer(fileContent);
        }

        Pizza p = new Pizza(pizzaName, pizzaPreco, pizzaDescricao, imagePath);

        System.out.println(pizzaName + " " + pizzaPreco + " " + pizzaDescricao + " " + imagePath );

        PizzaDao.createPizza(p);

        request.getRequestDispatcher("AdicionarPizza.html").forward(request, response);
    }

    // Método para salvar a imagem no servidor
    private String saveImageToServer(InputStream fileContent) throws IOException {
        // Obtenha o diretório atual do servlet context
        String directory = getServletContext().getRealPath("/storage/");

        // Gere um nome único para a imagem (você pode usar algum algoritmo de hash)
        String imageName = UUID.randomUUID().toString() + ".jpg";

        // Crie o arquivo de imagem
        File file = new File(directory, imageName);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        // Retorne o caminho completo da imagem no servidor
        return directory + File.separator + imageName;
    }
}
