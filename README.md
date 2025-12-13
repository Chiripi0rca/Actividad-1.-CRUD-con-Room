# Task App

Aplicación Android para gestionar tareas simples con sistema de auditoría integrado. Permite crear, listar, actualizar y eliminar tareas usando una base de datos local, además de consultar un historial completo de todas las acciones realizadas.

## Descripción breve
Esta aplicación implementa una agenda de tareas usando Android, Java y Room como sistema de persistencia. Incluye pantallas para visualizar la lista de tareas, agregar nuevas, editar las existentes y consultar un historial detallado de todas las operaciones CRUD realizadas.

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

Entidad Task
Ubicación: java/com/fic/task/model/Task.java
Campos:

id (int, clave primaria autogenerada)
task_title (String, título de la tarea)
task_description (String, descripción detallada)
created_at (String, fecha de creación en formato yyyy-MM-dd HH:mm)
is_completed (boolean, estado de completitud)

Entidad History
Ubicación: java/com/fic/task/model/History.java
Campos:

history_id (int, clave primaria autogenerada)
action (String, tipo de acción: "insert_task", "update_task", "delete_task")
created_at (String, fecha y hora de la acción en formato yyyy-MM-dd HH:mm:ss)
details (String, información sobre el registro afectado)

DAOs
TaskDao
Archivo: TaskDao.java
Métodos:

insert(Task task) - Insertar nueva tarea
update(Task task) - Actualizar tarea existente
delete(Task task) - Eliminar tarea
getAllTask() - Obtener todas las tareas
getTaskById(int id) - Obtener tarea por ID

HistoryDao
Archivo: HistoryDao.java
Métodos:

insert(History history) - Registrar nueva acción en el historial
getAllHistory() - Obtener todo el historial ordenado por fecha
getHistoryByAction(String action) - Filtrar por tipo de acción
getHistoryByDate(String date) - Filtrar por fecha específica
getHistoryByActionAndDate(String action, String date) - Filtrar por acción y fecha
deleteAllHistory() - Limpiar todo el historial

Base de datos
Archivo: TaskDataBase.java
Versión: 2
Define:

Base de datos Room con las entidades Task y History
Acceso a ambos DAOs (TaskDao y HistoryDao)
Configuración singleton para instancia única

Estructura del proyecto
project/
│── AndroidManifest.xml
│
├── java/com/fic/task/
│   ├── controller/
│   │   ├── TaskController.java         # Gestión de tareas con auditoría
│   │   └── HistoryController.java      # Gestión del historial
│   │
│   ├── model/
│   │   ├── Task.java                   # Entidad de tarea
│   │   ├── TaskDao.java                # DAO de tareas
│   │   ├── History.java                # Entidad de historial
│   │   ├── HistoryDao.java             # DAO de historial
│   │   └── TaskDataBase.java           # Configuración de Room
│   │
│   └── view/
│       ├── TaskActivity.java           # Pantalla principal de tareas
│       ├── AddTaskActivity.java        # Pantalla para agregar tareas
│       ├── UpdateTaskActivity.java     # Pantalla para editar tareas
│       ├── HistoryActivity.java        # Pantalla de historial
│       ├── TaskAdapter.java            # Adaptador para lista de tareas
│       └── HistoryAdapter.java         # Adaptador para lista de historial
│
└── res/
    ├── layout/
    │   ├── activity_task.xml           # Layout principal
    │   ├── activity_add_task.xml       # Layout agregar tarea
    │   ├── activity_upgrade_task.xml   # Layout actualizar tarea
    │   ├── activity_history.xml        # Layout historial
    │   ├── item_task.xml               # Item de tarea
    │   └── item_history.xml            # Item de historial
    │
    ├── values/
    │   ├── strings.xml                 # Strings de la aplicación
    │   ├── colors.xml                  # Colores
    │   └── themes.xml                  # Temas
    │
    └── mipmap/                         # Íconos de la aplicación

## Capturas de pantalla

![1000000225](https://github.com/user-attachments/assets/a5a63b55-62fb-4fef-aa4a-9216557a1dfa)
![1000000227](https://github.com/user-attachments/assets/2f6cafae-a019-4144-964f-81d5fc2a62a4)
![1000000222](https://github.com/user-attachments/assets/d758dabd-fde1-408f-baef-d5ae91898fd2)
![1000000221](https://github.com/user-attachments/assets/4beed5cc-c21d-49c0-b8c7-20be6e7d1fc1)
![1000000226](https://github.com/user-attachments/assets/61477d78-dd29-4e18-b12d-bb3c9905c766)![WhatsApp Image 2025-12-13 at 5 19 43 PM](https://github.com/user-attachments/assets/fe879819-b28a-4528-8dd7-0d868c858f33)
![WhatsApp Image 2025-12-13 at 5 19 48 PM](https://github.com/user-attachments/assets/3f7bd84a-69f4-4ebc-aaec-80368dbac76a)
![WhatsApp Image 2025-12-13 at 5 19 24 PM](https://github.com/user-attachments/assets/b4cd2b29-f56c-4313-a10d-2c4b9a2a2a6c)
![WhatsApp Image 2025-12-13 at 5 19 34 PM](https://github.com/user-attachments/assets/4f00c835-7540-4996-ab78-2817ac36d95f)
![WhatsApp Image 2025-12-13 at 5 19 29 PM](https://github.com/user-attachments/assets/9cf7ada0-d491-4b56-b0d2-5028ef4f806c)
![WhatsApp Image 2025-12-13 at 5 19 24 PM (1)](https://github.com/user-attachments/assets/6641e4f6-2b43-454e-8904-0c3a29dfe280)
![WhatsApp Image 2025-12-13 at 5 19 29 PM (1)](https://github.com/user-attachments/assets/f9f5e784-fc0a-4a63-a77c-ce99bd46a07d)
![WhatsApp Image 2025-12-13 at 5 19 34 PM (1)](https://github.com/user-attachments/assets/09135b4f-7b60-4bef-9536-9392b18339c4)

![1000000224](https://github.com/user-attachments/assets/c56676c7-fa03-42f2-8567-ea18388327f1)
