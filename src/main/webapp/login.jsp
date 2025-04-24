<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="sty/registros.css">

</head>

<!-- Header con logo -->
<header>
    <img src="img/logo-trueconnect.svg" alt="TrueConnect Logo" class="logo">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

</header>

<div class="container">
    <h1>Iniciar Sesión</h1>

    <form action="login" method="post" class="form">
        <label for="username">Usuario:</label>
        <input type="text" name="username" required />

        <label for="password">Contraseña:</label>
        <input type="password" name="password" required />

        <button type="submit" class="btn"><i class="fas fa-sign-in-alt"></i> Entrar</button>
    </form>

    <p>¿No tienes cuenta? <a href="register.jsp">Regístrate aquí</a></p>

    <!-- redirección al índice -->
    <a href="index.jsp" style="color:grey">
        <i class="fas fa-home"></i> Volver al Inicio
    </a></div>

</body>
</html>

