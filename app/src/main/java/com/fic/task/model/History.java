package com.fic.task.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {
      @PrimaryKey(autoGenerate = true)
      @ColumnInfo(name = "history_id")
      public int historyId;

      @NonNull
      @ColumnInfo (name = "accion")
      public String accion;

      @ColumnInfo(name = "created_at")
      public String createdAt;

      @ColumnInfo(name = "details")
      public String details;

      //Getters


    @NonNull
    public String getAccion() {
        return accion;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getHistoryId() {
        return historyId;
    }

    public String getDetails() {
        return details;
    }

    //setters


    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setAction(@NonNull String accion) {
        this.accion = accion;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
