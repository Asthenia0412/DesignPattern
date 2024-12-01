package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumSingletonService {
    INSTANCE;

    public String processWorkflow() {
        // 处理工作流业务
        log.info("[单例模式-6]：枚举单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-6]：枚举单例模式运行成功，数据请回看api接口反馈";
    }
}
