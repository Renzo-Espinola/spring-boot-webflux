# Spring Boot WebFlux con MongoDB Reactive y Thymeleaf

Este proyecto es una aplicación de ejemplo que utiliza **Spring Boot WebFlux** con una base de datos reactiva en **MongoDB** y **Thymeleaf** como motor de plantillas. Su objetivo es demostrar cómo implementar una arquitectura reactiva en Spring Boot y realizar operaciones CRUD de forma no bloqueante.

## Características

- **Arquitectura reactiva**: Interacciones no bloqueantes entre las capas del backend.
- **MongoDB Reactivo**: Almacenamiento de datos en MongoDB con un repositorio no bloqueante.
- **API RESTful** para la gestión de productos.
- **Interfaz de usuario con Thymeleaf**: Visualización de productos en una página web.

## Tecnologías

- **Java 17+**
- **Spring Boot 3**
- **Spring WebFlux**
- **Spring Data Reactive MongoDB**
- **Thymeleaf**
- **MongoDB**

## Requisitos previos

- **Java 17** o superior
- **MongoDB** instalado y en ejecución
- **Maven** para gestionar las dependencias

## Instalación y configuración

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/Renzo-Espinola/spring-boot-webflux.git
    ```
2. Accede al directorio del proyecto:
    ```bash
    cd spring-boot-webflux
    ```
3. Configura MongoDB en el archivo `application.properties` (si es necesario):
    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/nombre_de_tu_base
    ```

4. Ejecuta el proyecto:
    ```bash
    mvn spring-boot:run
    ```

## Uso

La aplicación incluye las siguientes rutas principales:

- **/listar** - Muestra una lista de productos.
- **/form** - Formulario para crear y editar productos.
- **/listar-full** - listar productos con repeat de 5000 veces.
- **/listar-datadriver** - listar productos con datadriver con un buffer de 2 elementos y con un delay de 1 segundo.
- **/listar-chunked** -  listar productos con repeat de 5000 veces pero configurado en application.propierties la anotacion de chunked.

## Ejemplo de Uso

1. Accede a `http://localhost:8080/listar` para ver la lista de productos.
2. Usa el enlace para crear un nuevo producto, llenar los campos y enviarlo para guardar en MongoDB.

## Estructura del Proyecto

- `controller/` - Controladores Spring MVC para manejar las rutas y la lógica del frontend.
- `models/` - Modelos de MongoDB que representan la entidad `Producto`.
- `dao/` - Repositorio reactivo que maneja las interacciones con MongoDB.
- `service/` - Repositorio reactivo que maneja las interacciones con MongoDB.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

¡Gracias por visitar este repositorio! No dudes en crear un **issue** si encuentras algún problema.
