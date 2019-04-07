package com.example.devfest;

import android.app.Activity;
import android.app.Application;

import com.example.devfest.DataLayer.Managers.PresenterManager;
import com.example.devfest.PresentationLayer.Presenters.BasePresenter;
import com.example.devfest.PresentationLayer.Presenters.MainPresenter;

public class App extends Application {
    private PresenterManager<Integer, BasePresenter> presenterManager;

    @Override
    public void onCreate() {
        super.onCreate();
        presenterManager = new PresenterManager<>();
        MainPresenter presenter = new MainPresenter();
        presenterManager.add(0, presenter);
    }

    public static App get(Activity activity){
        return (App) activity.getApplication();
    }

    public PresenterManager getPresenterManager(){
        return presenterManager;
    }
}
