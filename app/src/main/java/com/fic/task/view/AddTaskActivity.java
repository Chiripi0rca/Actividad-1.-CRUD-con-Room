package com.fic.task.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fic.task.R;
import com.fic.task.controller.TaskController;

public class AddTaskActivity extends AppCompatActivity {
    private EditText ETTaskTitle;
    private EditText ETTaskDescripcion;
    private CheckBox CBtaskCompleted;
    private Button btnSaveTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.TaskForm), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();

        btnSaveTask.setOnClickListener(view -> {
            String taskTitle = ETTaskTitle.getText().toString();
            String taskDescription = ETTaskDescripcion.getText().toString();
            boolean isCompleted = CBtaskCompleted.isChecked();
            saveTask(taskTitle,taskDescription,isCompleted);
        });
    }
    private void saveTask(String title, String description, boolean isCompleated){
        TaskController taskController = new TaskController(this);
        boolean result = taskController.createTask(title, description, isCompleated);

        if(result){
            Toast.makeText(this, getString(R.string.save_task),Toast.LENGTH_SHORT).show();
            clearForm();
            showTaskActivity();
        } else{
            Toast.makeText(this, getString(R.string.error_save_task),Toast.LENGTH_SHORT).show();
        }
    }

    private void showTaskActivity(){
        Intent intent = new Intent(AddTaskActivity.this, TaskActivity.class);
        startActivity(intent);
    }

    private void clearForm(){
        ETTaskDescripcion.setText("");
        ETTaskTitle.setText("");
        CBtaskCompleted.setChecked(false);
    }

    private void initViews(){
        ETTaskTitle = findViewById(R.id.ETtaskTitle);
        ETTaskDescripcion = findViewById(R.id.ETtaskDescription);
        CBtaskCompleted = findViewById(R.id.CBtaskCompleted);
        btnSaveTask = findViewById(R.id.btnsaveTask);
    }

}
