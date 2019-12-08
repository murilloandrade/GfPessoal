<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lista Caronas</title>
</head>
<body>
<div align="center">
    <h2>Lista Caronas</h2>

    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Buscar" />
    </form>

    <h3><a href="/carona/new">Nova Carona</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>Descrição</th>
            <th>Tipo</th>
            <th>Turno</th>
            <th>Bairro</th>
            <th>Usuário</th>
            <th>Status</th>
            <th>Ação</th>
        </tr>
        <c:forEach items="${listCaronas}" var="carona">
            <tr>
                <td>${carona.id}</td>
                <td>${carona.descricao}</td>
                <td>${carona.tipo}</td>
                <td>${carona.turno}</td>
                <td>${carona.bairro}</td>
                <td>${carona.usuario.nome}</td>
                <td>${carona.status}</td>
                <td>
                   <a href="/carona/edit?id=${carona.id}">Editar</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/carona/delete?id=${carona.id}">Deletar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>