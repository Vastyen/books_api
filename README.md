## Proyecto de Venta de Libros

Este es un proyecto simple de venta de libros utilizando una arquitectura MVC en Java con tecnologías como Spring Boot, JPA, Lombok y PostgreSQL Driver. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en diferentes tablas relacionadas, como `Usuario`, `Libro`, `LibroFavorito`, `Categoria`, `UsuarioLibroFavorito`, `Valoracion`, entre otras.

### Requisitos previos

Para ejecutar este proyecto, asegúrese de tener instalados los siguientes componentes en su máquina:

- Java 11.
- PostgreSQL instalado y configurado con una base de datos creada para el proyecto.
- Git (opcional, para clonar el repositorio).

### Instalación y configuración

1. Clonar el repositorio o descargar el código fuente como un archivo ZIP.
   ```bash
   git clone https://github.com/tu-usuario/proyecto-venta-libros.git
   ```
   O bien, puede hacer clic en el botón "Code" y luego "Download ZIP" en esta página.

2. Abrir el proyecto en un IDE favorito (por ejemplo, IntelliJ IDEA, Eclipse, etc.).

3. Abrir el archivo `application.properties` ubicado en `src/main/resources` y configurar la conexión a la base de datos PostgreSQL cambiando las siguientes propiedades según su configuración:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_la_base_de_datos
   spring.datasource.username=nombre_de_usuario
   spring.datasource.password=contraseña
   ```

4. Ejecutar el proyecto como una aplicación Spring Boot.

### Uso del API

Una vez que el proyecto esté en funcionamiento, se podrá interactuar con el API a través de las siguientes rutas:

- `POST /usuarios`: Crear un nuevo usuario.
- `GET /usuarios`: Obtener todos los usuarios.
- `GET /usuarios/{id}`: Obtener un usuario por su ID.
- `PUT /usuarios/{id}`: Actualizar un usuario existente por su ID.
- `DELETE /usuarios/{id}`: Eliminar un usuario por su ID.

- `POST /libros`: Crear un nuevo libro.
- `GET /libros`: Obtener todos los libros.
- `GET /libros/{isbn}`: Obtener un libro por su ISBN.
- `PUT /libros/{isbn}`: Actualizar un libro existente por su ISBN.
- `DELETE /libros/{isbn}`: Eliminar un libro por su ISBN.

- `POST /libros-favoritos`: Agregar un libro como favorito para un usuario.
- `GET /libros-favoritos`: Obtener todos los libros favoritos de los usuarios.
- `GET /libros-favoritos/{id}`: Obtener un libro favorito por su ID.
- `DELETE /libros-favoritos/{id}`: Eliminar un libro favorito por su ID.

- `POST /valoraciones`: Dejar una valoración para un libro.
- `GET /valoraciones`: Obtener todas las valoraciones.
- `GET /valoraciones/{id}`: Obtener una valoración por su ID.
- `DELETE /valoraciones/{id}`: Eliminar una valoración por su ID.

### Notas adicionales

Este es un proyecto de ejemplo con una implementación básica. En un entorno de producción, se recomienda agregar más lógica de negocio, manejo de excepciones, validaciones de entrada, seguridad, entre otros aspectos para hacerlo más robusto y seguro.

Además, este proyecto utiliza una base de datos PostgreSQL. Si desea cambiar a otro motor de base de datos, deberá ajustar la configuración en el archivo `application.properties` y las anotaciones de las entidades JPA según corresponda.
