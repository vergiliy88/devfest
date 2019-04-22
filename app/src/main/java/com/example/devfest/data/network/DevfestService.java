package com.example.devfest.data.network;



import com.example.devfest.domain.response.SpeakerResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DevfestService {

    @GET("getData.php")
    Call<List<SpeakerResponse>> getSpeakers();
}
