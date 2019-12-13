    <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>GFPessoal</title>
    <style>
        body {background-color: black; color: aqua;}
        tr {color: aqua; border-style: solid; border-color:aqua;}
        input { border-style: solid; border-color:aqua;}
        form:select { border-style: solid; border-color:aqua;}
    </style>
</head>
<body>
<div align="center">
    <h2>Editar Gasto/Ganho</h2>
    <form:form action="update" method="put" modelAttribute="gastoGanho">
        <table border="0" cellpadding="5">
            <tr style="visibility: hidden">
                <td>ID: </td>
                    <td>${gastoGanho.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
            <tr>
                <td>Descrição: </td>
                <td><form:input path="descricao" required="required"/></td>
            </tr>
            <tr>
                <td>Valor: </td>
                <td><form:input path="valor" required="required"/></td>
            </tr>
            <tr>
                <td>Tipo: </td>
                <td><form:select name="TipoGastoGanho" path="tipo" items="${tipos}">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Atualizar"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>