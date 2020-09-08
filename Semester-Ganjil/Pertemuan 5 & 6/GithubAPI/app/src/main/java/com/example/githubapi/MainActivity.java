package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.githubapi.adapter.UserAdapter;
import com.example.githubapi.model.User;
import com.example.githubapi.service.GithubApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGithub;
    private UserAdapter userAdapter;
    private ArrayList<User> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAdapter = new UserAdapter();
        rvGithub = findViewById(R.id.rv_github);
        rvGithub.setHasFixedSize(true);
        rvGithub.setLayoutManager(new LinearLayoutManager(this));
        rvGithub.setAdapter(userAdapter);

        GithubApi githubApi = new GithubApi();
        githubApi.getAllUser(userListener);
    }

    ApiListener<ArrayList<User>> userListener = new ApiListener<ArrayList<User>>() {
        @Override
        public void onSuccess(ArrayList<User> users) {
            listUser.addAll(users);
            userAdapter.setUsers(listUser);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ERROR API", msg);
        }
    };
}