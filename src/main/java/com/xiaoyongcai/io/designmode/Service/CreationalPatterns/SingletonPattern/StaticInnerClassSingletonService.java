package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticInnerClassSingletonService {
    /*
    *  静态内部类单例利用了类加载机制保证了线程安全，同时实现了懒加载。
    *  原因是：静态代码块是共有且最先加载，且只加载一次的
    * */
    private StaticInnerClassSingletonService() {}

    private static class SingletonHolder {
        private static final StaticInnerClassSingletonService INSTANCE = new StaticInnerClassSingletonService();
    }

    public static StaticInnerClassSingletonService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String processWorkflow() {
        // 处理工作流业务
        log.info("[单例模式-5]：静态内部类单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-5]：静态内部类单例模式运行成功，数据请回看api接口反馈";
    }
}
