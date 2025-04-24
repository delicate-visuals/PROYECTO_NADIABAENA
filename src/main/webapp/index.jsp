<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TrueConnect - Tu espacio para compartir y cuidar conexiones reales</title>
    <link rel="stylesheet" href="sty/main.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>

<body class="index">

        <!-- Vídeo de fondo -->
        <video autoplay muted loop playsinline id="videoBackground">
            <source src="video/grupo-jovenes.mp4" type="video/mp4">
            Tu navegador no soporta el formato de vídeo.
        </video>

        <!-- Capa oscura encima del vídeo -->
        <div class="overlay"></div>

        <!-- Contenido principal encima del vídeo -->
        <div class="index-content">
            <header>
                <img src="img/logo-trueconnect.svg" alt="TrueConnect Logo" class="logo">
            </header>

            <h1>Conecta con lo que importa</h1>
            <b>Tu espacio digital para crear conexiones auténticas, compartir recomendaciones y fortalecer tus vínculos.</b>

            <p>Al registrarte como usuario, podrás unirte a grupos de personas con intereses similares, donde encontrarás un <strong>tablón de recomendaciones</strong>. Aquí podrás ver las sugerencias de planes, eventos y experiencias compartidas por otros miembros de tu grupo cercano o aquellos que comparten tus pasiones.</p>

            <p>En TrueConnect, conectar con quienes te rodean no solo enriquece tus relaciones, sino que también contribuye a tu bienestar personal. Descubre y comparte nuevas experiencias que te inspiren, y fortalece los lazos que más te importan.</p>

            <p>
                Explora las recomendaciones compartidas por otros usuarios y empieza a inspirarte.
            </p>

            <br/>

            <!-- Enlace al listado de recomendaciones -->
            <a href="recomendacion" onclick="checkLogin(event)">Ir al tablón de recomendaciones</a>

            <div class="btn-container">
                <form action="login.jsp" method="get">
                    <button type="submit" class="btn">Iniciar Sesión</button>
                </form>

                <form action="register.jsp" method="get">
                    <button type="submit" class="btn">Registrarse</button>
                </form>
            </div>

        </div>

        <!-- Script para redirigir según si está logeado -->
        <script>
            function checkLogin(event) {
                event.preventDefault();
                const username = <%= session.getAttribute("username") != null ? "'" + session.getAttribute("username") + "'" : "null" %>;

                if (username) {
                    window.location.href = "recomendacion?action=list";
                } else {
                    window.location.href = "login.jsp";
                }
            }
        </script>

</body>
</html>
