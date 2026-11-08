
# Guali Tutor – Fase 3

## Tutorial de desarrollo de una aplicación móvil Android

### 1. Introducción

Guali Tutor es una aplicación móvil educativa desarrollada en Android Studio utilizando el lenguaje de programación Java.

Su propósito es facilitar el aprendizaje de conceptos básicos de programación mediante lecciones que incluyen explicaciones teóricas y ejemplos prácticos.

Este proyecto corresponde a la Fase 3 del curso de Programación II de la Universidad Mariano Gálvez de Guatemala.

### 2. Objetivo general

Desarrollar una interfaz gráfica móvil que permita a los estudiantes consultar lecciones de programación, registrar su progreso de aprendizaje y personalizar su experiencia.

### 3. Funcionalidades de la aplicación

- Pantalla principal con acceso a las diferentes secciones.
- Listado de tres lecciones de programación en Java.
- Visualización de explicaciones y ejemplos prácticos.
- Opción para marcar las lecciones como completadas.
- Historial del progreso de aprendizaje.
- Configuración del nombre del estudiante.
- Almacenamiento local mediante SharedPreferences.
- Navegación entre las diferentes pantallas.

### 4. Herramientas utilizadas

- Android Studio: entorno de desarrollo.
- Java: lenguaje de programación.
- XML: diseño de las interfaces gráficas.
- Android Emulator: ejecución y pruebas de la aplicación.
- SharedPreferences: almacenamiento local del progreso y la configuración.
- GitHub: publicación del proyecto y del tutorial.

### 5. Estructura de la aplicación

La aplicación está organizada en las siguientes pantallas:

1. MainActivity: menú principal.
2. LeccionesActivity: listado de lecciones.
3. DetalleLeccionActivity: contenido de cada lección.
4. HistorialActivity: progreso del estudiante.
5. ConfiguracionActivity: configuración del nombre del estudiante.

Cada pantalla utiliza un archivo XML para definir su diseño visual.

### 6. Prerrequisitos para desarrollar la aplicación

Para desarrollar y ejecutar Guali Tutor se necesitan las siguientes herramientas:

- Una computadora con Windows y espacio suficiente para Android Studio y el emulador.
- Android Studio instalado.
- Android SDK configurado desde Android Studio.
- Java como lenguaje de programación.
- Un emulador Android o un dispositivo físico compatible.
- Conexión a Internet para descargar las dependencias necesarias.

### 7. Instalación y configuración de Android Studio

#### Paso 1. Descargar Android Studio

Ingresar al sitio oficial:

https://developer.android.com/studio

Seleccionar la opción de descarga correspondiente al sistema operativo.

#### Paso 2. Instalar Android Studio

Ejecutar el instalador descargado y seguir las instrucciones del asistente.

Verificar que se instalen los componentes necesarios, incluyendo Android SDK.

#### Paso 3. Crear un nuevo proyecto

1. Abrir Android Studio.
2. Seleccionar New Project.
3. Elegir una plantilla basada en Views, como Empty Views Activity.
4. Asignar el nombre GualiTutorFase3.
5. Configurar el paquete com.guali.tutor.
6. Seleccionar Java como lenguaje.
7. Elegir el nivel mínimo de Android compatible.
8. Presionar Finish y esperar la sincronización de Gradle.

#### Paso 4. Configurar el emulador

1. Abrir Device Manager desde Android Studio.
2. Seleccionar Create Virtual Device.
3. Elegir un dispositivo de tipo Phone.
4. Seleccionar y descargar una imagen del sistema Android compatible.
5. Finalizar la configuración.
6. Iniciar el emulador.

#### Paso 5. Ejecutar el proyecto

1. Seleccionar el emulador configurado.
2. Presionar Run en Android Studio.
3. Esperar la compilación e instalación.
4. Verificar que la aplicación se abra correctamente.

