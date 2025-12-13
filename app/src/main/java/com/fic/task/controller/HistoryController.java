package com.fic.task.controller;

import android.content.Context;
import android.util.Log;

import com.fic.task.model.History;
import com.fic.task.model.HistoryDao;
import com.fic.task.model.TaskDataBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryController {

    private final HistoryDao historyDao;

    public HistoryController(Context context){
        TaskDataBase taskDataBase = TaskDataBase.getInstance(context);
        historyDao = taskDataBase.historyDao();
    }


    //insertar una accion en el historial
    public boolean insetarAccion(String accion,
                                 String details){
        if (accion.isEmpty()){
            return false;
        }

        try{
            History history = new History();
            history.accion = accion;
            SimpleDateFormat Fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            history.createdAt = Fecha.format(new Date());
            history.details = details != null ? details : "";
            historyDao.insertHistory(history);
            Log.i("HISTORY_SAVE","La history se ha creado correctamente");
            return true;
        } catch (Exception e){
            Log.e("HISTORY_ERROR", e.getMessage());
            return false;
        }
    }

    //obtener todo el historial
    public List<History> getAllHistory(){
        return historyDao.getAllHistory();
    }


    //pbetner el tipo de accion mediante un filtro
    public List<History> getHistoruByAction(String accion){
        return historyDao.getHistoryByAction(accion);
    }

    //obtner el historial por fecha
    public List<History> getHistoryByDate(String date){
        return historyDao.getHistoryByDate(date);
    }



}
