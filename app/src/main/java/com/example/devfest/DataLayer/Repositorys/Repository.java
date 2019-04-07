package com.example.devfest.DataLayer.Repositorys;

import com.example.devfest.DomailLayer.Model.Speaker;

import java.util.List;

import io.reactivex.Observable;


public interface Repository {
    Observable<List<Speaker>> getData();
}
