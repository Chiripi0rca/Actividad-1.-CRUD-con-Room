# Task App

Aplicación Android para gestionar tareas simples. Permite crear, listar, actualizar y eliminar tareas usando una base de datos local.

## Descripción breve
Esta aplicación implementa una agenda de tareas usando Android, Java y Room como sistema de persistencia. Incluye pantallas para visualizar la lista de tareas, agregar nuevas y editar las existentes.

## Instrucciones de instalación y ejecución

### Requisitos
- Android Studio .
- Dispositivo Android o emulador.

### Pasos
1. Clonar o descargar este repositorio.
2. Abrir la carpeta del proyecto en Android Studio.
3. Esperar a que Gradle sincronice automáticamente.
4. Ejecutar la app con el botón *Run* seleccionando un emulador o dispositivo físico.

## Estructura de la base de datos

El proyecto utiliza **Rooom**, La tabla principal es `Task`.

### Entidad `Task`
Ubicación: `java/com/fic/task/model/Task.java`

Campos:
- `id` (int, clave primaria autogenerada)
- `title` (String)
- `description` (String)
- `date` (String)

### DAO
Archivo: `TaskDao.java`  
Métodos:
- `insertTask(Task task)`
- `updateTask(Task task)`
- `deleteTask(Task task)`
- `getTasks()` (retorna lista de tareas)

### Base de datos
Archivo: `TaskDataBase.java`  
Define:
- Base de datos Room con la entidad `Task`.
- Acceso al DAO.

## Estructura del proyecto

project/
│── AndroidManifest.xml
│
├── java/com/fic/task/
│ ├── controller/
│ │ └── TaskController.java
│ ├── model/
│ │ ├── Task.java
│ │ ├── TaskDao.java
│ │ └── TaskDataBase.java
│ └── view/
│ ├── TaskActivity.java
│ ├── AddTaskActivity.java
│ ├── UpdateTaskActivity.java
│ └── TaskAdapter.java
│
└── res/
├── layout/ (layouts de XML)
└── mipmap/ (íconos)


## Capturas de pantalla

![1000000225](https://github.com/user-attachments/assets/a5a63b55-62fb-4fef-aa4a-9216557a1dfa)
![1000000227](https://github.com/user-attachments/assets/2f6cafae-a019-4144-964f-81d5fc2a62a4)
![1000000222](https://github.com/user-attachments/assets/d758dabd-fde1-408f-baef-d5ae91898fd2)
![1000000221](https://github.com/user-attachments/assets/4beed5cc-c21d-49c0-b8c7-20be6e7d1fc1)
![1000000226](https://github.com/user-attachments/assets/61477d78-dd29-4e18-b12d-bb3c9905c766)
![1000000224](https://github.com/user-attachments/assets/c56676c7-fa03-42f2-8567-ea18388327f1)
