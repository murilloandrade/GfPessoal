<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Editar Carona</title>
</head>
<body>
<div align="center">
    <h2>Editar Carona</h2>
    <form:form action="update" method="put" modelAttribute="carona">
        <table border="0" cellpadding="5">
            <tr style="visibility: hidden">
                <td>ID: </td>
                    <td>${carona.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
            <tr>
                <td>Descrição: </td>
                <td><form:input path="descricao" required="required"/></td>
            </tr>
            <tr>
                <td>Bairro: </td>
                <td><form:input path="bairro" required="required"/></td>
            </tr>
            <tr>
                <td>Tipo: </td>
                <td><form:select name="TipoCarona" path="tipo" items="${tipos}">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Turno: </td>
                <td><form:select name="TurnoCarona" path="turno" items="${turnos}">
                </form:select>
                </td>
            </tr>
            <tr>
                <td>Status: </td>
                <td><form:select name="StatusCarona" path="status" items="${status}">
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