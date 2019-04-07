package com.example.devfest.DataLayer.Repositorys;

import com.example.devfest.DataLayer.Network.ApiFactory;
import com.example.devfest.DomailLayer.Mappers.SpeakerMapper;
import com.example.devfest.DomailLayer.Model.Speaker;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DevfestRepository implements Repository {

    private DevfestRepository(){ }

    public static DevfestRepository getInstance(){
        return new DevfestRepository();
    }

    @Override
    public Observable<List<Speaker>> getData() {
        return ApiFactory.getDevfestService()
                .getData()
                .map(item -> new SpeakerMapper().transform(item))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
