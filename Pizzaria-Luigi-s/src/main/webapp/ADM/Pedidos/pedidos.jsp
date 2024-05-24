<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <link rel="stylesheet" type="text/css" href="/ADM//Pedidos/pedidos.css">
</head>
<body>

<h1 class="cab">Gerenciamento de Pedidos</h1>
<table cellspacing="0">
    <tr>
        <th class="th">Pedido</th>
        <th></th>
        <th class="th">Status</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="pedido" items="${pedidos}">
         <tr>
             <td id="id">${pedido.pedidoID}</td>
             <td id="itens"><a href="/find-detalhes?id=${pedido.pedidoID}">Itens do Pedido</a></td>
             <td id="status">${pedido.status}</td>
             <input type="hidden" id="id" name="id" value="{pedido.pedidoID}">
             <td><a href="/mudarStatus-pedido?id=${pedido.pedidoID}&status=1"><button type="submit" class="bt">Cancelar</button></a></td>
             <td><a href="/mudarStatus-pedido?id=${pedido.pedidoID}&status=2"><button type="submit" class="bt">Confirmar</button></a></td>

         </tr>
    </c:forEach>
</tr>
</table>

<a href="ADM/AREA-ADM1/Area-adm1.html" class="sair">Sair</a>
</body>
</html>


