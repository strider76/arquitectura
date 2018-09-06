<%@ page import="data.Libro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String isbn = request.getParameter("isbn");
    Libro libro = new Libro(isbn);
    libro.borrar();
    response.sendRedirect("MostrarLibros.jsp");
%>