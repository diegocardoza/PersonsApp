<h1 align="center">Persons App</h1>

<div align="center">
  <img src="https://github.com/diegocardoza/PersonsApp/blob/main/Docs/home_screen.png" width="367" height="776">
</div>

## Descripción

Persons App es una aplicacación sencilla con dos pantallas donde se puede agregar, eliminar, actualizar y leer usuarios de la base de datos local, pero realizada con buenas prácticas y con una arquictetura limpia.

## Características

- **Kotlin:** Lenguaje de programación moderno y seguro para el desarrollo de Android.
- **Arquitectura MVVM:** Separación de responsabilidades, facilidad de prueba y escalabilidad.
- **Clean Architecture:** Modularización del código para mantener la app organizada y fácil de mantener.
- **Jetpack Compose:** Framework de interfaz de usuario declarativa y moderna para Android.
- **Dagger Hilt:** Inyección de dependencias simplificada para facilitar la configuración y pruebas.
- **ROOM:** Base de datos local SQLite con ORM para persistencia de datos.

## Capturas de Pantalla

<div align="center">
  <img src="https://github.com/diegocardoza/PersonsApp/blob/main/Docs/home_screen.png" width="244" height="517"/>
<img src="https://github.com/diegocardoza/PersonsApp/blob/main/Docs/detail_screen.png" width="244" height="517"/>
</div>

## Arquitectura

Esta aplicación sigue el patrón de arquitectura **MVVM (Model-View-ViewModel)** con **Clean Architecture** para asegurar una clara separación de responsabilidades y facilidad de prueba. La arquitectura de la aplicación se organiza en capas, asegurando que cada capa tenga una única responsabilidad:

- **Capa de Presentación:** Contiene las pantallas y vistas (usando Jetpack Compose) y se comunica con ViewModels.
- **Capa de Dominio:** Contiene los casos de uso que representan la lógica de negocio de la aplicación.
- **Capa de Datos:** Se encarga de la gestión de datos desde una base de datos local (ROOM).
