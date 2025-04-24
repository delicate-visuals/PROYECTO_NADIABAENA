<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <link rel="stylesheet" href="sty/registros.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

</head>

<body>
<!-- Header con logo -->
<header>
    <img src="img/logo-trueconnect.svg" alt="TrueConnect Logo" class="logo">
</header>

<div class="container">
    <h1>Registrarse</h1>

    <form action="register" method="post">
        <div class="form-group">
            <label for="username">Usuario:</label>
            <input type="text" name="username" id="username" required>
        </div>

        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" name="password" id="password" required>
        </div>

        <button type="submit">Registrar</button>
    </form>

    <!-- redirección al índice -->
    <a href="index.jsp" style="color:grey; display:block; margin-top: 20px;">
        <i class="fas fa-home"></i> Volver al Inicio
    </a>
</div>
</body>

</html>
