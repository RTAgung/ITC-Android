package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotesapp.database.NoteDao;
import com.example.mynotesapp.database.NoteDatabase;
import com.example.mynotesapp.model.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteAddActivity extends AppCompatActivity {
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    public static final String EXTRA_ADD = "extra_add";
    private EditText etTitle, etText;
    private Button btnAdd;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        noteDao = NoteDatabase.getInstance(this).noteDao();

        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String text = etText.getText().toString();
                String date = getCurrentDate();

                Note note = new Note(title, text, date);
                noteDao.insertData(note);

                setResult(RESULT_ADD);
                finish();
            }
        });
    }

    private String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}