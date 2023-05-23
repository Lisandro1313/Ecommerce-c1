# Ecommerce-c1

Este proyecto (en proceso) es una aplicación web desarrollada en Java utilizando el framework Spring Boot. Proporciona una plataforma de compras en línea que permite a los usuarios registrarse, iniciar sesión, gestionar su carrito de compras, realizar compras, administrar su perfil de usuario y disfrutar de varias funcionalidades adicionales.

## Requisitos del sistema

- Java 11 o una versión superior.
- Spring Boot.
- Base de datos relacional como MySQL, PostgreSQL o Oracle.
- Spring Security para autenticación y autorización de usuarios.
- Postman para realizar pruebas de integración.

## Funcionalidades

### Crear una cuenta de usuario:

Los usuarios pueden registrarse proporcionando su nombre, dirección de correo electrónico y contraseña.
Se envía un enlace de confirmación por correo electrónico para validar las cuentas.

### Iniciar sesión y cerrar sesión:

Los usuarios pueden iniciar sesión utilizando su dirección de correo electrónico y contraseña.
Tienen la opción de cerrar sesión en cualquier momento.

### Gestionar el carrito de compras:

Los usuarios pueden agregar productos al carrito de compras.
Pueden modificar la cantidad de productos en el carrito.
Pueden eliminar productos del carrito.

### Realizar compras:

Los usuarios pueden confirmar y realizar la compra de los productos en su carrito.
Se genera una orden de compra con la información relevante.

### Gestionar el perfil de usuario:

Los usuarios pueden ver y actualizar su información personal, como dirección de envío y datos de contacto.
Tienen la opción de cambiar su contraseña.

### Funcionalidades adicionales:

- Búsqueda de productos por nombre o categoría.
- Resultados de búsqueda ordenados y paginados.
- Sistema de calificación y reseñas para los productos.
- Calificaciones promedio mostradas en la página de detalles del producto.
- Productos recomendados basados en el historial de compras de los usuarios.
- Lista de deseos para guardar productos y comprarlos más tarde.
- Integración de una pasarela de pago externa, como PayPal o Stripe, para pagos seguros.
- Generación de informes y estadísticas sobre ventas y productos populares.
- Exportación de informes en formatos como CSV o PDF.
