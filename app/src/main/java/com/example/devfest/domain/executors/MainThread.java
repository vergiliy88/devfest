package com.example.devfest.domain.executors;

public interface MainThread {
    void post(final Runnable runnable);
}
