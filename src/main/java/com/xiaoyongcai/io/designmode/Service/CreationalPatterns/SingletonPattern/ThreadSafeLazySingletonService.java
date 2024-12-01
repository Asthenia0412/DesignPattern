package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadSafeLazySingletonService {

    private static ThreadSafeLazySingletonService instance;

    private ThreadSafeLazySingletonService() {}

    public static synchronized ThreadSafeLazySingletonService getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazySingletonService();
        }
        return instance;
    }

    public String processWorkflow() {
        // 处理工作流业务
        log.info("[单例模式-3]：线程安全的懒汉单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-3]：线程安全的懒汉单例模式运行成功，数据请回看api接口反馈";
    }
}
