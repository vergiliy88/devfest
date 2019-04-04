package com.example.devfest;

import com.google.gson.annotations.SerializedName;

public class Lecture {

    @SerializedName("theme")
    private String theme;

    @SerializedName("time")
    private String time;

    @SerializedName("content")
    private String content;

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
}
