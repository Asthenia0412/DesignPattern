package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazySingletonService {
    /**
     * 懒汉式单例模式：
     * 优点：延迟加载，节省资源
     * 缺点：线程不安全，多线程环境下可能会创建多个实例
     * 解决方案：使用synchronized关键字进行同步，保证线程安全
     * 缺点：每次获取实例都需要进行同步，效率较低
     * 解决方案：双重检查锁定（Double-Checked Locking）
     */
    private static LazySingletonService lazySingletonService;
    private LazySingletonService() {};
    public static synchronized LazySingletonService getInstance() {
        if(lazySingletonService == null) {
            lazySingletonService = new LazySingletonService();
        }
        return lazySingletonService;
    }

    public String processWorkflow(){
        log.info("[单例模式-1]：线程不安全的懒汉式单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-1]：线程不安全的懒汉式单例模式运行成功，数据请回看api接口反馈";
    }
}
