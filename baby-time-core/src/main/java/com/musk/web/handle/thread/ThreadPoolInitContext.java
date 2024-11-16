package com.musk.web.handle.thread;

import com.musk.web.handle.thread.impl.ScheduleThreadPool;
import org.example.musk.middleware.threads.ThreadPoolExecutorFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;


@Component
public class ThreadPoolInitContext {


    private static final ThreadPoolExecutorFactory SCHEDULE_EXECUTOR = new ScheduleThreadPool();


    public static ExecutorService getScheduleThreadPool() {
        return SCHEDULE_EXECUTOR.getThreadPool();
    }


}
