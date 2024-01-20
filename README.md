# Image Viewer - MVP

## Descripción

Image Viewer es una aplicación de visualización de imágenes desarrollada en Java que sigue el patrón de diseño **Model-View-Presebter (MVP)**. Esta aplicación proporciona a los usuarios una interfaz intuitiva para cargar y visualizar sus imágenes de manera eficiente.

## Características

- **Interfaz Gráfica Intuitiva:** Una interfaz de usuario fácil de usar que permite a los usuarios navegar y visualizar imágenes de manera cómoda.

* **Carga de Imágenes:** La aplicación permite a los usuarios cargar imágenes desde su sistema de archivos local mediante un selector de carpeta. Los formatos de imágenes compatibles son: ".jpg", ".png", ".jpeg", ".bmp", ".tiff" y ".gif" (aunque este último solo mostrará el primer frame de la animación y no la animación completa).

+ **Gestión de Imágenes:** Los usuarios pueden realizar operaciones básicas como navegar hacia adelante y hacia atrás deslizando las imágenes.

## Patrón de Diseño

La arquitectura de Image Viewer sigue el patrón de diseño MVP, que es una derivación del patrón MVC y es utilizado mayoritariamente para construir interfaces de usuario. A continuación, se describen brevemente las responsabilidades de cada componente:

- **Modelo (Model):** Se encarga de la gestión de datos, incluyendo la carga y almacenamiento de imágenes.

* **Vista (View):** Presenta la interfaz de usuario al usuario y maneja las interacciones con el usuario.

+ **Presentador (Presenter):** Actúa como un intermediario entre el modelo y la vista. Responde a las acciones del usuario, manipula el modelo y actualiza la vista en consecuencia.
