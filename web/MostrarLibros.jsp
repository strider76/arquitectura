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
    List<Libro> listaLibros = null;

    if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")){
        listaLibros = Libro.buscarTodos();
    } else {
        listaLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
    }

    for (Libro libro : listaLibros) {
%>
            <%=libro.getIsbn()%>
            <%=libro.getTitulo()%>
            <%=libro.getCategoria()%>
            <a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a>
            <a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a> <br/>
<%  }

%>
<a href="FormularioLibro01Inicio.html">Insertar Libro</a>
</body>
</html>
