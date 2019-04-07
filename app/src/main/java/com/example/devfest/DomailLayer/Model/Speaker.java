package com.example.devfest.DomailLayer.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Speaker implements Parcelable {
    private String speakerName;

    private String position;

    private String location;

    private String pathToPhoto;

    private String info;

    private Lecture lecture;

    public Speaker(String speakerName, String position, String location, String pathToPhoto, String info, Lecture lecture) {
        this.speakerName = speakerName;
        this.position = position;
        this.location = location;
        this.pathToPhoto = pathToPhoto;
        this.info = info;
        this.lecture = lecture;
    }

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

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(speakerName);
        dest.writeString(position);
        dest.writeString(location);
        dest.writeString(pathToPhoto);
        dest.writeString(info);
        dest.writeParcelable(lecture, flags);
    }

    private Speaker(Parcel in) {
        speakerName = in.readString();
        position = in.readString();
        location = in.readString();
        pathToPhoto = in.readString();
        info = in.readString();
        lecture = in.readParcelable(Lecture.class.getClassLoader());
    }

    public static final Creator<Speaker> CREATOR = new Creator<Speaker>() {
        @Override
        public Speaker createFromParcel(Parcel in) {
            return new Speaker(in);
        }

        @Override
        public Speaker[] newArray(int size) {
            return new Speaker[size];
        }
    };

}
