<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.trueconnect.trueconnectrecom.models.Recomendacion" %>

<html>
<head>
  <title>TrueConnect - Tablón de Recomendaciones</title>
  <link rel="stylesheet" href="sty/stylistarecomendaciones.css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
  <script src="js/scripts.js"></script>

</head>

<body>

    <!-- Header con logo -->
    <header>
      <img src="img/logo-trueconnect.svg" alt="TrueConnect Logo" class="logo">
    </header>

    <div class="container">
      <h1>Tablón de Recomendaciones</h1>
      <p>
        <a href="recomendacion?action=new" class="btn new-rec">
          <i class="fas fa-plus"></i> Crear nueva recomendación
        </a>
      </p>

      <!-- Grid de recomendaciones -->
      <div class="recommendation-grid">
        <%
          List<Recomendacion> listaRecomendaciones =
                  (List<Recomendacion>) request.getAttribute("listaRecomendaciones");

          if (listaRecomendaciones != null) {
            for (Recomendacion inv : listaRecomendaciones) {
        %>
        <div class="recommendation-card">
          <h3><%= inv.getNombre() %></h3>
          <p><%= inv.getDescripcion() %></p>

          <!-- Botones de acción -->
          <div class="action-buttons">
            <a href="recomendacion?action=edit&id=<%= inv.getIdRecomendacion() %>" class="btn edit">
              <i class="fas fa-edit"></i> Editar
            </a>
            <a href="recomendacion?action=delete&id=<%= inv.getIdRecomendacion() %>" class="btn delete" onclick="return confirm('¿Deseas eliminar esta recomendación?');">
              <i class="fas fa-trash"></i> Eliminar
              </a>

            <a href="#" class="btn send" onclick="sendEmail('<%= inv.getIdRecomendacion() %>', '<%= inv.getNombre() %>', '<%= inv.getDescripcion() %>'); return false;">
              <i class="fas fa-share"></i> Enviar a...
            </a>


          </div>
        </div>
        <%
            }
          }
        %>
      </div>
    </div>

    <!-- redirección al índice -->
      <a href="index.jsp" style="color:grey">
        <i class="fas fa-home"></i> Volver al Inicio
      </a>
</body>
</html>
