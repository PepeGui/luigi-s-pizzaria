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

    <div class=" inputs">

        <div class="input-box">
            <h4>Nome:</h4>
            <input type="text" name="nome" size="40">
        </div>

        <div class="input-box">
            <h4>CPF:</h4>
            <input type="text" name="CPF" size="40">
        </div>

        <div class="input-box">
            <h4>Telefone:</h4>
            <input type="text" name="Telefone" size="40">
        </div>

        <div class="input-box">
            <h4>Endereço:</h4>
            <input type="text" name="Endereço" size="40">
        </div>

        <div class="input-box">
            <h4>Nº</h4>
            <input type="text" name="Nº" size="40">
        </div>

        <div class="input-box">
            <h4>Cep</h4>
            <input type="text" name="Cep" size="40">
        </div>

    </div>


</section>



<div class="sub">

    <div>
        <p>SubTotal</p>
        <p>R$117,00</p>
    </div>

</div>

<div class="botoes">
    <div>
        <a href="/">Sair</a>
        <button  type="submit" class="btss">Confirmar</button>
    </div>

</div>

</body>
</html>
