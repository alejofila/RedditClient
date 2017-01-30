package com.example.alejofila.redditconsumer.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alejofila.redditconsumer.R;
import com.example.alejofila.redditconsumer.domain.model.PostDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alejofila on 27/01/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostDetail> postLists;
    private OnPostClicked postClicked;
    public PostsAdapter(List<PostDetail> postLists, OnPostClicked postClicked){
        this.postLists = postLists;
        this.postClicked = postClicked;

    }
    public PostsAdapter(OnPostClicked postClicked){
        this(new ArrayList<>(),postClicked);

    }
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view,postClicked);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(postLists.get(position).getTitle());
        holder.description.setText(postLists.get(position).getDescription());
        holder.subscribers
                .setText(String.format(holder.itemView.getContext().getString(R.string.subscribers),
                        postLists.get(position).getSubscribers()));
    }

    @Override
    public int getItemCount() {
        return postLists.size();
    }


     static class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

         @BindView(R.id.post_title) TextView title;
         @BindView(R.id.post_description) TextView description;
         @BindView(R.id.post_subscribers) TextView subscribers;
         @BindView(R.id.item_container) View container;
         OnPostClicked onPostClicked;


         PostViewHolder(View itemView,OnPostClicked onPostClicked) {
             super(itemView);
             ButterKnife.bind(this,itemView);
             this.onPostClicked = onPostClicked;
             container.setOnClickListener(this);
        }

         @Override
         public void onClick(View view) {
             onPostClicked.onPostClicked(getAdapterPosition());

         }
     }
    public void addPost(PostDetail postDetail){
        postLists.add(postDetail);
        notifyDataSetChanged();
    }
    public void addPost(List<PostDetail> postDetails){
        postLists.addAll(postDetails);
        notifyDataSetChanged();
    }


    public interface OnPostClicked{
         void onPostClicked(int position);
    }
}
