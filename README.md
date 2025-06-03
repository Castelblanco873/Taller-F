# *Taller 7 - Llaves Favoritas*


Este proyecto corresponde al Taller 7 del curso, y tiene como objetivo implementar una funcionalidad completa de gestión de llaves favoritas dentro de una aplicación bancaria virtual. Las "llaves favoritas" son cuentas o destinatarios frecuentes a los cuales un usuario transfiere dinero con regularidad. Esta funcionalidad permite optimizar la experiencia del cliente al facilitar las transferencias repetidas, minimizando errores y tiempos de ingreso.

El desarrollo contempla todas las capas de una arquitectura limpia, aplicando los principios SOLID, los patrones de diseño GoF y Enterprise Patterns, con un enfoque profesional en la separación de responsabilidades, mantenibilidad y pruebas automatizadas.


## *Objetivos del Proyecto*
Aplicar los conceptos de diseño de software enseñados durante el curso.

Implementar un API REST completo usando Java 21 y Spring Boot 3.5.0.

Integrar persistencia de datos con SQLite 3.

Usar JavaFX para la parte visual (pantallas).

Seguir el flujo de trabajo ágil con git-flow, estimación ágil, y documentación.

Alcanzar un code coverage mínimo del 75% mediante pruebas unitarias.


## *Backlog Funcional*
Cada historia de usuario se corresponde con un caso de uso principal en la gestión de llaves favoritas:

*CU001:* Agregar una nueva llave favorita.

*CU002:* Listar todas las llaves favoritas registradas por el usuario.

*CU003:* Validar si una llave ya está registrada como favorita.

*CU004:* Editar el alias asignado a una llave favorita.

*CU005:* Eliminar una llave favorita registrada.

Estas funcionalidades están modeladas como endpoints del API y conectadas con una base de datos SQLite.


## *Stack Tecnológico*
*Lenguaje principal:* Java 21

*Framework web:* Spring Boot 3.5.0

*Base de datos:* SQLite 3 (ligera y embebida, ideal para este tipo de prototipo)

*Interfaz gráfica:* JavaFX (para visualización y manipulación en escritorio)

*Control de versiones:* Git + GitHub

*Gestión ágil:* Kanban / Scrum con planificación por historias


## *Estructura de Ramas (Git-flow)*
El flujo de trabajo en Git está basado en Git-flow, para garantizar control de versiones profesional y colaborativo:

*main:* contiene las versiones estables del proyecto.

*develop:* rama principal de desarrollo donde se integran todas las funcionalidades antes de pasar a producción.

feature/*: ramas para cada funcionalidad o historia de usuario (ej: feature/CU001-agregar-favorito)

release/*: para preparar versiones estables que se fusionarán a main.

hotfix/*: correcciones urgentes directamente sobre la rama main.
