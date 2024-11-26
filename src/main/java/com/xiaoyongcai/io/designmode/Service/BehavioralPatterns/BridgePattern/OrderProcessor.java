package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.BridgePattern;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.Strategy.PaymentStrategy;

public interface OrderProcessor {
    void processOrder(double amount);
    void setPaymentStrategy(PaymentStrategy paymentStrategy);
}
