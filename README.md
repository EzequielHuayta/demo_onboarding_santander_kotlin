# demo_onboarding_santander_kotlin
Proyecto realizado como muestra de lo que sería un onboarding para alguien del Santander. La aplicación incluye:

- Un sistema de login.
- Un llamado a una API externa llamada RandomUser que devuelve información de personas aleatorias.
- Un endpoint que devuelve una lista de tareas pendientes de realizar.

Se utiliza inyección de dependencias (Koin) y SLF4J para el logueo, además de una base de datos MySQL.

Esta es mi primera aplicación en Kotlin utilizando el framework Ktor. La idea era lograr lo mismo que logré en la aplicación Java Spring Boot.

La aplicación se comunica con un frontend desarrollado en React, que se encuentra en el siguiente repositorio: https://github.com/EzequielHuayta/demo_onboarding_react
La aplicacion desarrollada en java es: https://github.com/EzequielHuayta/demo_onboarding_santander
