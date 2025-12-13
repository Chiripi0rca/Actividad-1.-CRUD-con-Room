# ✅ Task App (Android)

Aplicación Android para gestionar tareas simples con **auditoría integrada**. Permite **crear, listar, actualizar y eliminar** tareas con una base de datos local (Room) y consultar un **historial completo** de todas las acciones CRUD.

---

## 📌 Contenido
- [Descripción](#-descripción)
- [Instalación y ejecución](#-instalación-y-ejecución)
- [Base de datos](#-base-de-datos)
  - [Entidad Task](#-entidad-task)
  - [Entidad History](#-entidad-history)
  - [DAOs](#-daos)
  - [Base de datos Room](#-base-de-datos-room)
- [Estructura del proyecto](#-estructura-del-proyecto)

---

## 🧾 Descripción
**Task App** implementa una agenda de tareas usando **Android + Java + Room**. Incluye pantallas para:

- **📋 Listar** tareas
- **➕ Agregar** nuevas tareas
- **✏️ Editar** tareas existentes
- **🗑️ Eliminar** tareas
- **🧾 Consultar historial** de acciones (auditoría)

---

## 🚀 Instalación y ejecución

### Requisitos
- **Android Studio**
- **Emulador** o **dispositivo Android**

### Pasos
1. Clona o descarga este repositorio
2. Abre el proyecto en **Android Studio**
3. Espera a que **Gradle** sincronice
4. Ejecuta con **Run** en un emulador o dispositivo físico

---

## 🗄️ Base de datos

El proyecto utiliza **Room** y maneja dos tablas principales:

- **Task** (tareas)
- **History** (auditoría)

---

## ✅ Entidad Task

📍 **Ubicación:** `java/com/fic/task/model/Task.java`

| Campo | Tipo | Descripción |
|---|---|---|
| **id** | `int` | Clave primaria autogenerada |
| **task_title** | `String` | Título de la tarea |
| **task_description** | `String` | Descripción detallada |
| **created_at** | `String` | Fecha de creación (`yyyy-MM-dd HH:mm`) |
| **is_completed** | `boolean` | Estado de completitud |

---

## 🧾 Entidad History

📍 **Ubicación:** `java/com/fic/task/model/History.java`

| Campo | Tipo | Descripción |
|---|---|---|
| **history_id** | `int` | Clave primaria autogenerada |
| **action** | `String` | Tipo: `insert_task`, `update_task`, `delete_task` |
| **created_at** | `String` | Fecha/hora (`yyyy-MM-dd HH:mm:ss`) |
| **details** | `String` | Información del registro afectado |

---

## 🧩 DAOs

### TaskDao
📍 **Archivo:** `TaskDao.java`

| Método | Acción |
|---|---|
| **insert(Task task)** | Insertar nueva tarea |
| **update(Task task)** | Actualizar tarea existente |
| **delete(Task task)** | Eliminar tarea |
| **getAllTask()** | Obtener todas las tareas |
| **getTaskById(int id)** | Obtener tarea por ID |

### HistoryDao
📍 **Archivo:** `HistoryDao.java`

| Método | Acción |
|---|---|
| **insert(History history)** | Registrar nueva acción en historial |
| **getAllHistory()** | Obtener historial ordenado por fecha |
| **getHistoryByAction(String action)** | Filtrar por tipo de acción |
| **getHistoryByDate(String date)** | Filtrar por fecha específica |
| **getHistoryByActionAndDate(String action, String date)** | Filtrar por acción y fecha |
| **deleteAllHistory()** | Limpiar todo el historial |

---

## 🏛️ Base de datos Room

📍 **Archivo:** `TaskDataBase.java`  
📌 **Versión:** **2**

**Define:**
- Base de datos Room con entidades **Task** y **History**
- Acceso a **TaskDao** y **HistoryDao**
- Configuración **Singleton** para mantener una sola instancia

---

## 🗂️ Estructura del proyecto

```text
project/
│── AndroidManifest.xml
│
├── java/com/fic/task/
│   ├── controller/
│   │   ├── TaskController.java         # Gestión de tareas con auditoría
│   │   └── HistoryController.java      # Gestión del historial
│   │
│   ├── model/
│   │   ├── Task.java                   # Entidad Task
│   │   ├── TaskDao.java                # DAO Task
│   │   ├── History.java                # Entidad History
│   │   ├── HistoryDao.java             # DAO History
│   │   └── TaskDataBase.java           # Configuración Room
│   │
│   └── view/
│       ├── TaskActivity.java           # Pantalla principal
│       ├── AddTaskActivity.java        # Agregar tarea
│       ├── UpdateTaskActivity.java     # Editar tarea
│       ├── HistoryActivity.java        # Historial
│       ├── TaskAdapter.java            # Adapter tareas
│       └── HistoryAdapter.java         # Adapter historial
│
└── res/
    ├── layout/
    │   ├── activity_task.xml
    │   ├── activity_add_task.xml
    │   ├── activity_upgrade_task.xml   # Nota: quizá querías "update"
    │   ├── activity_history.xml
    │   ├── item_task.xml
    │   └── item_history.xml
    │
    ├── values/
    │   ├── strings.xml
    │   ├── colors.xml
    │   └── themes.xml
    │
    └── mipmap/                         # Íconos
![WhatsApp Image 2025-12-13 at 5 19 43 PM](https://github.com/user-attachments/assets/53ffa72d-b3c1-4d77-afdc-5641774f098b)
![WhatsApp Image 2025-12-13 at 5 19 48 PM](https://github.com/user-attachments/assets/ab74fad5-eb0f-4e13-8026-f08931689af4)
![WhatsApp Image 2025-12-13 at 5 19 24 PM](https://github.com/user-attachments/assets/f501de29-77d4-49d0-b88a-02c61421eb77)
![WhatsApp Image 2025-12-13 at 5 19 34 PM](https://github.com/user-attachments/assets/5756ee1f-6914-42ac-bbe9-e9edd604ccf3)
![WhatsApp Image 2025-12-13 at 5 19 29 PM](https://github.com/user-attachments/assets/f34a9b4b-90f4-48b4-b950-0614d8fb0d30)
![WhatsApp Image 2025-12-13 at 5 19 24 PM (1)](https://github.com/user-attachments/assets/525870b9-783a-4e8d-b5f4-29a54758e2c7)
![WhatsApp Image 2025-12-13 at 5 19 29 PM (1)](https://github.com/user-attachments/assets/e6872792-3517-4d1b-8b3b-5dd015d2c3db)
![WhatsApp Image 2025-12-13 at 5 19 34 PM (1)](https://github.com/user-attachments/assets/f9402226-678a-403d-a6b0-b4fbfbf087ff)
![1000000227](https://github.com/user-attachments/assets/f0351257-9b07-44e0-a5a2-17981fda02b9)
![1000000225](https://github.com/user-attachments/assets/d5cbe79a-c6ad-4ca4-a5ad-baf8475de708)
![1000000224](https://github.com/user-attachments/assets/3ff9891a-3af3-4ca0-9980-f404fe544b5f)
![1000000226](https://github.com/user-attachments/assets/39bbb48f-4416-4466-a5a7-4c401e5fdc48)
![1000000221](https://github.com/user-attachments/assets/1a24505a-b8c6-41f3-a2c8-e52bbf172fff)
![1000000222](https://github.com/user-attachments/assets/786320fd-5da2-4f65-b24d-67b17e216f0c)

