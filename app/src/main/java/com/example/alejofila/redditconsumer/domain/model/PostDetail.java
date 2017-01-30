
package com.example.alejofila.redditconsumer.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/**
 * Main model class, it has a lot of fields (because of the API)
 * but in this sample I use just a few of them
 * Extracted the POJO from with this tool http://www.jsonschema2pojo.org/
 *
 */
public class PostDetail extends RealmObject implements Parcelable {

    @SerializedName("banner_img")
    @Expose
    private String bannerImg;
    @SerializedName("user_sr_theme_enabled")
    @Expose
    private Boolean userSrThemeEnabled;
    @SerializedName("submit_text_html")
    @Expose
    private String submitTextHtml;
    @SerializedName("wiki_enabled")
    @Expose
    private Boolean wikiEnabled;
    @SerializedName("show_media")
    @Expose
    private Boolean showMedia;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("submit_text")
    @Expose
    private String submitText;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("header_img")
    @Expose
    private String headerImg;
    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("collapse_deleted_comments")
    @Expose
    private Boolean collapseDeletedComments;
    @SerializedName("over18")
    @Expose
    private Boolean over18;
    @SerializedName("public_description_html")
    @Expose
    private String publicDescriptionHtml;
    @SerializedName("spoilers_enabled")
    @Expose
    private Boolean spoilersEnabled;

    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("header_title")
    @Expose
    private String headerTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("public_traffic")
    @Expose
    private Boolean publicTraffic;

    @SerializedName("subscribers")
    @Expose
    private Integer subscribers;
    @SerializedName("submit_text_label")
    @Expose
    private String submitTextLabel;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("key_color")
    @Expose
    private String keyColor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("quarantine")
    @Expose
    private Boolean quarantine;
    @SerializedName("hide_ads")
    @Expose
    private Boolean hideAds;
    @SerializedName("created_utc")
    @Expose
    private Integer createdUtc;
    @SerializedName("public_description")
    @Expose
    private String publicDescription;
    @SerializedName("show_media_preview")
    @Expose
    private Boolean showMediaPreview;
    @SerializedName("comment_score_hide_mins")
    @Expose
    private Integer commentScoreHideMins;
    @SerializedName("subreddit_type")
    @Expose
    private String subredditType;
    @SerializedName("submission_type")
    @Expose
    private String submissionType;

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public Boolean getUserSrThemeEnabled() {
        return userSrThemeEnabled;
    }

    public void setUserSrThemeEnabled(Boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
    }

    public String getSubmitTextHtml() {
        return submitTextHtml;
    }

    public void setSubmitTextHtml(String submitTextHtml) {
        this.submitTextHtml = submitTextHtml;
    }




    public Boolean getWikiEnabled() {
        return wikiEnabled;
    }

    public void setWikiEnabled(Boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    public Boolean getShowMedia() {
        return showMedia;
    }

    public void setShowMedia(Boolean showMedia) {
        this.showMedia = showMedia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCollapseDeletedComments() {
        return collapseDeletedComments;
    }

    public void setCollapseDeletedComments(Boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public String getPublicDescriptionHtml() {
        return publicDescriptionHtml;
    }

    public void setPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
    }

    public Boolean getSpoilersEnabled() {
        return spoilersEnabled;
    }

    public void setSpoilersEnabled(Boolean spoilersEnabled) {
        this.spoilersEnabled = spoilersEnabled;
    }


    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }






    public Boolean getPublicTraffic() {
        return publicTraffic;
    }

    public void setPublicTraffic(Boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
    }



    public Integer getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }

    public String getSubmitTextLabel() {
        return submitTextLabel;
    }

    public void setSubmitTextLabel(String submitTextLabel) {
        this.submitTextLabel = submitTextLabel;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Boolean getHideAds() {
        return hideAds;
    }

    public void setHideAds(Boolean hideAds) {
        this.hideAds = hideAds;
    }

    public Integer getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(Integer createdUtc) {
        this.createdUtc = createdUtc;
    }




    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public Boolean getShowMediaPreview() {
        return showMediaPreview;
    }

    public void setShowMediaPreview(Boolean showMediaPreview) {
        this.showMediaPreview = showMediaPreview;
    }

    public Integer getCommentScoreHideMins() {
        return commentScoreHideMins;
    }

    public void setCommentScoreHideMins(Integer commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bannerImg);
        dest.writeValue(this.userSrThemeEnabled);
        dest.writeString(this.submitTextHtml);
        dest.writeValue(this.wikiEnabled);
        dest.writeValue(this.showMedia);
        dest.writeString(this.id);
        dest.writeString(this.submitText);
        dest.writeString(this.displayName);
        dest.writeString(this.headerImg);
        dest.writeString(this.descriptionHtml);
        dest.writeString(this.title);
        dest.writeValue(this.collapseDeletedComments);
        dest.writeValue(this.over18);
        dest.writeString(this.publicDescriptionHtml);
        dest.writeValue(this.spoilersEnabled);
        dest.writeString(this.iconImg);
        dest.writeString(this.headerTitle);
        dest.writeString(this.description);
        dest.writeValue(this.publicTraffic);
        dest.writeValue(this.subscribers);
        dest.writeString(this.submitTextLabel);
        dest.writeString(this.lang);
        dest.writeString(this.keyColor);
        dest.writeString(this.name);
        dest.writeValue(this.created);
        dest.writeString(this.url);
        dest.writeValue(this.quarantine);
        dest.writeValue(this.hideAds);
        dest.writeValue(this.createdUtc);
        dest.writeString(this.publicDescription);
        dest.writeValue(this.showMediaPreview);
        dest.writeValue(this.commentScoreHideMins);
        dest.writeString(this.subredditType);
        dest.writeString(this.submissionType);
    }

    public PostDetail() {
    }

    protected PostDetail(Parcel in) {
        this.bannerImg = in.readString();
        this.userSrThemeEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.submitTextHtml = in.readString();
        this.wikiEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.showMedia = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.id = in.readString();
        this.submitText = in.readString();
        this.displayName = in.readString();
        this.headerImg = in.readString();
        this.descriptionHtml = in.readString();
        this.title = in.readString();
        this.collapseDeletedComments = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.over18 = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.publicDescriptionHtml = in.readString();
        this.spoilersEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.iconImg = in.readString();
        this.headerTitle = in.readString();
        this.description = in.readString();
        this.publicTraffic = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.subscribers = (Integer) in.readValue(Integer.class.getClassLoader());
        this.submitTextLabel = in.readString();
        this.lang = in.readString();
        this.keyColor = in.readString();
        this.name = in.readString();
        this.created = (Integer) in.readValue(Integer.class.getClassLoader());
        this.url = in.readString();
        this.quarantine = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.hideAds = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.createdUtc = (Integer) in.readValue(Integer.class.getClassLoader());
        this.publicDescription = in.readString();
        this.showMediaPreview = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.commentScoreHideMins = (Integer) in.readValue(Integer.class.getClassLoader());
        this.subredditType = in.readString();
        this.submissionType = in.readString();
    }

    public static final Parcelable.Creator<PostDetail> CREATOR = new Parcelable.Creator<PostDetail>() {
        @Override
        public PostDetail createFromParcel(Parcel source) {
            return new PostDetail(source);
        }

        @Override
        public PostDetail[] newArray(int size) {
            return new PostDetail[size];
        }
    };
}
