package com.xiaoyongcai.io.designmode.Handler;

import com.xiaoyongcai.io.designmode.pojo.ChainOfResponsibility.Request;

public class PermissionHandler implements Handler{
    private Handler nextHandler;

    @Override
    public boolean handlerRequest(Request request) {
        if(request.hasPermission()){
            System.out.println("用户拥有权限！！");
            if(nextHandler!=null){
                return nextHandler.handlerRequest(request);
            }
            return true;
        }
        System.out.println("用户没有权限,责任链终止！");
        return false;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
