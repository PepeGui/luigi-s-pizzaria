<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Detalhes do Pedido</title>
    <link rel="stylesheet" href="/ADM/Detalhes-Pedido/Detalhes.css">
</head>
<body>

<h1 class="cab">Detalhes Do Pedido</h1>

<section>

    <table cellspacing="0">
        <tr>

            <th  class="th">Resumo</th>


        </tr>

        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.nomeProduto}</td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach var="cliente" items="${clientes}">
    <form id="form" >

        <div class=" inputs">

            <div class="input-box">
                <h4>Nome:</h4>
                <input type="text" name="nome-cliente" id="nome-cliente" value="${cliente.nome}" size="40">
            </div>



            <div class="input-box">
                <h4>Telefone:</h4>
                <input type="text" name="telefone" id="telefone" value="${cliente.telefone}" size="40">
            </div>

            <div class="input-box">
                <h4>Endereço:</h4>
                <input type="text" name="endereco" id="endereco" value="${cliente.endereco}" size="40">
            </div>

            <div class="input-box">
                <h4>Nº</h4>
                <input type="text" name="numero" id="numero" value="${cliente.numero}" size="40">
            </div>

            

        </div>

    </form>
    </c:forEach>
</section>





<div class="botoes">
    <div>
        <a href="/find-all-pedidos">Sair</a>
    </div>

</div>

</body>
</html>
