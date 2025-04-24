// Función para enviar un correo con los detalles de la recomendación
function sendEmail(idRecomendacion, nombre, descripcion) {
    // Construir el asunto y el cuerpo del email
    var subject = "Recomendación: " + nombre;
    var body = "Hola,\n\nTe recomiendo la siguiente recomendación: " + nombre + "\n\nDescripción: " + descripcion + "\n\nPuedes ver más detalles en: http://tusitio.com/recomendacion?id=" + idRecomendacion;

    // Crear el enlace mailto con el asunto y cuerpo prellenado
    var mailtoLink = "mailto:?subject=" + encodeURIComponent(subject) + "&body=" + encodeURIComponent(body);

    // Abrir el cliente de correo electrónico del usuario
    window.location.href = mailtoLink;
}

