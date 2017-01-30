package com.example.alejofila.redditconsumer.data.network;

/**
 * Created by alejofila on 28/01/17.
 */


import com.example.alejofila.redditconsumer.BuildConfig;
import com.example.alejofila.redditconsumer.domain.model.RootResponse;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public enum RedditService {
    INSTANCE;


    private final ApiPost api;

    RedditService() {
        OkHttpClient okHttpClient =
                new OkHttpClient.Builder().build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(ApiPost.class);
    }

    public Observable<RootResponse> getPostsResponse(){

        return api.getPosts();
    }


}