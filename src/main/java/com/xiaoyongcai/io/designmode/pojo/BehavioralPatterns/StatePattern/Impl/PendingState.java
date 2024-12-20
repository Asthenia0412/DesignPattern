package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.Impl;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.OrderContext;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.OrderState;

public class PendingState implements OrderState {
    @Override
    public void handleRequest(OrderContext context) {
        System.out.println("[状态模式]：订单状态为：订单正在支付中");

        context.setState(new PaidState());
    }
}
