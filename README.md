# ✅ Task App (Android)

Aplicación Android para gestionar tareas simples con **auditoría integrada**. Permite **crear, listar, actualizar y eliminar** tareas con una base de datos local (**Room**) y consultar un **historial completo** de todas las acciones CRUD.

---

## 📌 Contenido
- [Descripción](#descripcion)
- [Instalación y ejecución](#instalacion-y-ejecucion)
- [Base de datos](#base-de-datos)
  - [Entidad Task](#entidad-task)
  - [Entidad History](#entidad-history)
  - [DAOs](#daos)
  - [Base de datos Room](#base-de-datos-room)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Capturas](#capturas)

---

<a id="descripcion"></a>
## 🧾 Descripción

**Task App** implementa una agenda de tareas usando **Android + Java + Room**. Incluye pantallas para:

- **📋 Listar** tareas
- **➕ Agregar** nuevas tareas
- **✏️ Editar** tareas existentes
- **🗑️ Eliminar** tareas
- **🧾 Consultar historial** de acciones (auditoría)

---

<a id="instalacion-y-ejecucion"></a>
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

<a id="base-de-datos"></a>
## 🗄️ Base de datos

El proyecto utiliza **Room** y maneja dos tablas principales:

- **Task** (tareas)
- **History** (auditoría)

---

<a id="entidad-task"></a>
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

<a id="entidad-history"></a>
## 🧾 Entidad History

📍 **Ubicación:** `java/com/fic/task/model/History.java`

| Campo | Tipo | Descripción |
|---|---|---|
| **history_id** | `int` | Clave primaria autogenerada |
| **action** | `String` | Tipo: `insert_task`, `update_task`, `delete_task` |
| **created_at** | `String` | Fecha/hora (`yyyy-MM-dd HH:mm:ss`) |
| **details** | `String` | Información del registro afectado |

---

<a id="daos"></a>
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

<a id="base-de-datos-room"></a>
## 🏛️ Base de datos Room

📍 **Archivo:** `TaskDataBase.java`  
📌 **Versión:** **2**

**Define:**
- Base de datos Room con entidades **Task** y **History**
- Acceso a **TaskDao** y **HistoryDao**
- Configuración **Singleton** para mantener una sola instancia

---

<a id="estructura-del-proyecto"></a>
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

---
<a id="capturas"></a>
## 📷 Capturas
![1000000221](https://github.com/user-attachments/assets/2740d8a2-c4be-4f07-b632-f5db549255f5)
![1000000222](https://github.com/user-attachments/assets/ccdaf3aa-d434-478c-809b-ebf7b5d56bce)
![1000000227](https://github.com/user-attachments/assets/9008f303-e6a0-4286-8bc4-92dafc7fe4f3)
![1000000225](https://github.com/user-attachments/assets/c9a0075a-460b-4187-8ff8-30be0a7b0442)
![1000000224](https://github.com/user-attachments/assets/13d76eaa-3bab-4860-9f0e-3fcd69b6f7b6)
![1000000226](https://github.com/user-attachments/assets/fe25f707-2c93-45c0-b1ff-7fd933929426)
