package com.example.devfest;



import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("getData.php")
    Observable<List<Speaker>> getData();
}
