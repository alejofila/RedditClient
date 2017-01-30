
package com.example.alejofila.redditconsumer.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Child  {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private PostDetail data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public PostDetail getData() {
        return data;
    }

    public void setData(PostDetail data) {
        this.data = data;
    }

}
