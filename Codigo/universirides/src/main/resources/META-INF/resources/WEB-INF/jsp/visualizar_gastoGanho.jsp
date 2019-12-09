<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>GFPessoal</title>
</head>
<body>
<div align="center">
    <h2>GFPessoal</h2>

    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Buscar" />
    </form>

    <h3><a href="/gastoGanho/new">Novo Gasto/Ganho</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>Data e Hora</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Valor</th>
            <th>Ação</th>
        </tr>
        <c:forEach items="${listGastoGanhos}" var="gastoGanho">
            <tr>
                <td>${gastoGanho.retornaHoraFormatada(gastoGanho.dataHora)}</td>
                <td>${gastoGanho.descricao}</td>
                <td>${gastoGanho.tipo}</td>
                <td>${gastoGanho.valor}</td>
                <td>
                   <a href="/gastoGanho/edit?id=${gastoGanho.id}">Editar</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/gastoGanho/delete?id=${gastoGanho.id}">Deletar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>