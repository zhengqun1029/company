package com.lantaiyuan.ebus.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadConfiguration {

    @Value("${threadPool.corePoolSize}")
    private int corePoolSize;
    @Value("${threadPool.maximumPoolSize}")
    private int maximumPoolSize;
    @Value("${threadPool.keepAliveTime}")
    private long keepAliveTime;
    @Value("${threadPool.workQueueDefaultSize}")
    private int workQueueDefaultSize;

    @Bean
    public ThreadPoolExecutor executor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        return executor;
    }




}
