package com.example.mynotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tambah");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            showDialogMessage();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showDialogMessage();
    }

    private String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void showDialogMessage() {
        String message;
        String title;

        title = "Batal";
        message = "Apakah anda ingin membatalkan penambahan note?";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }
}