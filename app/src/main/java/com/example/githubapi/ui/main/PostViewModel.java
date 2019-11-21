package com.example.githubapi.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.githubapi.data.PostsClient;
import com.example.githubapi.pojo.PostModel;
import com.example.githubapi.pojo.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();

    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                postsMutableLiveData.setValue(response.body().getItems());

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                posts.setValue("errr");
            }
        });





    }
}
