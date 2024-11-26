package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.BridgePattern.Impl;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.BridgePattern.OrderProcessor;
import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.Strategy.PaymentStrategy;
import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
public class OnlineOrderProcessor implements OrderProcessor {
    private  PaymentStrategy paymentStrategy;


    @Override
    public void processOrder(double amount) {
        System.out.println("尽管你正在使用某种特定的支付方式,但是此时要注意：你是通过线上访问桥接到该支付请求的哦");
        paymentStrategy.pay(amount);
    }

    @Override
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}


