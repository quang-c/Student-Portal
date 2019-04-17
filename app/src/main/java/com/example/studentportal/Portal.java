package com.example.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class Portal implements Parcelable {

    private String title;
    private String url;

    Portal(String title, String url) {
        this.title = title;
        this.url = url;
    }

    String getTitle() {
        return title;
    }

    String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.url);
    }

    protected Portal(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Portal> CREATOR = new Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };
}
