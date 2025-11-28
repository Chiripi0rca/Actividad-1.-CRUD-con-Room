package com.fic.task.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.task.R;
import com.fic.task.model.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskAdapter  extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    /*esta interfaz srive como un listener cuando
    el usuario le pica al boton de editar o eliminar estos metodos se detonan*/
    public interface OnTaskActionListener {
        /*estos dos metodos reciben un objeto tipo task el cual contiene la informacion
        sobre la task id,title, descripcion , etc.
        */
        void onEdit(Task task);
        void onDelete(Task task);
    }
    private final List<Task> taskList = new ArrayList<>();
    // esto es un listener que manejara las acciones de ediccion y elimnacion
    private final OnTaskActionListener listener;

    /* Este constructor crea un nuevo adpater el
    * cual usuara el lsitener indicado para saber que acciones va
    * a realizar (editar o eliminar)
    */
    public TaskAdapter(OnTaskActionListener listener) {
        //inicializamos el listener
        this.listener = listener;
    }

    public void setData(List<Task> task){
        taskList.clear();
        if(task != null){
            taskList.addAll(task);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task,parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int positon) {
         Task task = taskList.get(positon);
         holder.TvTitle.setText(task.title);
         holder.TvTaskDescription.setText(task.taskDescription);
         holder.TvcreatedAt.setText(task.createdAt);
         boolean isCompleted = task.isCompleted;
         String status;
         if (isCompleted){
             status = "Completado";
         } else{
             status = "No completado";
         }
         holder.TvIsCompleted.setText(status);

        holder.btnEdit.setOnClickListener(v -> {
                listener.onEdit(task);
        });

        holder.btnDelete.setOnClickListener(v -> {
                listener.onDelete(task);
        });
    }

    @Override
    public int getItemCount(){
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        TextView TvTitle, TvTaskDescription, TvcreatedAt, TvIsCompleted;
        ImageButton btnEdit, btnDelete;

        public TaskViewHolder (@NonNull View itemView){
            super(itemView);
            TvTitle = itemView.findViewById(R.id.TvTitle);
            TvTaskDescription = itemView.findViewById(R.id.TvTaskDescripcion);
            TvcreatedAt = itemView.findViewById(R.id.TvcreatedAt);
            TvIsCompleted = itemView.findViewById(R.id.TvisCompleted);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
