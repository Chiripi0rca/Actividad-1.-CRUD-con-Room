package com.fic.task.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.task.R;
import com.fic.task.controller.TaskController;
import com.fic.task.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TaskActivity extends AppCompatActivity {
    private TaskAdapter taskAdapter;
    private TaskController taskController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task);

        RecyclerView recyclerViewTask = findViewById(R.id.RVtask);
        recyclerViewTask.setLayoutManager(new LinearLayoutManager(this));
        taskController = new TaskController(this);

        taskAdapter = new TaskAdapter(new TaskAdapter.OnTaskActionListener() {
            @Override
            public void onEdit(Task task) {
                Intent intent = new Intent(TaskActivity.this, UpdateTaskActivity.class);
                intent.putExtra(UpdateTaskActivity.EXTRA_TASK_ID, task.getId());
                startActivity(intent);
            }

            @Override
            public void onDelete(Task task) {
                taskController.deleteTask(task);
                Toast.makeText(TaskActivity.this, "Se ha eliminado correctamente tu tarea", Toast.LENGTH_SHORT).show();
                loadTasks();
            }
        });
        recyclerViewTask.setAdapter(taskAdapter);
        loadTasks();


        FloatingActionButton FabAddTask = findViewById(R.id.FabaddTask);

        FabAddTask.setOnClickListener(view ->{
            showAddTaskActivity();
        });

    }

    private void loadTasks(){
        List<Task> tasks = taskController.getAllTask();
        taskAdapter.setData(tasks);
    }

    private void showAddTaskActivity(){
        Intent intent = new Intent(TaskActivity.this, AddTaskActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();
        loadTasks();
    }

}
