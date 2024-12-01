package com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class SingletonRegistryService {


    private static final Map<String, Object> instances = new HashMap<>();

    private SingletonRegistryService() {}

    public static synchronized Object getInstance(String className) {

        if (!instances.containsKey(className)) {
            try {
                instances.put(className,new SingletonRegistryService());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instances.get(className);
    }

    public String processWorkflow() {
        // 处理工作流业务
        log.info( "[单例模式-7]：注册表单例模式运行成功，数据请回看api接口反馈");
        return "[单例模式-7]：注册表单例模式运行成功，数据请回看api接口反馈";
    }
}

