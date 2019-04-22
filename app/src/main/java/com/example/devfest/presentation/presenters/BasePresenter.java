package com.example.devfest.presentation.presenters;

import com.example.devfest.presentation.view.MvpView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MvpView> {
    protected WeakReference<V> view;

    public void bindView(V view) {
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

    public abstract void updateView();
}
