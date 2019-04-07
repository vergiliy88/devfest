package com.example.devfest.DataLayer.Network;



import com.example.devfest.DomailLayer.Response.SpeakerResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DevfestService {
    @GET("getData.php")
    Observable<List<SpeakerResponse>> getData();
}
