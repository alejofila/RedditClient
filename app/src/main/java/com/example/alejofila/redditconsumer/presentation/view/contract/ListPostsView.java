package com.example.alejofila.redditconsumer.presentation.view.contract;

/**
 * Created by alejofila on 28/01/17.
 */

import com.example.alejofila.redditconsumer.domain.model.PostDetail;

import java.util.List;

/**
 * View contract for used on the MainActivity where we show a list of posts
 */
public interface ListPostsView {

    void showPosts(List<PostDetail> posts);
    void showLoadingIndicator();
    void hideLoadingIndicator();
    void showError();
    void goToDetail(PostDetail postDetail);

}
