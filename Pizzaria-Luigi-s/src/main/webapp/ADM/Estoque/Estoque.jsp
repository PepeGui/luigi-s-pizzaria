<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pt-br">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estoque</title>
    <link rel="stylesheet" href="/ADM/Estoque/Estoque.css">
</head>
<body> <h3>Estoque</h3>
<table cellspacing="0" cellpading="0">
    <tr>
        <th>Item</th>
        <th>Quantidade</th>
        <th>Descrição</th>
        <th></th>
    </tr>
    <c:forEach var="ingrediente" items="${ingredientes}">
        <tr>
            <td id="nome">${ingrediente.nome}</td>
            <td id="quantidade">${ingrediente.quantidadeEstoque}</td>
            <td id="descricao">${ingrediente.descricao}</td>
            <input type="hidden" name="id" value="${ingrediente.IDIngrediente}">
            <td>
                <a href="/ADM/EditarIngrediente/EditarIngrediente.jsp?id=${ingrediente.IDIngrediente}&nome=${ingrediente.nome}&quantidade=${ingrediente.quantidadeEstoque}&descricao=${ingrediente.descricao}">
                    <svg width="60" height="60" viewBox="0 0 60 60" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <rect x="0.00317383" width="60" height="60" fill="url(#pattern0_403_55)"/>
                        <defs>
                            <pattern id="pattern0_403_55" patternContentUnits="objectBoundingBox" width="1" height="1">
                                <use xlink:href="#image0_403_55" transform="scale(0.0111111)"/>
                            </pattern>
                            <image id="image0_403_55" width="90" height="90" xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAYAAAA4qEECAAAACXBIWXMAAAsTAAALEwEAmpwYAAACl0lEQVR4nO2dv4oUQRCH20DTqomWqvUJPE+Ei0QD8TLxAXwHM0VMhLvMvao9wUDESMU/ibGZqaG+gSB3GpxnYqgerMyiIMfceePO1DjTvw8m3N3uj9/2VPd0MykBAAAAAAAAAPh/MaWzrvTUhT6Z8HcT+mhCj31UnO66bYPBlW6Y8p4rzyquH6Z8res29h4XWj9A8P7rdtdtzUHyDLLjJEN2oGTIDpQM2YGSITtQ8vxC6RckuqyzJ6Niaf/vZY23JVv4Udd9y0K2CW113a88ZAt/67pPecgW2u66P3nIFnqSshMntF77M4uMz8p7NuYzKRf8T2GBsk3pesoFrxBlypOa33HrH9K8lnLBD0ljm7IhWduXDcnafrIhWduXDcnavmxI1tqTi/qlX83P9BpvcMpcN9nZ4G2suEF22II9ZEdIhuxAydnL9kDJ2cr2DiT/Eo0FIodkJLlXOIYLSB4EjiRD8iBwJBmSB4EjyZA8CJDkACA5AEgOAJIDgOQAIDkASA4AkgOA5AAerqTjU6GVqdKqK90sD86EPOeTjLZpVWFanIPkoISXx3aR5ABc+Au2BARgyu+x7yIAV36LG18AJvwaO4gCMOGX2KYVgAtvok4OwMd0CZORBdk8WSwfZVbmY7powuZKz13olQm9MeF384rksPIv9xnfb1zpThNCJqNiyZS+QnIFs5SOmdKHptJnwneR5AqmUlxo8q/uWlzFcFGZQHrQ5LGEqdJqVjvtj7pYZMq7Td7E1k6lE+20tsdsKF/BgZsATOkFTjcF4MqfcZQsgPIlA38dOoS2TOle+Wgrok2DpKwsDqg4dk3ovklxvqyzu25n7ykrhLns8vUZyjum9GxjXFwuq5Gu2wYAAAAAAAAAIC3GT9MsAJmKK8cJAAAAAElFTkSuQmCC"/>
                        </defs>
                    </svg>
                </a>
                <a href="/delete-ingrediente?id=${ingrediente.IDIngrediente}">
                    <button type="submit">
                        <img src="/images/Trash.png" alt="">
                    </button>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
<div>
    <a href="/ADM/AREA-ADM1/Area-adm1.html"><button>Sair</button></a>
    <a href="/ADM/AdicionarIngrediente/AdicionarIngrediente.html"><button class="sherek">Adicionar</button></a>
</div>
</body>
</html>