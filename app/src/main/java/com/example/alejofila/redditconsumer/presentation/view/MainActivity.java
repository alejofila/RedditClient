package com.example.alejofila.redditconsumer.presentation.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.alejofila.redditconsumer.R;
import com.example.alejofila.redditconsumer.data.local.RealmDatabaseProvider;
import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.presentation.presenter.ListPostsPresenter;
import com.example.alejofila.redditconsumer.presentation.view.adapter.PostsAdapter;
import com.example.alejofila.redditconsumer.presentation.view.contract.ListPostsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements ListPostsView {

    /**
     * Constants
     */
    public static final String KEY_POST_DETAIL ="post_detail";
    /**
     * UI
     */
    @BindView(R.id.post_lists)
    RecyclerView postsRecycler;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    /**
     * State
     */
    PostsAdapter adapter;

    ListPostsPresenter presenter;

    List<PostDetail> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        boolean fromScratch;
        if(savedInstanceState == null)
            fromScratch = true;
        else
            fromScratch = false;
        presenter = new ListPostsPresenter(fromScratch,new RealmDatabaseProvider<PostDetail>(),this, AndroidSchedulers.mainThread());
        presenter.loadPosts();
        adapter = new PostsAdapter(position -> {
            goToDetail(posts.get(position));
        });
        postsRecycler.setLayoutManager(new LinearLayoutManager(this));
        postsRecycler.setAdapter(adapter);
    }


    // View contract  methods
    @Override
    public void showPosts(List<PostDetail> posts) {
        hideLoadingIndicator();
        this.posts = posts;
        adapter.addPost(posts);
    }

    @Override
    public void showLoadingIndicator() {

        progressBar.setVisibility(View.VISIBLE);
        postsRecycler.setVisibility(View.GONE);


    }

    @Override
    public void hideLoadingIndicator() {

        progressBar.setVisibility(View.GONE);
        postsRecycler.setVisibility(View.VISIBLE);


    }

    @Override
    public void showError() {
        progressBar.setVisibility(View.GONE);
        postsRecycler.setVisibility(View.GONE);
        Toast.makeText(this, R.string.error_no_posts,Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void goToDetail(PostDetail postDetail) {
        Intent nextActivity = new Intent(this, PostDetailActivity.class);
        nextActivity.putExtra(KEY_POST_DETAIL,postDetail);
        startActivity(nextActivity);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();

    }
}
