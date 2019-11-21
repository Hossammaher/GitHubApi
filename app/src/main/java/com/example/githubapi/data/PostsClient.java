package com.example.githubapi.data;


import com.example.githubapi.pojo.Result;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "https://api.github.com/";
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<Result> getPosts(){
        return postInterface.getPosts();
    }
}
