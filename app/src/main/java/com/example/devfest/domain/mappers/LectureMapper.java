package com.example.devfest.domain.mappers;

import com.example.devfest.domain.model.Lecture;
import com.example.devfest.domain.response.LectureResponse;

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
