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
            <div class="cabecalho-baixo">
                <div id="texto">
                    <p class="texto-branco">Home</p>
                    <p class="texto-branco">Cardapio</p>
                    <p class="texto-branco">Contato</p>
                    <p class="texto-branco">Sobre Nós</p>
                </div>
        </div>

    </header>

    <section class="introducao">

            <h2 class="texto-branco">Desde 2005</h2>
            <h2 class="texto-branco">Luigi's Pizzaria</h2>
            <p class="texto-branco">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vulputate nunc metus, et porttitor lectus accumsan porta. Mauris vitae nulla ligula. Sed quis lacus enim. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque tortor quam, tempor eu tristique et, convallis at nisl. Quisque porttitor turpis vel urna pharetra tempus. Duis vel augue in nisl egestas auctor. In consequat ex nec nisl commodo posuere. Vivamus tristique auctor volutpat.</p>



    </section>

    <section class="como-fazemos">
            <img src="./images/pepperoni.png" alt="">
        <div>
            <h3>Como fazemos pizza na Luigi's Pizzaria</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi interdum ac nulla eget blandit. Nunc malesuada risus laoreet congue fermentum. Donec enim nisl, ullamcorper quis odio sed, pulvinar efficitur quam. Cras in ultricies orci, ut blandit orci. Cras a nisl quis dolor malesuada blandit vitae ac nisi. Nam fermentum libero vitae finibus auctor. Vivamus fringilla in felis a blandit. Sed non libero at dui ullamcorper congue eget eu diam. Aliquam vitae aliquet nunc. Morbi non metus nec nibh interdum tincidunt. Duis tempus commodo sapien. Vestibulum tristique ligula arcu, pharetra vehicula ipsum aliquet et. Aliquam varius facilisis eros, et consectetur nisi feugiat eu. Pellentesque ultricies sed ante ac euismod.
                Maecenas ornare metus orci, in facilisis dolor dictum at. Morbi sed lacus luctus, lacinia arcu id, ultricies elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eleifend erat eget rhoncus sagittis. Mauris dapibus magna vel nibh euismod, sit amet scelerisque tellus varius. In bibendum aliquam dignissim. Aliquam pretium leo et semper fermentum. In vel pellentesque nisi, eget tincidunt erat. Maecenas luctus, ex commodo aliquet rhoncus, leo turpis lobortis ante, ut pharetra mi purus gravida ipsum. Phasellus luctus nunc odio, gravida dictum dolor pretium sodales. Ut et neque gravida, mattis ligula nec, auctor enim. Nullam volutpat eget est a placerat. Aenean commodo congue ex id viverra.</p>
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
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eu erat neque. Nunc eros tortor, posuere vitae leo congue, euismod consequat leo. Vestibulum eget nisl vehicula, lacinia mauris at, mollis libero. Nam in magna id nunc placerat condimentum. Quisque sed ullamcorper elit. Aliquam erat volutpat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean molestie metus quis maximus accumsan. Vestibulum sit amet ex diam. Nullam et ligula non enim ornare porta eget et erat. In ut sapien suscipit, rutrum tellus sit amet, interdum massa. Suspendisse potenti. Praesent imperdiet venenatis ipsum, vehicula fringilla turpis convallis ac.
            Donec volutpat condimentum fermentum. Donec sed massa nec quam mattis auctor. Nulla ac neque velit. Vestibulum eget sapien accumsan, gravida tellus accumsan, convallis ligula. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean risus lorem, placerat id finibus eu, iaculis vel lorem. Duis quis vehicula quam, eget elementum massa. Cras finibus augue mauris. Vivamus eu quam massa. Nam ligula diam, faucibus vitae ex vel, fermentum rutrum erat. Nam ac dolor in ligula volutpat fringilla non id neque. Aliquam non velit ac erat convallis dictum id vitae ipsum. Sed a quam id felis consequat vulputate. Fusce aliquet magna est, ac mollis ipsum sagittis sit amet. Nunc ac faucibus ex. Nunc viverra ornare arcu, nec elementum sem finibus in.
            Phasellus malesuada commodo interdum. Pellentesque fermentum sit amet nisi vitae facilisis. Sed pellentesque in mi sit amet viverra. Nullam mattis tellus dui, semper sodales lacus rutrum at. In dignissim odio vitae justo sollicitudin, quis porttitor nisl interdum. Quisque posuere elit dui. Curabitur turpis magna, vehicula eget tempus eget, sodales ac turpis. Nullam imperdiet lacus ac eros scelerisque, posuere ultricies felis maximus. Ut ultrices rhoncus mattis. Cras et odio felis. Nunc semper orci vel odio mollis fermentum.
            Etiam interdum purus eu lorem molestie, et tincidunt lorem rutrum. Nunc viverra ultricies pretium. Etiam in ultricies est. Nunc bibendum molestie sapien at rutrum. Donec sollicitudin, tellus quis fringilla pellentesque, turpis justo molestie dolor, eleifend eleifend est odio in libero. Aliquam massa metus, ullamcorper sit amet dictum sit amet, tincidunt non mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus non velit leo. Aliquam ornare, quam bibendum aliquet ultricies, leo lectus dictum turpis, eget tempus velit augue vel libero. Maecenas porta eu dolor euismod tempor. Maecenas ac tellus tellus. Maecenas condimentum efficitur sagittis. Etiam elementum vestibulum odio, eget dapibus ante mollis nec.</p>
    </section>



    <footer>
        <div class="rodape-esq">
            <img src="./images/Email.png" alt="">
            <p>pizzaria@gmail.com</p>
            <img src="./images/Instagram.png" alt="">
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