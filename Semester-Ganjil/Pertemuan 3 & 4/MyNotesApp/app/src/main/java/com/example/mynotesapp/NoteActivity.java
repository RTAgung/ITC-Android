package com.example.mynotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotesapp.database.NoteDao;
import com.example.mynotesapp.database.NoteDatabase;
import com.example.mynotesapp.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE = "extra_note";
    public static final int REQUEST_EDIT = 200;
    public static final int RESULT_EDIT = 210;
    public static final int RESULT_DELETE = 220;
    public static final int ALERT_DIALOG_CLOSE = 10;
    public static final int ALERT_DIALOG_DELETE = 20;

    private EditText etTitle, etText;
    private Button btnSave;
    private Note note;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteDao = NoteDatabase.getInstance(this).noteDao();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        note = getIntent().getParcelableExtra(EXTRA_NOTE);

        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        btnSave = findViewById(R.id.btn_save);

        etTitle.setText(note.getTitle());
        etText.setText(note.getText());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String text = etText.getText().toString();
                String date = getCurrentDate();

                Note updateNote = new Note(note.getId(), title, text, date);

                noteDao.updateData(updateNote);

                setResult(RESULT_EDIT);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_delete) {
            showDialogMessage(ALERT_DIALOG_DELETE);
        } else if (item.getItemId() == android.R.id.home) {
            showDialogMessage(ALERT_DIALOG_CLOSE);
        }
        return super.onOptionsItemSelected(item);
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void showDialogMessage(int type) {
        final boolean isDialogClose = (type == ALERT_DIALOG_CLOSE);
        String message;
        String title;

        if (isDialogClose) {
            title = "Batal";
            message = "Apakah anda ingin membatalkan perubahan note?";
        } else {
            title = "Hapus";
            message = "Apakah anda yakin ingin menghapus note?";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isDialogClose) {
                            finish();
                        } else {
                            noteDao.deleteData(note);
                            setResult(RESULT_DELETE);
                            finish();
                        }
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

    @Override
    public void onBackPressed() {
        showDialogMessage(ALERT_DIALOG_CLOSE);
    }
}