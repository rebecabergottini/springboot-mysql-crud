# CRUD con Spring Boot y MySQL usando JPA

Este es un proyecto que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) simple utilizando **Spring Boot**, **JPA (Java Persistence API)** y **MySQL** como base de datos.

## Descripción

El proyecto permite realizar operaciones CRUD sobre una entidad `User` en una base de datos MySQL utilizando Spring Boot. La integración con MySQL se realiza mediante JPA, lo que permite una manipulación eficiente de la base de datos.

## Tecnologías utilizadas

- **Spring Boot**: Framework para desarrollar aplicaciones en Java.
- **JPA (Java Persistence API)**: Para interactuar con la base de datos.
- **MySQL**: Sistema de gestión de bases de datos.
- **Maven**: Herramienta de construcción y gestión de dependencias.

### Funcionalidades

- **Crear**: Permite agregar un nuevo registro de usuario.
- **Leer**: Permite consultar y mostrar todos los registros de usuarios o uno específico.
- **Actualizar**: Permite modificar los registros de un usuario existente.
- **Eliminar**: Permite eliminar un registro de usuario.

## Endpoints

### 1. Obtener todos los usuarios
**Método HTTP**: `GET`  
**Ruta**: `/api/users`  
**Descripción**: Obtiene todos los usuarios almacenados en la base de datos.

### 2. Crear un nuevo usuario
**Método HTTP**: `POST`  
**Ruta**: `/api/users`  
**Descripción**: Crea un nuevo usuario en la base de datos.
- **Cuerpo de la solicitud**: Un objeto JSON con los campos del usuario (nombre, apellido, correo).

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

### 3. Obtener un usuario por ID
**Método HTTP**: `GET`  
**Ruta**: `/api/users/{id}`
**Descripción**: Obtiene los detalles de un usuario específico por su ID.

### 4. Actualizar un usuario por ID
**Método HTTP**: `PUT`
**Ruta**: `/api/users/{id}`
**Descripción**: Actualiza la información de un usuario existente, identificándolo por su ID.

- **Cuerpo de la solicitud**: Un objeto JSON con los nuevos datos del usuario.
```json
{
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "janesmith@example.com"
}
```

### 5. Eliminar un usuario por ID
**Método HTTP**: `DELETE`
**Ruta**: `/api/users/{id}`
**Descripción**: Elimina un usuario por su ID.

## Instalación

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/nombre-del-repositorio.git
cd nombre-del-repositorio
```

### 2. Configura la base de datos MySQL

Crea una base de datos en MySQL. Por ejemplo, `crud_spring_boot`.

```sql
CREATE DATABASE crud_spring_boot;
```

En el archivo `src/main/resources/application.properties`, configura la conexión con tu base de datos MySQL. Asegúrate de poner tus credenciales correctas.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_spring_boot?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3. Ejecuta el proyecto

Puedes ejecutar el proyecto con Maven desde la línea de comandos:

```bash
mvn spring-boot:run
```

O si estás utilizando un IDE como IntelliJ o Eclipse, simplemente ejecuta la clase principal CrudApplication.java.

### 4. Verifica la API

Una vez que el servidor esté en ejecución, puedes acceder a la API a través de:

- **POST** `/api/users`: Crear un nuevo registro de usuario.
- **GET** `/api/users`: Obtener todos los usuarios.
- **GET** `/api/users/{id}`: Obtener un usuario por su ID.
- **PUT** `/api/users/{id}`: Actualizar un usuario.
- **DELETE** `/api/users/{id}`: Eliminar un usuario.

Puedes probar las solicitudes utilizando herramientas como Postman o Insomnia.

Este proyecto está licenciado bajo la Licencia Apache 2.0 - consulta el archivo [LICENSE](LICENSE) para más detalles.
