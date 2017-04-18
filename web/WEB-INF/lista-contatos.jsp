<%-- 
    Document   : lista-contatos
    Created on : 10/04/2017, 22:00:20
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de contatos</title>
    </head>
    <body>
	<%@include file="jspf/menu.jspf" %>
        <h1>Lista de contatos</h1>
        <div style="color:red;">${mensagem}</div>
        <table>
            <thread>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Telefone</th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="contato" items="${contatos}">
                <tr>
                    <td>${contato.id}</td>
                    <td>${contato.nome}</td>
                    <td>${contato.sobrenome}</td>
                    <td>${contato.telefone}</td>
                </tr>
            </c:forEach>
            </tbody>
            
    </body>
</html>
