package com.example.githubapi.service;

import com.example.githubapi.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubInterface {

    @GET("users?")
    Call<ArrayList<User>> getUsers(@Query("since") int random);

    @GET("users/{username}")
    Call<User> getDetailUser(@Path("username") String username);
}
