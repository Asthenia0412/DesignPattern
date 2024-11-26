package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.MediatorPattern.MediatorOrder;

public interface OrderMediator {
    void processOrder(MediatorOrder order);
}
