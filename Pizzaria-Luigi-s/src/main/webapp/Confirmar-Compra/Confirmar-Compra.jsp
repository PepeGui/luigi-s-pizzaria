<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Confirmar-Compra</title>
    <link rel="stylesheet" href="/Confirmar-Compra/Confirmar-Compra.css">
</head>
<body>

<h1 class="cab">Confirmar Compra</h1>

<section>

    <table cellspacing="0">
        <tr>

            <th  class="th">Resumo</th>

            <th></th>
            <th></th>
        </tr>

        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.nomeProduto}</td>
            </tr>
        </c:forEach>
    </table>


        <form id="form" action="/fechar-pedido" method="post" >

        <div class=" inputs">

            <div class="input-box">
                <h4>Nome:</h4>
                <input type="text" name="nome-cliente" id="nome-cliente" size="40">
            </div>

            <div class="input-box">
                <h4>CPF:</h4>
                <input type="text" name="cpf-cliente" id="cpf-cliente" size="40">
            </div>

            <div class="input-box">
                <h4>Telefone:</h4>
                <input type="text" name="telefone" id="telefone" size="40">
            </div>

            <div class="input-box">
                <h4>Endereço:</h4>
                <input type="text" name="endereco" id="endereco" size="40">
            </div>

            <div class="input-box">
                <h4>Nº</h4>
                <input type="text" name="numero" id="numero" size="40">
            </div>

            <div class="input-box">
                <h4>Cep</h4>
                <input type="text" name="cep" id="cep" size="40">
            </div>

       </div>
            <input type="hidden" id="id" name="id" value="${id}">
    </form>

</section>



<div class="sub">

    <div>
        <p>ID do Pedido: ${id}</p>
    </div>

</div>

<div class="botoes">
    <div>
        <a href="/">Sair</a>
        <button form="form" type="submit" class="btss">Confirmar</button>
    </div>

</div>

</body>
</html>
