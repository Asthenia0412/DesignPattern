    package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.Strategy.Impl;

    import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.Strategy.PaymentStrategy;
    import org.springframework.stereotype.Service;

    @Service
    public class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("支付完成,消费"+amount+"元。支付方式为：信用卡");
        }
    }
