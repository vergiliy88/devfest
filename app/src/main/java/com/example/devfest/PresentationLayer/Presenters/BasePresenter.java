package com.example.devfest.PresentationLayer.Presenters;

import com.example.devfest.PresentationLayer.View.MvpView;

import java.lang.ref.WeakReference;

import io.reactivex.annotations.NonNull;

public abstract class BasePresenter<V extends MvpView> {
    protected WeakReference<V> view;

    public void bindView(@NonNull V view) {
        this.view = new WeakReference<>(view);
    }

    public void unbindView() {
        this.view = null;
    }

    protected V view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    protected abstract void updateView();
}
