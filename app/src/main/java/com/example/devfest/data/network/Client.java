package com.example.devfest.data.network;

import com.example.devfest.Config;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private volatile static Retrofit retrofit = null;

    // lazy singleton with Double Checked Locking
    public static Retrofit getRetrofit() {
        Retrofit localInstance = retrofit;
        if (localInstance == null) {
            synchronized (Client.class) {
                localInstance = retrofit;
                if (localInstance == null)
                    retrofit = localInstance = new Retrofit.Builder()
                            .baseUrl(Config.SERVER_ADDRESS)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
            }
        }
        return localInstance;
    }
}
