package com.example.devfest.presentation.presenters;

import com.example.devfest.domain.executors.AppExecutors;
import com.example.devfest.domain.executors.MainThreadImpl;
import com.example.devfest.domain.interactor.GetSpeakers;
import com.example.devfest.domain.interactor.GetSpeakersCallback;
import com.example.devfest.domain.model.Speaker;
import com.example.devfest.presentation.view.MainMvpView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainMvpView> implements GetSpeakersCallback {

    private GetSpeakers getSpeakersUseCase;
    private Runnable mRunnable;

    public MainPresenter(){
        getSpeakersUseCase = new GetSpeakers(new AppExecutors().networkIO(), new MainThreadImpl(), this);
    }

    public void onCreate() {
        getSpeakersUseCase.execute();
    }

    @Override
    public void updateView() {
        if (mRunnable != null && view() != null)
            mRunnable.run();
        mRunnable = null;
    }

    @Override
    public void onFetchSpeakersSuccess(List<Speaker> speakers) {
        if (view() != null)
            view().showData(speakers);
        else
            mRunnable = () -> view().showData(speakers);
    }

    @Override
    public void onFetchSpeakersError() {

    }
}
