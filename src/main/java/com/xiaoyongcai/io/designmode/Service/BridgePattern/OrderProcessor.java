package com.xiaoyongcai.io.designmode.Service.BridgePattern;

import com.xiaoyongcai.io.designmode.Service.Strategy.PaymentStrategy;

public interface OrderProcessor {
    void processOrder(double amount);
    void setPaymentStrategy(PaymentStrategy paymentStrategy);
}
