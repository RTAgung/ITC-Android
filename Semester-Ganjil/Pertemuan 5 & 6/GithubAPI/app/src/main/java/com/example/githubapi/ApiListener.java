package com.example.githubapi;

import com.example.githubapi.model.User;

import java.util.ArrayList;

public interface ApiListener<T> {
    void onSuccess(T users);
    void onFailed(String msg);
}
