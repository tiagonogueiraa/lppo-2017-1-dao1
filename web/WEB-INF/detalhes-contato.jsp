<%-- 
    Document   : novo-contato
    Created on : 17/04/2017, 21:21:37
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes Contato</title>
    </head>
    <body>
	<%@include file="jspf/menu.jspf" %>
        <div><h1>Detalhes Contato</h1></div>
	<form method="post">
            <input type="hidden" name="id" value="${contato.id}" />
            <div><label> Nome: <input type="text" name="nome" value="${contato.nome}" /> </label> </div><br>
            <div><label> Sobrenome: <input type="text" name="sobrenome" value="${contato.sobrenome}"/> </label>  </div><br>
            <div><label> Telefone: <input type="text" name="telefone" value="${contato.telefone}" placeholder="Telefone" /> </label>  </div><br><br>
	    <div> <input type="submit" value="Enviar" /> </div>
	    
	</form>
	
    </body>
</html>
