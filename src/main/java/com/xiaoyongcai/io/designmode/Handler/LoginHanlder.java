package com.xiaoyongcai.io.designmode.Handler;

import com.xiaoyongcai.io.designmode.pojo.ChainOfResponsibility.Request;

public class LoginHanlder implements Handler{
    private Handler nextHandler;
    @Override
    public boolean handlerRequest(Request request) {
        if(request.isLoggedIn()){
            System.out.println("用户已经登录成功");
            if(nextHandler!=null){
                return nextHandler.handlerRequest(request);
            }
            return true;
        }
        System.out.println("登录失败咯！责任链终止");
        return false;
    }


    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
