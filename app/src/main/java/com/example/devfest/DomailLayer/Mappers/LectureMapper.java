package com.example.devfest.DomailLayer.Mappers;

import com.example.devfest.DomailLayer.Model.Lecture;
import com.example.devfest.DomailLayer.Response.LectureResponse;

public class LectureMapper implements Mapper<LectureResponse, Lecture> {
    @Override
    public Lecture transform(LectureResponse object) {
        Lecture lecture = new Lecture(
                object.getTheme(),
                object.getTime(),
                object.getContent()
        );
        return lecture;
    }
}
