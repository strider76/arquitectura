<%@ page import="data.DatabaseHelper" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="data.Libro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar Libros</title>
</head>
<body>
    <select name="categoria">
<%
    List<String> categorias = null;
    categorias = Libro.buscarTodasLasCategorias();

    for (String categoria : categorias) {
%>
            <option value="<%=categoria%>"><%=categoria%></option>
<%
    }
%>
    </select><br/>
<%
    List<Libro> listaLibros = Libro.buscarTodos();

    for (Libro libro : listaLibros) {
%>
            <%=libro.getIsbn()%>
            <%=libro.getTitulo()%>
            <%=libro.getCategoria()%><br/>
<%  }

%>
<a href="FormularioLibro01Inicio.html">Insertar Libro</a>
</body>
</html>
