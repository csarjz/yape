[GitHub](https://github.com/csarjz/yape)

## Reto Técnico Android
Mi proyecto cuenta una serie de prácticas y tecnologías contemporáneas recomendadas por
Google (Jetpack Compose, MVVM + MVI, Clean Architecture). Es un proyecto modularizado, con inyección
de dependencias, pruebas unitarias, SSL Pinning y ofuscación de código para cuando se compile en modo release.


## Patrón de Diseño y Arquitectura
Implementé una arquitectura limpia que fomenta la separación de preocupaciones y la escalabilidad
del proyecto. Dividí la aplicación en capas claramente definidas:

**_Capa de Presentación:_**  
Aquí se encuentra la lógica de la interfaz de usuario, utilizando Jetpack Compose junto con el patrón MVVM más MVI.

**_Capa de Dominio:_**  
Esta capa contiene las reglas de negocio, los Use Cases y Entities.

**_Capa de Datos:_**  
Gestioné el acceso a datos a través de Repositories y Data Sources lo que permite mantener un alto
grado de flexibilidad al cambiar las fuentes de datos, como una API o una base de datos local.

**_MVVM (Model-View-ViewModel):_**  
Utilicé MVVM como el patrón de diseño en la capa de presentación. Esto ayuda a separar la lógica
de la interfaz de usuario de los datos subyacentes y a mejorar la mantenibilidad del código.  
El ViewModel actúa como un intermediario entre la Vista y la capa de datos, permitiendo una gestión
eficiente del estado y la comunicación en la aplicación.

**_MVI (Model-View-Intent):_**  
MVI promueve un flujo de datos unidireccional, lo que significa que los eventos y las acciones del
usuario siguen un camino predecible desde la Vista hasta el ViewModel, luego el ViewModel se
encarga de manejar esos eventos de UI y generar un nuevo ViewState. Este patrón facilita en gran
medida las Pruebas Unitarias.


## Funcionalidad
La aplicación hace uso de Room para almacenar localmente las recetas, de esta manera solo se llama
al servidor la primera vez que se abre la aplicación, esto crea una experiencia de usuario mucho más
fluida y disminuye el uso de datos móviles, además agregué un botón para que el usuario pueda
actualizar los datos desde el servidor cuan lo crea necesario.

## Seguridad
En el apartado de seguridad he configurado la ofuscación de código para cuando se compile en modo release
de esta manera será mucho más difícil que alguien pueda entender el código si descompila el apk.

Agregue SSL Pinning para fortalecer la confianza en la autenticidad del servidor remoto
de esta manera se logra mitigar ataques Man-in-the-Middle (MitM) donde los atacantes pueden intentar
interceptar y manipular el tráfico de red.


## Librerías
**_Jetpack Compose:_**  
Es un moderno framework de desarrollo de interfaces de usuario (UI) para aplicaciones Android.

**_Compose Navigation:_**  
Gestiona la navegación entre Composables, de esta manera se pueden crear aplicaciones con una sola Activity.

**_Hilt:_**  
Es una librería de inyección de dependencias para Android que permite reducir el trabajo repetitivo
de insertar dependencias de forma manual.

**_Coil:_**  
Es una potente librería para cargar imágenes y es la recomendada por Google, Coil almacena las
imágenes en caché para que la próxima carga sea mucho más rápida.

**_Retrofit:_**  
El clásico Retrofit nos permite realizar peticiones HTTP de una manera simplificada.

**_Room:_**  
Proporciona una capa de abstracción que facilita la administración de bases de datos SQLite,
simplifica el proceso de trabajar con datos persistentes en Android.

**_JUnit y Mockk:_**  
Para el desarrollo de pruebas unitarias.

**_Gradle Version Catalogs:_**  
No es una librería como tal, pero es el estándar actualmente y será la forma predetermina para
gestionar las dependencias en la próxima versión de Android Studio.  
Version Catalog es una lista de dependencias que se encuentra en el archivo libs.versions.toml esto
ayuda a gestionar las versiones de las dependencias y complementos de forma estructurada y organizada.
Estas declaraciones se pueden compartir y reutilizar en diferentes módulos, lo que facilita
la actualización y gestión de dependencias.