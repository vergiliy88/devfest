package com.example.devfest.DataLayer.Network;

import android.support.annotation.NonNull;

public class ApiFactory {
    @NonNull
    public static DevfestService getDevfestService() {
        return Client.getRetrofit().create(DevfestService.class);
    }
}
