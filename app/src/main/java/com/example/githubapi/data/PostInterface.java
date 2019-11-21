package com.example.githubapi.data;

import com.example.githubapi.pojo.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("search/users?q=language:java")
    public Call<Result> getPosts();
}
