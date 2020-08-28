package com.example.mynotesapp.database;

import com.example.mynotesapp.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM notes")
    List<Note> getAllData();

    @Insert
    void insertData(Note note);

    @Update
    void updateData(Note note);

    @Delete
    void deleteData(Note note);
}
