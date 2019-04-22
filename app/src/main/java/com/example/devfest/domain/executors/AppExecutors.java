package com.example.devfest.domain.executors;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AppExecutors {

    private final Executor networkIO = new ThreadExecutor(
            0, 5,
            1, TimeUnit.MINUTES, new LinkedBlockingQueue());

    public Executor networkIO() {
        return networkIO;
    }
}
