package com.example.alejofila.redditconsumer.presentation.presenter;

import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.presentation.view.contract.DetailPostView;

import rx.Scheduler;

/**
 * Created by alejofila on 29/01/17.
 */


/**
 * I didn't use this presenter in the sample demo because it was an overkill, and is easier to
 * understand
 */
public class DetailPostPresenter extends BasePresenter{

    private DetailPostView view;
    private PostDetail postDetail;
    public DetailPostPresenter(DetailPostView view, PostDetail postDetail ,Scheduler mainThreadScheduler) {
        super(mainThreadScheduler);
        this.postDetail = postDetail;
        this.view = view;
    }
    public void showPostDetail(){
        view.showPost(postDetail);

    }

}
