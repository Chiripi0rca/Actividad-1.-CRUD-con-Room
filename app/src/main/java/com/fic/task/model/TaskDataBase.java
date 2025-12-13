package com.fic.task.model;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database (entities = {Task.class, History.class}, version = 2, exportSchema = false)
public abstract class TaskDataBase extends RoomDatabase{
    private static TaskDataBase INSTANCE;
    public abstract TaskDao taskDao();
    public abstract HistoryDao historyDao();

    public static synchronized TaskDataBase getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    TaskDataBase.class,
                    "task_database"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}