# Biblioteca Comunitaria

## Descripción

La **Biblioteca Comunitaria** es una aplicación móvil diseñada para facilitar la gestión de una biblioteca dentro de una comunidad. Permite a los usuarios registrar, buscar y gestionar libros, así como obtener información actualizada sobre eventos y noticias relacionadas con la biblioteca.

## Funcionalidades Principales

1. **Registro de Libros**: Los usuarios pueden añadir nuevos libros a la base de datos local, incluyendo detalles como título, autor, género y estado de disponibilidad.
2. **Búsqueda de Libros**: Los usuarios pueden buscar libros en la base de datos local utilizando filtros como título, autor o género.
3. **Gestión de Préstamos**: Los usuarios pueden registrar el préstamo y la devolución de libros.
4. **Noticias y Eventos**: La aplicación obtiene datos de una API externa para mostrar noticias y eventos actuales relacionados con la biblioteca.
5. **Perfil del Usuario**: Los usuarios pueden ver y actualizar su perfil, incluyendo el historial de libros prestados.

## Tecnología Utilizada

- **Jetpack Compose**: Utilizado para construir una interfaz de usuario moderna y reactiva.
- **Kotlin**: Lenguaje de programación utilizado para desarrollar la aplicación.
- **SQLite**: Utilizado para la gestión local de la base de datos.
- **Room**: Biblioteca de persistencia que proporciona una capa de abstracción sobre SQLite para realizar operaciones CRUD.

## Logros Conseguidos

- **Interfaz de Usuario**: Implementación de una interfaz funcional utilizando Jetpack Compose, incluyendo elementos como `Scaffold`, `AppBar`, `Text`, `Image` y una lista de elementos.
- **Ciclo de Vida de Activity**: Manejo de los métodos del ciclo de vida de `Activity` y registro de eventos en Logcat.
- **Persistencia de Datos**: Creación y gestión de una base de datos utilizando SQLite y Room.
    - **Entidad**: Definición de la clase `Libro` para almacenar información de los libros.
    - **DAO**: Creación de la interfaz `LibroDao` para realizar operaciones CRUD.
    - **Database**: Implementación de la clase `BibliotecaDatabase` para inicializar Room.
- **Gestión de Dependencias**: Configuración y adición de dependencias necesarias para Room y otras bibliotecas.

## Configuración del Android Manifest

- **Nombre de la Aplicación**: Personalización del nombre de la aplicación como "Biblioteca Comunitaria".
- **Permisos**: Declaración de permisos para acceso a Internet y almacenamiento.
- **Orientación**: Fijación de la orientación de la `MainActivity` en vertical para evitar la rotación.

---

¡Gracias por usar **Biblioteca Comunitaria** y ser parte de esta iniciativa para mejorar la gestión de bibliotecas dentro de nuestras comunidades!
