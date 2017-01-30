package com.example.alejofila.redditconsumer;

import com.example.alejofila.redditconsumer.data.local.DatabaseWrapper;
import com.example.alejofila.redditconsumer.domain.model.Child;
import com.example.alejofila.redditconsumer.domain.model.Data;
import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.domain.model.RootResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observable;

/**
 * Created by alejofila on 29/01/17.
 */

/**
 * A class that represent the database, it's just an in-memory fake
 */
public class FakePostDetailProvider implements DatabaseWrapper<PostDetail> {

    private List<PostDetail> postDetailList;
    public  FakePostDetailProvider(){
        postDetailList = new ArrayList<>();
        String jsonString = FileTestUtils.readFileFromAssets("post_detail_payload_sample.json");
        RootResponse rootResponse = new Gson().fromJson(jsonString, RootResponse.class);
        Observable.just(rootResponse)
                .map(RootResponse::getData)
                .flatMapIterable(Data::getChildren)
                .map(Child::getData)
                .subscribe(postDetail -> postDetailList.add(postDetail));
    }

    @Override
    public List<PostDetail> queryAll(Class<PostDetail> postDetailClass) {
        return postDetailList;
    }

    @Override
    public Observable<PostDetail> queryAllAsObservable(Class<PostDetail> postDetailClass) {
        return Observable.from(postDetailList);
    }

    @Override
    public void save(PostDetail object) {
        postDetailList.add(object);

    }

    @Override
    public void close() {
        // Do nothing on purpose

    }
}
