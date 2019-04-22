package com.example.devfest.presentation.view;

import com.example.devfest.domain.model.Speaker;

import java.util.List;

public interface MainMvpView extends MvpView {
    void showData(List<Speaker> speakerList);
}
