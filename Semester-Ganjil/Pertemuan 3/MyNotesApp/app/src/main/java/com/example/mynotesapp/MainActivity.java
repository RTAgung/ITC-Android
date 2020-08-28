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

        noteAdapter = new NoteAdapter();
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
            }
        }
    }

    void loadData() {
        List<Note> data = noteDao.getAllData();
        if (data.size() > 0) {
            if (listNotes.size() > 0)
                listNotes.clear();
            listNotes.addAll(data);
            noteAdapter.setListNotes(listNotes);
        } else {
            Snackbar.make(rvNotes, "Tidak Ada Data", Snackbar.LENGTH_LONG).show();
        }
    }
}