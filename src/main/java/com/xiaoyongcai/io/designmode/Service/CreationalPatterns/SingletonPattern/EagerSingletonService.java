package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerSingletonService {
    private static final EagerSingletonService eagerSingletonService = new EagerSingletonService();

    private EagerSingletonService() {
    }

    public static EagerSingletonService getInstance() {
        return eagerSingletonService;
    }

    public String processWorkflow(){
        log.info("[单例模式-2]：饿汉式单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-2]：饿汉式单例模式运行成功，数据请回看api接口反馈";
    }

}
