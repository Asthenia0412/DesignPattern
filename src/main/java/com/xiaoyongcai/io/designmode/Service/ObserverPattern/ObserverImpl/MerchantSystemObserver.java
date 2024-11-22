package com.xiaoyongcai.io.designmode.Service.ObserverPattern.ObserverImpl;

import com.xiaoyongcai.io.designmode.Service.ObserverPattern.StoreStatusObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MerchantSystemObserver implements StoreStatusObserver {
    @Override
    public void update(String storeStatus) {
        log.info("商户系统收到商户状态变更通知：商户状态更新为"+storeStatus);
        //这里进行商户系统的处理：比如更新数据库
    }
}
