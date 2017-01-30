package com.example.alejofila.redditconsumer.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejofila.redditconsumer.R;
import com.example.alejofila.redditconsumer.domain.model.PostDetail;
import com.example.alejofila.redditconsumer.presentation.view.contract.DetailPostView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alejofila on 29/01/17.
 */

public class PostDetailActivity extends AppCompatActivity implements DetailPostView{

    /**
     * UI
     */
    @BindView(R.id.detail_post_image)
    ImageView postImage;
    @BindView(R.id.detail_post_description)
    TextView postDescription;
    @BindView(R.id.detail_post_subs)
    TextView postSubscribers;
    @BindView(R.id.detail_post_title)
    TextView postTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);
        //presenter = new DetailPostPresenter(this,AndroidSchedulers.mainThread());
        showPost(getIntent().getParcelableExtra(MainActivity.KEY_POST_DETAIL));

    }

    @Override
    public void showPost(PostDetail postDetail) {

        postDescription.setText(postDetail.getDescription());
        postSubscribers
                .setText(String.format(getString(R.string.subscribers),
                        postDetail.getSubscribers()));
        postTitle.setText(postDetail.getTitle());

        Picasso.with(this)
                .load(postDetail.getHeaderImg())
                .placeholder(R.drawable.placeholder_not_found)
                .error(R.drawable.placeholder_not_found)
                .into(postImage);

    }
}
