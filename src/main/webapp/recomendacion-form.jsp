<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.trueconnect.trueconnectrecom.models.Recomendacion" %>

<%
  // Obtenemos el objeto "recomendacion" si existe
  Recomendacion recomendacion = (Recomendacion) request.getAttribute("recomendacion");
  boolean isEdit = (recomendacion != null); // Si no es nulo, es edición
%>

<html>
<head>
  <title><%= isEdit ? "Editar Recomendacion" : "Nueva Recomendacion" %></title>
  <link rel="stylesheet" href="sty/stylistarecomendaciones.css">

</head>

<body>

<!-- Header con logo -->
<header>
  <img src="img/logo-trueconnect.svg" alt="TrueConnect Logo" class="logo">
</header>

<div class="container">

    <h1><%= isEdit ? "Editar Recomendación" : "Nueva Recomendación" %></h1>

  <form action="recomendacion?action=save" method="post">

      <!-- <input type="hidden" name="action" value="save" /> -->  <!-- Este lo puedes eliminar -->
      <% if (isEdit) { %>
      <input type="hidden" name="idRecomendacion" value="<%= recomendacion.getIdRecomendacion() %>" />
      <% } %>

      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"
               value="<%= isEdit ? recomendacion.getNombre() : "" %>" required />
      </div>

      <div class="form-group">
          <label for="descripcion">Descripción:</label>
          <textarea id="descripcion" name="descripcion" rows="4" required>
    <%= isEdit ? recomendacion.getDescripcion() : "" %>
  </textarea>
      </div>


      <div class="form-actions">
        <button type="submit" class="btn">Guardar</button>
      </div>

    </form>
  </div>

  <!-- redirección al listado de recomendaciones -->
  <a href="recomendacion" style="color:grey">
    <i class="fas fa-list"></i> Volver al Listado
  </a>


</body>
</html>
