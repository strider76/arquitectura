<%@ page import="data.Libro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: manolo
  Date: 6/09/18
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Libro libro = Libro.buscarPorClave(request.getParameter("isbn")); %>
<html>
<head>
    <title>Formulario Editar Libro</title>
</head>
<body>
<form id="formularioEdicion" action="SalvarLibro.jsp">
    <fieldset>
        <legend>Formulario Alta de Libro</legend>
        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="<%=libro.getIsbn()%>"/>
        </p>
        <p>
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" value="<%=libro.getTitulo()%>">
        </p>
        <p>
            <label for="categoria">Categoría:</label>
            <select id="categoria" name="categoria">
                <%
                    List<String> listaCategorias = Libro.buscarTodasLasCategorias();
                    for (String categoria : listaCategorias) {
                        if (libro.getCategoria().equals(categoria)) {
                %>
                        <option value="<%=categoria%>" selected="selected"><%=categoria%></option>
                <%
                        } else {
                %>
                        <option value="<%=categoria%>" selected="selected"><%=categoria%></option>
                <%
                        }
                    }
                %>
            </select>
            <br/>
        </p>
        <p>
            <input type="submit" value="Salvar"/>
        </p>
    </fieldset>
</form>
</body>
</html>
