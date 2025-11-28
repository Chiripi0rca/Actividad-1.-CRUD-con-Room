package com.fic.task.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.util.Date;

@Entity(tableName = "tasks")
public class  Task {
    @PrimaryKey(autoGenerate = true)
    public int  id;

    @ColumnInfo(name = "task_title")
    public String title;

    @ColumnInfo( name = "task_description")
    public  String taskDescription;

    @ColumnInfo ( name = "created_at")
    public String createdAt;

    @ColumnInfo ( name = "is_completed")
    public  boolean isCompleted;

    //getters
     public int getId(){
         return id;
     }
     @NonNull
     public String getTitle(){
         return title;
    }

    public String getTaskDescription(){
         return taskDescription;
    }
    public String getCreatedAt(){
         return createdAt;
    }

    public boolean getIsCompleted(){
         return isCompleted;
    }

    //setters
    public void setTitle(@NonNull String title){
         this.title = title;
    }

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;

    }

    public void setCompleated(boolean completed){
         this.isCompleted = completed;
    }

}