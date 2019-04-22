package com.example.devfest.domain.executors;

import android.os.Handler;
import android.os.Looper;

public class MainThreadImpl implements MainThread {

    private Handler mHandler;

    public MainThreadImpl() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
