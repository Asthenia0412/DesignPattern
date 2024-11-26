package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern.ObserverImpl;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern.StoreStatusObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserNotificationObserver implements StoreStatusObserver {
    @Override
    public void update(String storeStatus) {
      log.info("用户通知系统收到商户状态变更通知:商户状态更新为"+storeStatus);
      //在此实现用户通知的处理，比如通过消息队列发送短信or通知
    }
}
