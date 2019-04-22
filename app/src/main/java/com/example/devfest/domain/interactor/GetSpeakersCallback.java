package com.example.devfest.domain.interactor;

import com.example.devfest.domain.model.Speaker;

import java.util.List;

public interface GetSpeakersCallback {
    void onFetchSpeakersSuccess(List<Speaker> speakers);

    void onFetchSpeakersError();
}
