<%@ page import="data.Libro" %><%--
  Created by IntelliJ IDEA.
  User: manolo
  Date: 6/09/18
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn,titulo,categoria);
    libro.salvar();

    response.sendRedirect("MostrarLibros.jsp");
%>