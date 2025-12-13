package com.fic.task.view;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.task.R;
import com.fic.task.controller.HistoryController;
import com.fic.task.model.History;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity {

        private RecyclerView recyclerViewHistory;
        private HistoryAdapter historyAdapter;
        private HistoryController historyController;
        private Spinner spinnerActionFilter;
        private Button btnDateFilter, btnClearFilters;
        private TextView tvSelectedDate;
        private String selectedDate = "";
        private String selectedAction = "all";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.historyMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setupRecyclerView();
        setupFilters();
        loadHistory();
    }
    private void initViews(){
        recyclerViewHistory = findViewById(R.id.RVhistory);
        spinnerActionFilter = findViewById(R.id.spinnerActionFilter);
        btnDateFilter = findViewById(R.id.btnDateFilter);
        btnClearFilters = findViewById(R.id.btnClearFilters);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        historyController = new HistoryController(this);
    }

    private void setupRecyclerView(){
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(this));
        historyAdapter = new HistoryAdapter();
        recyclerViewHistory.setAdapter(historyAdapter);
    }

    private void setupFilters() {

        String[] actions = {"Todas las acciones", "Tarea Creada", "Tarea Actualizada", "Tarea Eliminada"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, actions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActionFilter.setAdapter(adapter);

        spinnerActionFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selectedAction = "all";
                        break;
                    case 1:
                        selectedAction = "insert_task";
                        break;
                    case 2:
                        selectedAction = "update_task";
                        break;
                    case 3:
                        selectedAction = "delete_task";
                        break;
                }
                applyFilters();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnDateFilter.setOnClickListener(v -> showDatePicker());
        btnClearFilters.setOnClickListener(v -> clearFilters());

    }
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    selectedDate = String.format(Locale.getDefault(), "%04d-%02d-%02d",
                            selectedYear, selectedMonth + 1, selectedDay);
                    tvSelectedDate.setText("Fecha: " + selectedDate);
                    tvSelectedDate.setVisibility(View.VISIBLE);
                    applyFilters();
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void clearFilters() {
        selectedDate = "";
        selectedAction = "all";
        spinnerActionFilter.setSelection(0);
        tvSelectedDate.setVisibility(View.GONE);
        loadHistory();
    }

    private void applyFilters() {
        List<History> filteredHistory;

         if (!selectedDate.isEmpty()) {
            // Filtrar solo por fecha
            filteredHistory = historyController.getHistoryByDate(selectedDate);
        } else if (!selectedAction.equals("all")) {
            // Filtrar solo por acción
            filteredHistory = historyController.getHistoruByAction(selectedAction);
        } else {
            // Sin filtros
            filteredHistory = historyController.getAllHistory();
        }

        historyAdapter.setData(filteredHistory);
    }

    private void loadHistory() {
        List<History> history = historyController.getAllHistory();
        historyAdapter.setData(history);
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadHistory();
    }

}
