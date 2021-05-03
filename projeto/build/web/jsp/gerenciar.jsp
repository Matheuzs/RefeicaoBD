<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="./css/refeicoes.css">
<link rel="shortcut icon" href="./imagens/ufabc.ico">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Projeto Refeição BD :: Gerenciar</title>
    </head>
    <body>
        <jsp:include page="./../WEB-INF/jspf/menu.jspf" flush="true"/>
        <jsp:include page="./../WEB-INF/jspf/footer.jspf" flush="true"/>
        <header><h2>Gerenciar</h2></header>
        <h3>Funções CRUD de CLIENTE</h3></center> 
        <form method="POST" action="${pageContext.request.contextPath}/controlador?opcao=cliente">
            <select name="crud" onchange="this.form.submit()">
                <option id="" value="">--selecione uma opção--</option>
                <option value="create"><c:out value="C - Inserir novo cliente"/></option>
                <option value="read"><c:out value="R - Ler um cliente"/></option>
                <option value="update"><c:out value="U - Atualizar um cliente"/></option>
                <option value="delete"><c:out value="D - Deletar um cliente"/></option>
            </select>
            <br>
        </form>
    
        <h3>Funções CRUD de restaurante</h3></center> 
        <form method="POST" action="${pageContext.request.contextPath}/controlador?opcao=restaurante">
            <select name="crud" onchange="this.form.submit()">
                <option id="" value="">--selecione uma opção--</option>
                <option value="create"><c:out value="C - Inserir novo restaurante"/></option>
                <option value="read"><c:out value="R - Ler um restaurante"/></option>
                <option value="update"><c:out value="U - Atualizar um restaurante"/></option>
                <option value="delete"><c:out value="D - Deletar um restaurante"/></option>
            </select>
            <br>
        </form>
</body>
</html>