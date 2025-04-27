---->TrueConnect - README

-Descripción del Proyecto
TrueConnect es una herramienta web en fase beta cuyo objetivo principal es fortalecer las relaciones personales a través de recomendaciones compartidas entre usuarios registrados.
En esta versión, los usuarios pueden registrarse, iniciar sesión y gestionar un tablón de recomendaciones (crear, editar, eliminar y compartir recomendaciones).

-Requisitos Previos
Java JDK 17 o superior instalado
Servidor Apache Tomcat 10+
MySQL Server y MySQL Workbench instalados
IDE IntelliJ IDEA (opcional, recomendado para trabajar en el proyecto)
Navegador actualizado (Google Chrome, Firefox, etc.)

-Tecnologías Utilizadas
Java (backend)
JSP y Servlets
HTML5, CSS3, JavaScript (frontend)
MySQL (base de datos)
GitHub (control de versiones)

-Instrucciones para Configurar el Proyecto

1.Clonar el repositorio: descarga o clona el proyecto desde GitHub en tu máquina local.

2. Importar el proyecto en IntelliJ IDEA: Abrir IntelliJ → Importar proyecto → Selecciona la carpeta descargada → Importar como proyecto Maven o Dynamic Web Project (según configuración).

3. Configurar la Base de Datos: Abrir MySQL Workbench.
Crear una base de datos nueva (trueconnect_bbdd).
Ejecutar el script SQL incluido en el proyecto para crear las tablas necesarias.

4. Configurar la conexión a la base de datos: Editar el archivo de configuración de la conexión (DBConnection.java) si es necesario: Usuario, contraseña y URL de conexión según tu servidor local.

5. Configurar el servidor: Configura Tomcat en IntelliJ IDEA o en tu entorno de trabajo.
Asegúrate de añadir el proyecto y desplegarlo en Tomcat.

6. Subir el proyecto y ejecutar: Ejecuta el servidor.
Accede al navegador en la ruta: http://localhost:8080/TrueConnect  (ajusta el puerto si fuera necesario).

- Uso Básico de la Aplicación
--Desde la página principal (index.jsp) puedes:
Registrarte como nuevo usuario.
Iniciar sesión.
Acceder al tablón de recomendaciones (se comprobará automáticamente si estás logueado).

--Dentro del tablón de recomendaciones puedes:
Añadir nuevas recomendaciones.
Editar o eliminar las recomendaciones que has creado.
Compartir recomendaciones por email.

