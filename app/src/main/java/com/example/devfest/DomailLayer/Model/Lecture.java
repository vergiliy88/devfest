package com.example.devfest.DomailLayer.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Lecture implements Parcelable {
    private String theme;

    private String time;

    private String content;

    public Lecture(String theme, String time, String content) {
        this.theme = theme;
        this.time = time;
        this.content = content;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(theme);
        dest.writeString(time);
        dest.writeString(content);
    }

    private Lecture(Parcel parcel){

        theme = parcel.readString();
        time = parcel.readString();
        content = parcel.readString();
    }

    public static final Creator<Lecture> CREATOR = new Creator<Lecture>() {
        @Override
        public Lecture createFromParcel(Parcel in) {
            return new Lecture(in);
        }

        @Override
        public Lecture[] newArray(int size) {
            return new Lecture[size];
        }
    };
}
