
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Adicionar Pizza</title>
    <link rel="stylesheet" href="/ADM/EditarPizza/EditarPizza.css">
</head>
<body>

<div id="txt">
    <h2>Editar Pizza</h2>
</div>

<form action="/adicionar-pizza" method="post" enctype="multipart/form-data">
    <div class="formulario">

        <div class="inputs">

            <div class="input-box">
                <label>Nome</label>
                <input type="text" name="nome-pizza" id="nome-pizza" value="${param.name}"/>
            </div>

            <div class="input-box">
                <label>Preço</label>
                <input type="text" name="preco-pizza" id="preco-pizza" value="${param.preco}"/>
            </div>



            <div class="input-box">
                <label>Descrição</label>
                <input type="text" name="descricao-pizza" id="descricao-pizza" value="${param.descricao}"/>
            </div>
            <input type="hidden" id="id" name="id" value="${param.id}">

        </div>
        
        <input type="file" name="imagem-pizza" id="imagem-pizza"/>

    </div>

    <div class="botoes">
        <div>
            <a href="../AREA-ADM1/Area-adm1.html">Sair</a>

            <button type="submit">Editar</button>
        </div>
    </div>

</form>

</body>
</html>