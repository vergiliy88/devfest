package com.example.devfest.domain.executors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor implements Executor {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    public ThreadExecutor(int corePoolSize, int maximumPoolSize, int keepAliveTime, TimeUnit unit, BlockingQueue workQueue) {
        mThreadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void run(Interactor interactor) {
        if (interactor == null) {
            throw new IllegalArgumentException("Interactor to execute can't be null");
        }
        mThreadPoolExecutor.submit(() -> interactor.run());
    }
}
