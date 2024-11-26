package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern;

public class OrderContext {
    private OrderState state;
    public OrderContext(OrderState state) {
        this.state = state;
    }
    public void setState(OrderState state) {
        this.state = state;
    }
    public void request(){
        state.handleRequest(this);
    }
}
