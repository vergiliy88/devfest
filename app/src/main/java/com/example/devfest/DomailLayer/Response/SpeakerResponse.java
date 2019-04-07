package com.example.devfest.DomailLayer.Response;

import com.google.gson.annotations.SerializedName;

public class SpeakerResponse {
    @SerializedName("speaker_name")
    private String speakerName;

    @SerializedName("position")
    private String position;

    @SerializedName("location")
    private String location;

    @SerializedName("path_to_photo")
    private String pathToPhoto;

    @SerializedName("info")
    private String info;

    @SerializedName("lecture_info")
    private LectureResponse lecture;

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LectureResponse getLecture() {
        return lecture;
    }

    public void setLecture(LectureResponse lecture) {
        this.lecture = lecture;
    }
}
