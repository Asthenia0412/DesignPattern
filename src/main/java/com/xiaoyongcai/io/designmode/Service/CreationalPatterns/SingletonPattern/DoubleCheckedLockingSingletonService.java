package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

/**
 *双重检查锁：为何要在锁中进行第二次检查呢？
 * 因为第一次检查是为了避免不必要的同步，
 * 而第二次检查是确保在进入同步块之前，instance尚未被初始化完成，
 * 避免多线程同时进入同步块导致instance被重复初始化。
 *
 */
@Slf4j
public class DoubleCheckedLockingSingletonService {
    private volatile static DoubleCheckedLockingSingletonService instance;

    private DoubleCheckedLockingSingletonService() {}

    public static DoubleCheckedLockingSingletonService getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingletonService.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingletonService();
                }
            }
        }
        return instance;
    }

    public String processWorkflow() {
        // 处理工作流业务
        log.info("[单例模式-4]：双重检查锁单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-4]：双重检查锁单例模式运行成功，数据请回看api接口反馈";
    }
}
