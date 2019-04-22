package com.example.devfest.data.repositorys;

import com.example.devfest.data.network.ApiFactory;
import com.example.devfest.domain.response.SpeakerResponse;
import java.util.List;

public class DevfestRepository implements Repository {

    private DevfestRepository(){ }

    public static DevfestRepository getInstance(){
        return new DevfestRepository();
    }

    @Override
    public void loadSpeakers(retrofit2.Callback<List<SpeakerResponse>> callback) {
        ApiFactory.getDevfestService().getSpeakers().enqueue(callback);
    }

}
