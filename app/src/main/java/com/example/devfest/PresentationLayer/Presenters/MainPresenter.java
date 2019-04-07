package com.example.devfest.PresentationLayer.Presenters;

import android.support.annotation.NonNull;

import com.example.devfest.DataLayer.Repositorys.DevfestRepository;
import com.example.devfest.PresentationLayer.View.MainMvpView;
import com.example.devfest.PresentationLayer.View.MvpView;

public class MainPresenter extends BasePresenter<MainMvpView>  {

    private DevfestRepository mRepository;

    public MainPresenter(){
        mRepository = DevfestRepository.getInstance();
    }

    public void onCreate() {
        mRepository.getData()
                .subscribe(items -> view().showData(items));
    }

    @Override
    protected void updateView() {
        // вернуть состояние view
    }
}
