<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, br.com.PizzariaLuigis.model.Pizza, br.com.PizzariaLuigis.dao.PizzaDao" %>

<%
    PizzaDao pizzaDao = new PizzaDao(); // Instanciando o objeto PizzaDao
    List<Pizza> pizzas = pizzaDao.BuscarPizzas(); // Obtendo a lista de pizzas
    request.setAttribute("pizzas", pizzas); // Definindo a lista de pizzas como um atributo de requisição
%>
<head>
    <meta charset="UTF-8">
    <title>Luigi's Pizzaria</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <header class="cabecalho">
        <div class="cabecalho-alto">
            <h2 id="titulo" class="texto-branco">Luigi's Pizzaria</h2>
            <a href="/find-all-items?id=${pedido.pedidoID}"><img src="/images/Carrinho.png" alt=""></a>
        </div>


    </header>

    <section class="introducao">

            <h2 class="texto-branco">Desde 2005</h2>
            <h2 class="texto-branco">Luigi's Pizzaria</h2>
            <p class="texto-branco">Na Luigi's Pizzaria, criamos um ambiente acolhedor e convidativo, pensado para proporcionar uma experiência gastronômica completa e memorável. Cada detalhe da nossa casa foi cuidadosamente planejado para refletir o charme e a autenticidade da Itália.</p>



    </section>

    <section class="como-fazemos">
            <img src="./images/pepperoni.png" alt="">
        <div>
            <h3>Como fazemos pizza na Luigi's Pizzaria</h3>
            <p>Na Luigi's Pizzaria, nossa paixão é criar a melhor experiência em pizzas, combinando tradição italiana e ingredientes frescos de alta qualidade. Cada pizza é preparada com uma massa artesanal, fermentada naturalmente e aberta manualmente, garantindo leveza e crocância.

               Nosso molho é feito de tomates frescos e ervas aromáticas, cozido lentamente para um sabor rico e autêntico. Utilizamos apenas ingredientes selecionados, como queijos italianos de alta qualidade, carnes artesanais e vegetais frescos, oferecendo também opções gourmet.

               Nossas pizzas são assadas em forno a lenha, que confere um sabor único e uma textura perfeita, preservando a suculência dos ingredientes. Cada pizza é uma obra de arte, preparada com dedicação e amor pela culinária italiana.

               Venha nos visitar e descubra por que a Luigi's Pizzaria é sinônimo de qualidade e sabor. Buon appetito!</p>
        </div>

    </section>

    <section class="cardapio">
        <h2>Cardapio</h2>
        <div>
        <c:forEach var="pizza" items="${pizzas}">
                <div class="pizzas">
                    <img class="img-pizza" id="imagem" src="${pizza.imagePath}" alt="">
                    <h3 id="nome">${pizza.nome}</h3>
                    <p id="preco">R$ ${pizza.preco}</p>
                    <p id="descricao">${pizza.descricao}</p>

                        <form action="/criar-pedido" method="post">
                            <input type="hidden" name="idPizza" value="${pizza.IDPizza}">
                            <input type="hidden" name="nome" value="${pizza.nome}">
                            <input type="hidden" id="idPedido" name="idPedido" value="${pedido.pedidoID}">

                            <button type="submit">Adicionar</button>
                        </form>
                </div>
        </c:forEach>
        </div>
    </section>

    <section class="sobre-nos">
        <h2>Sobre Nós</h2>
        <p>Na Luigi's Pizzaria, valorizamos a simplicidade e a qualidade dos ingredientes. Selecionamos farinhas italianas, fermento natural e ingredientes frescos para garantir um sabor autêntico. Seguimos tradições napolitanas com receitas familiares, desde a preparação da massa até o molho de tomate artesanal.

           Cada pizza é uma obra de arte, aberta manualmente e assada em forno a lenha, resultando em uma textura crocante e um sabor único. Nossa paixão e dedicação estão presentes em cada detalhe, proporcionando uma experiência gastronômica memorável.

           Venha nos visitar e descubra a excelência e o cuidado que colocamos em cada pizza. Buon appetito!</p>
    </section>



    <footer>
        <div class="rodape-esq">
            <img src="./images/Email.png" alt="">
            <p>pizzaria@gmail.com</p>
            <a href="/ADM/Adm1.html" ><img src="./images/Instagram.png" alt=""></a>
            <p>@Pizza</p>
            <img src="./images/TwitterX.png" alt="">
            <p>@Pizza</p>
            <img src="./images/Facebook.png" alt="">
            <p>@Pizza</p>
            <img src="./images/Phone.png" alt="">
            <p>1199999-6666</p>
        </div>
        <div class="rodape-dir">
            <img src="./images/Visa.png" alt="">
            <img src="./images/MasterCard.png" alt="">
        </div>


    </footer>
</body>
</html>