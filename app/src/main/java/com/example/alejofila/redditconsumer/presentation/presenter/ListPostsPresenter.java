package com.example.alejofila.redditconsumer.presentation.presenter;



import com.example.alejofila.redditconsumer.data.local.DatabaseWrapper;
import com.example.alejofila.redditconsumer.data.local.RealmDatabaseProvider;
import com.example.alejofila.redditconsumer.data.network.RedditService;
import com.example.alejofila.redditconsumer.domain.model.Child;
import com.example.alejofila.redditconsumer.domain.model.Data;
import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.domain.model.RootResponse;
import com.example.alejofila.redditconsumer.presentation.view.contract.ListPostsView;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Scheduler;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by alejofila on 28/01/17.
 */

/**
 * One important thing to notice in this class is that it doesn't have any import to
 * the android framework at all making possible pure JUnit testing
 */

public class ListPostsPresenter extends BasePresenter{

    private ListPostsView view;
    private DatabaseWrapper<PostDetail> databaseWrapper;
    //private boolean fromScratch;


    public ListPostsPresenter(boolean fromScratch, DatabaseWrapper<PostDetail> databaseWrapper ,ListPostsView view, Scheduler mainThreadScheduler){
        super(mainThreadScheduler);
        //this.fromScratch = fromScratch;
        this.view = view;
        this.databaseWrapper = databaseWrapper;
    }

    public void loadPosts() {
            Subscription subscription = RedditService.INSTANCE.getPostsResponse()
                    .subscribeOn(Schedulers.io())
                    .map(RootResponse::getData)
                    .flatMapIterable(Data::getChildren, 5)
                    .map(Child::getData)
                    .distinct()
                    .observeOn(mainThreadScheduler)
                    .doOnNext(postDetail -> databaseWrapper.save(postDetail))
                    .subscribe(postDetail -> {
                            },
                            error -> {

                                if (error instanceof UnknownHostException || error instanceof SocketTimeoutException) {
                                    view.showPosts(databaseWrapper.queryAll(PostDetail.class));

                                } else {
                                    view.showError();
                                }
                            },
                            () -> view.showPosts(databaseWrapper.queryAll(PostDetail.class)));
            subscriptionList.add(subscription);

    }

    @Override
    public void onStop() {
        super.onStop();

        databaseWrapper.close();
    }
}
