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
import com.fic.task.model.Task;

public class UpdateTaskActivity extends AppCompatActivity {
    public static final String EXTRA_TASK_ID = "EXTRA_TASK_ID";
    private EditText ETTaskTitle;
    private EditText ETTaskDescripcion;
    private CheckBox CBtaskCompleted;
    private Button btnSaveTask;
    private TaskController taskController;
    private Task currentTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upgrade_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.UpdateTaskForm), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        taskController = new TaskController(this);


        //recibimos el id
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(EXTRA_TASK_ID)){
            int taskId = intent.getIntExtra(EXTRA_TASK_ID, -1);
            if (taskId != -1){
                //obtnemos la task a partir del id
                currentTask = taskController.getTaskById(taskId);
            }
        }

        if(currentTask != null){
            // aqui agregamos los datos que estan el DB al formulario
            ETTaskTitle.setText(currentTask.getTitle());
            ETTaskDescripcion.setText(currentTask.getTaskDescription());
            CBtaskCompleted.setChecked(currentTask.getIsCompleted());
        } else{
            Toast.makeText(this, "Error al cargar la tarea", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        btnSaveTask.setOnClickListener(view -> {
            String taskTitle = ETTaskTitle.getText().toString();
            String taskDescription = ETTaskDescripcion.getText().toString();
            boolean isCompleted = CBtaskCompleted.isChecked();
            updateTask(taskTitle,taskDescription,isCompleted);
        });
    }
    private void updateTask(String title, String description, boolean isCompleated){
        TaskController taskController = new TaskController(this);
        boolean result = taskController.updateTask(currentTask, title, description, isCompleated);

        if(result){
            Toast.makeText(this, getString(R.string.save_task),Toast.LENGTH_SHORT).show();
            clearForm();
            showTaskActivity();
        } else{
            Toast.makeText(this, getString(R.string.error_save_task),Toast.LENGTH_SHORT).show();
        }
    }

    private void showTaskActivity(){
        Intent intent = new Intent(UpdateTaskActivity.this, TaskActivity.class);
        startActivity(intent);
    }

    private void clearForm(){
        ETTaskDescripcion.setText("");
        ETTaskTitle.setText("");
        CBtaskCompleted.setChecked(false);
    }

    private void initViews(){
        ETTaskTitle = findViewById(R.id.ETNewtaskTitle);
        ETTaskDescripcion = findViewById(R.id.ETNewtaskDescription);
        CBtaskCompleted = findViewById(R.id.CBNewtaskCompleted);
        btnSaveTask = findViewById(R.id.btnNewSaveTask);
    }

}
