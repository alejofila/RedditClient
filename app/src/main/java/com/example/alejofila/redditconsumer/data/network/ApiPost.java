package com.example.alejofila.redditconsumer.data.network;

import com.example.alejofila.redditconsumer.domain.model.RootResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by alejofila on 28/01/17.
 */

public interface ApiPost {
    @GET("reddits.json")
    Observable<RootResponse> getPosts();
}
