package com.course.app;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomThreadFactory implements ThreadFactory {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String THREAD_NAME_PREFIX = "MyPool-Worker-";
    private final AtomicInteger threadCreationCounter = new AtomicInteger();

    @Override
    public Thread newThread(Runnable taskRunnable) {
        int threadNumber = threadCreationCounter.incrementAndGet();
        Thread workerThread = new Thread(taskRunnable, THREAD_NAME_PREFIX + threadNumber);
        workerThread.setUncaughtExceptionHandler((thread, throwable) -> logger.error("Thread {} {}", thread.getName(), throwable));
        return workerThread;
    }
}
