package com.example.githubapi;

import com.example.githubapi.model.User;

import java.util.ArrayList;

public interface ApiListener {
    void onSuccess(ArrayList<User> users);
    void onFailed(String msg);
}
