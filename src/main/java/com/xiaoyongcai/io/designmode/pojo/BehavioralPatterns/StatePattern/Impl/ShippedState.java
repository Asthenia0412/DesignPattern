package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.Impl;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.OrderContext;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.OrderState;

public class ShippedState implements OrderState {
    @Override
    public void handleRequest(OrderContext context) {
        System.out.println("[状态模式]：订单状态为：您下单的商品正在运输中,运输成功之后订单即可完成");
        context.setState(new CompletedState());
    }
}
