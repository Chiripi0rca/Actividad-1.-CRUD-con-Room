package com.fic.task.controller;

import android.content.Context;
import android.util.Log;

import com.fic.task.model.HistoryDao;
import com.fic.task.model.Task;
import com.fic.task.model.TaskDao;
import com.fic.task.model.TaskDataBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskController {

    private final TaskDao taskDao;
    private final HistoryController historyController;

    public TaskController(Context context){
        TaskDataBase taskDataBase =  TaskDataBase.getInstance(context);
        taskDao = taskDataBase.taskDao();
        historyController = new HistoryController(context);
    }

    //create a task
    public boolean createTask(String title,
                              String description,
                              boolean isCompleted){
        //add a restriction
        if (title.isEmpty()) {
            return false; // mandatory title
        }
         try {
             Task task = new Task();
             task.title = title;
             task.taskDescription = description;
             SimpleDateFormat Fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
             task.createdAt = Fecha.format(new Date());
             task.isCompleted = isCompleted;
             taskDao.insert(task);

             //insertar la tarea en el historial
             historyController.insetarAccion("insert_task", "Tarea Creada");

             Log.i("TASK_SAVE", "La tarea se ha creado correctamente");
             return true;
         } catch (Exception e){
             Log.e("TASK_ERROR", e.getMessage());
             return false;
         }
    }
    //update task
    public boolean updateTask(Task task,
                              String newTitle,
                              String newDescription,
                              boolean completed){

        if(newTitle.isEmpty()){
            return false; //mandatory title
        }
        task.setTitle(newTitle);
        task.setTaskDescription(newDescription);
        task.setCompleated(completed);
        taskDao.update(task);
        //registrar el update en el historial
        historyController.insetarAccion("update_task", "Tarea actualizada");
        return true;

    }

    //delete a task
    public  void deleteTask(Task task){
        String taskTitle = task.getTitle();
        taskDao.delete(task);

        //registrar la eliminacion de la tarea en el historial
        historyController.insetarAccion("delete_task", "Tarea eliminada" + taskTitle);
    }
    //get id
    public Task getTaskById(int id) {
        return taskDao.getTaskById(id);
    }
    //get all task
    public List<Task> getAllTask() {
        return taskDao.getAllTask();
    }

}
