package com.example.alejofila.redditconsumer.data.local;

import com.example.alejofila.redditconsumer.domain.model.PostDetail;

import java.util.List;

import rx.Observable;


/**
 * Created by alejofila on 27/01/17.
 */

public interface  DatabaseWrapper<T> {

    List<T> queryAll(Class<T> tClass);
    Observable<T> queryAllAsObservable(Class<T> tClass);
    void save(T object);

    void close();
}
