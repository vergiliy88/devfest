package com.example.devfest.PresentationLayer.View;

import com.example.devfest.DomailLayer.Model.Speaker;

import java.util.List;

public interface MainMvpView extends MvpView {
    void showData(List<Speaker> speakerList);
}
