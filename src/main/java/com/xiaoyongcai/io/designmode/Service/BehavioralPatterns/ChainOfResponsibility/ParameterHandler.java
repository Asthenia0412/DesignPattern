package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ChainOfResponsibility;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.ChainOfResponsibility.Request;

public class ParameterHandler implements Handler {
    private Handler nextHandler;
    @Override
    public boolean handlerRequest(Request request) {
        if(request.isValid()){
            System.out.println("参数有效！责任链可以继续进行");
            if(nextHandler != null){
                return  nextHandler.handlerRequest(request);
            }
            return true;
        }
        System.out.println("参数无效,责任链请求终止");
        return false;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
