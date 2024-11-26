package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ObserverPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreStatusSubject storeStatusSubject;

    @Autowired
    public StoreService(StoreStatusSubject storeStatusSubject) {
        this.storeStatusSubject = storeStatusSubject;
    }
    //更新商户状态并且通知所有观察者
    public void updateStoreStatus(String storeStatus){
        storeStatusSubject.setStoreStatus(storeStatus);
    }
}
