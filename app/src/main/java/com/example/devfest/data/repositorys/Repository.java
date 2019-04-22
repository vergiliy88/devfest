package com.example.devfest.data.repositorys;

import com.example.devfest.domain.response.SpeakerResponse;
import java.util.List;

public interface Repository {
    void loadSpeakers(retrofit2.Callback<List<SpeakerResponse>> callback);
}
