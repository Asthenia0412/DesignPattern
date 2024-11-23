package com.xiaoyongcai.io.designmode.pojo.StatePattern.Impl;

import com.xiaoyongcai.io.designmode.pojo.StatePattern.OrderContext;
import com.xiaoyongcai.io.designmode.pojo.StatePattern.OrderState;

public class CompletedState implements OrderState {
    @Override
    public void handleRequest(OrderContext context) {
        System.out.println("[状态模式]：订单状态为：订单已经完成");
    }
}
