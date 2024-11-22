package com.xiaoyongcai.io.designmode.Handler;

import com.xiaoyongcai.io.designmode.pojo.ChainOfResponsibility.Request;

public interface Handler {
    boolean handlerRequest(Request request);
    void setNextHandler(Handler nextHandler);
}
