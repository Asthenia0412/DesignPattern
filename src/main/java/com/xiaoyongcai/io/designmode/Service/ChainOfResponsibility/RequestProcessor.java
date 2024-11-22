package com.xiaoyongcai.io.designmode.Service.ChainOfResponsibility;

import com.xiaoyongcai.io.designmode.Handler.Handler;
import com.xiaoyongcai.io.designmode.Handler.LoginHanlder;
import com.xiaoyongcai.io.designmode.Handler.ParameterHandler;
import com.xiaoyongcai.io.designmode.Handler.PermissionHandler;
import com.xiaoyongcai.io.designmode.pojo.ChainOfResponsibility.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestProcessor {

    private final Handler loginHandler;
    private final Handler permissionHandler;
    private final Handler parameterHandler;

    public RequestProcessor() {
        // 创建处理器
        this.loginHandler = new LoginHanlder();
        this.permissionHandler = new PermissionHandler();
        this.parameterHandler = new ParameterHandler();

        // 设置责任链
        loginHandler.setNextHandler(permissionHandler);
        permissionHandler.setNextHandler(parameterHandler);
    }

    public boolean processRequest(Request request) {
        return loginHandler.handlerRequest(request);
    }
}
