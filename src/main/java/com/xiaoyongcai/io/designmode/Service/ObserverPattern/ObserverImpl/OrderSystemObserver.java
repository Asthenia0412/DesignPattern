package com.xiaoyongcai.io.designmode.Service.ObserverPattern.ObserverImpl;

import com.xiaoyongcai.io.designmode.Service.ObserverPattern.StoreStatusObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderSystemObserver implements StoreStatusObserver {
    @Override
    public void update(String storeStatus) {
      log.info("订单系统收到商户状态变更通知：商户状态更新为"+storeStatus);
      if("打烊".equals(storeStatus)){
          log.info("商户暂停接单，停止订单处理");
      }else if("营业".equals(storeStatus)){
          log.info("商户开始接单，开始订单处理");
      }
    }
}
