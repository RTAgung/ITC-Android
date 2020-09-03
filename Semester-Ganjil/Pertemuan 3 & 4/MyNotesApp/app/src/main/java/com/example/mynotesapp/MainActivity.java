package com.example.mynotesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynotesapp.adapter.NoteAdapter;
import com.example.mynotesapp.database.NoteDao;
import com.example.mynotesapp.database.NoteDatabase;
import com.example.mynotesapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private NoteDao noteDao;
    private RecyclerView rvNotes;
    private ArrayList<Note> listNotes = new ArrayList<>();
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDao = NoteDatabase.getInstance(this).noteDao();

        noteAdapter = new NoteAdapter(this);
        rvNotes = findViewById(R.id.rv_notes);
        rvNotes.setHasFixedSize(true);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(noteAdapter);
        loadData();

        fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteAddActivity.class);
                startActivityForResult(intent, NoteAddActivity.REQUEST_ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NoteAddActivity.REQUEST_ADD) {
            if (resultCode == NoteAddActivity.RESULT_ADD) {
                loadData();
                showSnackbar("Data Berhasil Ditambahkan");
            }
        } else if (requestCode == NoteActivity.REQUEST_EDIT) {
            if (resultCode == NoteActivity.RESULT_EDIT) {
                loadData();
                showSnackbar("Data Berhasil Diedit");
            } else if (resultCode == NoteActivity.RESULT_DELETE) {
                loadData();
                showSnackbar("Data Berhasil Dihapus");
            }
        }
    }

    void loadData() {
        List<Note> data = noteDao.getAllData();
        listNotes.clear();
        listNotes.addAll(data);
        noteAdapter.setListNotes(listNotes);
        if (data.size() == 0) {
            showSnackbar("Tidak Ada Data");
        }
    }

    private void showSnackbar(String message) {
        Snackbar.make(rvNotes, message, Snackbar.LENGTH_LONG).show();
    }
}