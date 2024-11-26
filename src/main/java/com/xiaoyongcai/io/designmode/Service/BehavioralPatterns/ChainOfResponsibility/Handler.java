package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ChainOfResponsibility;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.ChainOfResponsibility.Request;

public interface Handler {
    boolean handlerRequest(Request request);
    void setNextHandler(Handler nextHandler);
}
