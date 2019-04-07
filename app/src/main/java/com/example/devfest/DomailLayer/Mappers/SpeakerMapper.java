package com.example.devfest.DomailLayer.Mappers;

import com.example.devfest.DomailLayer.Model.Speaker;
import com.example.devfest.DomailLayer.Response.SpeakerResponse;

import java.util.ArrayList;
import java.util.List;

public class SpeakerMapper implements Mapper<SpeakerResponse, Speaker> {
    @Override
    public Speaker transform(SpeakerResponse object) {
        Speaker speaker = new Speaker(
                object.getSpeakerName(),
                object.getPosition(),
                object.getLocation(),
                object.getPathToPhoto(),
                object.getInfo(),
                new LectureMapper().transform(object.getLecture())
        );
        return speaker;
    }

    public List<Speaker> transform(List<SpeakerResponse> objects){
        List<Speaker> speakerList = new ArrayList<>();
        for (SpeakerResponse response : objects){
            speakerList.add(transform(response));
        }
        return speakerList;
    }
}
