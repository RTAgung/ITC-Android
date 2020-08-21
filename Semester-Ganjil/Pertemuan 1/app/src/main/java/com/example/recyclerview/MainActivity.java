package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Game> listGame;
    private RecyclerView recyclerView;
    private GameListAdapter listAdapter;
    private GameGridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_item);

        listGame = DataDummy.getAllDataDummy();

        recyclerView.setHasFixedSize(true);
        setGridList();
    }

    void setLinearList(){
        listAdapter = new GameListAdapter(listGame);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    void setGridList(){
        gridAdapter = new GameGridAdapter(listGame);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(gridAdapter);
    }
}