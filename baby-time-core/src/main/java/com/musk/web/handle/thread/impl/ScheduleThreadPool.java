/**
 * @Project:
 * @Author:
 * @Date: 2021年09月07日
 */
package com.musk.web.handle.thread.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.apache.logging.log4j.ThreadContext;
import org.example.musk.middleware.threads.ThreadPoolExecutorFactory;
import org.example.musk.middleware.tlog.WrapThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


public class ScheduleThreadPool extends WrapThreadPoolExecutor implements ThreadPoolExecutorFactory {
    private final static int CORE_POOL_SIZE = 10;
    private final static int MAXIMUM_POOL_SIZE = 20;
    private final static int KEEP_ALIVE_TIME = 120;
    private final static TimeUnit UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>(Integer.MAX_VALUE);
    private static final String THREAD_POOL_NAME_PRE = "musk_schedule_thread_pool_";
    private static final RejectedExecutionHandler HANDLER = new AbortPolicy();
    static ThreadFactory BASIC_THREAD_FACTORY = ThreadUtil.createThreadFactoryBuilder().setNamePrefix(THREAD_POOL_NAME_PRE).build();

    public ScheduleThreadPool() {
        super(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, UNIT, WORK_QUEUE, BASIC_THREAD_FACTORY, HANDLER);
    }

    public ScheduleThreadPool(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        //org.apache.log4j.MDC.clear();
        ThreadContext.clearAll();
        super.afterExecute(r, t);
    }

    @Override
    public ExecutorService getThreadPool() {
        return TtlExecutors.getTtlExecutorService(this);
    }
}
