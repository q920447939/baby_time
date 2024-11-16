package com.musk.web.handle.completeFuture;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.map.MapUtil;
import com.musk.web.handle.future.function.Procedure;
import com.musk.web.handle.thread.ThreadPoolInitContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;


@Component
public class CompleteFutureHandle {
    private final static Logger LOGGER = LoggerFactory.getLogger(CompleteFutureHandle.class);

    @SuppressWarnings("all")
    public static Map<String, Object> execute(Map<String, Supplier> tasks) {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        Map<String, Object> resultMap = new ConcurrentHashMap<>(256);
        CompletableFuture.allOf(tasks.keySet().stream().map((key) -> CompletableFuture.supplyAsync(
                () -> {
                    Supplier supplier = tasks.get(key);
                    Object o = supplier.get();
                    if (null != o) {
                        resultMap.put(key, o);
                    }
                    return o;
                }, ThreadPoolInitContext.getScheduleThreadPool())).toArray(CompletableFuture[]::new)).join();
        LOGGER.info("【CompleteFutureHandle】执行结束 ，耗时={} ", timeInterval.interval());
        return resultMap;
    }

    @SuppressWarnings("all")
    public static void executeNoResult(List<Procedure> tasks) {
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        CompletableFuture.allOf(tasks.stream()
                .map(task -> CompletableFuture.supplyAsync(() -> {
                    task.run();
                    return task;
                }, ThreadPoolInitContext.getScheduleThreadPool()))
                .toArray(CompletableFuture[]::new))
                .join();
        LOGGER.info("【CompleteFutureHandle无返回值】执行结束 ，耗时={}ms", timeInterval.interval());
        return;
    }


    public static <K, T> Map<K, T> executeV2(Map<K, Supplier<T>> tasks) {
        Collection<Supplier<T>> suppliers = tasks.values();
        if (CollUtil.isEmpty(suppliers)) {
            return MapUtil.empty();
        }
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.start();
        Map<K, T> resultMap = new ConcurrentHashMap<>(suppliers.size());
        for (K key : tasks.keySet()) {
            CompletableFuture<T> future = CompletableFuture.supplyAsync(
                    () ->{
                        Supplier<T> supplier = tasks.get(key);
                        return supplier.get();
                    } , ThreadPoolInitContext.getScheduleThreadPool());
            try {
                T value = future.get();
                if (key == null || value == null) {
                    LOGGER.warn("【CompleteFutureHandle】获取到的key或者value为空 ，key={} ", key);
                    continue;
                }
                resultMap.put(key, value);
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error("【CompleteFutureHandle executeV2】执行异常 ，key={} ", key, e);
            }
        }
        LOGGER.info("【CompleteFutureHandle executeV2】执行结束 ，耗时={} ", timeInterval.interval());
        return resultMap;
    }
}
