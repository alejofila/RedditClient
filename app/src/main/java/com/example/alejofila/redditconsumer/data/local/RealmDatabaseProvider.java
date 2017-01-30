package com.example.alejofila.redditconsumer.data.local;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import rx.Observable;

/**
 * Created by alejofila on 27/01/17.
 */

public class RealmDatabaseProvider<T extends RealmModel> implements DatabaseWrapper<T> {

    private Realm realm ;

    public RealmDatabaseProvider(){
        realm = Realm.getDefaultInstance();
    }


    @Override
    public List<T> queryAll(Class<T> tClass) {

        return realm.copyFromRealm(realm.where(tClass).findAll());
    }

    @Override
    public Observable<T> queryAllAsObservable(Class<T> tClass) {
        return Observable.from(realm.copyFromRealm(realm.where(tClass).findAll()));


    }


    @Override
    public void save(T object) {
        try {
            realm.beginTransaction();
            realm.copyToRealm(object);
        }catch (Exception ignore){

        }
        finally {
            realm.commitTransaction();
        }
    }

    @Override
    public void close() {
        if(!realm.isClosed())
            realm.close();

    }
}
