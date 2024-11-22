package com.xiaoyongcai.io.designmode.Service.ObserverPattern.ObserverImpl;

import com.xiaoyongcai.io.designmode.Service.ObserverPattern.StoreStatusObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataStatisticsObserver implements StoreStatusObserver {
    @Override
    public void update(String storeStatus) {
        log.info("数据统计系统收到商户状态变更:商户状态更新为"+storeStatus);
        //执行数据统计的代码，为某状态的统计参数增加一个当前的storestatus
    }
}
