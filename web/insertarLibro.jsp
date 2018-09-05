<%@ page import="data.DatabaseHelper" %>
<%@ page import="data.Libro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn,titulo,categoria);
    libro.insertar();

    response.sendRedirect("MostrarLibros.jsp");
%>
