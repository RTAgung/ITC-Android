package com.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
    private String title;
    private String tags;
    private String image;

    public Game(String title, String tags, String image) {
        this.title = title;
        this.tags = tags;
        this.image = image;
    }

    public Game() {
    }

    protected Game(Parcel in) {
        title = in.readString();
        tags = in.readString();
        image = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(tags);
        dest.writeString(image);
    }
}
