package com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern;

import com.xiaoyongcai.io.designmode.pojo.TemplateMethodPattern.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public abstract class OrderProcessor {
    public final void processorOrder(OrderRequest orderRequest){
        validateUser(orderRequest);
        calculatePrice(orderRequest);
        createOrder(orderRequest);
        processorSpecificOrder(orderRequest);
        finishOrder(orderRequest);
    }

    private void validateUser(OrderRequest orderRequest){
        System.out.println("[模版方法模式->通用模版]验证用户信息："+orderRequest.getUserId());
    }
    private void calculatePrice(OrderRequest orderRequest){
        System.out.println("[模版方法模式->通用模版]计算订单价格："+orderRequest.getTotalPrice());
    }
    private void createOrder(OrderRequest orderRequest){
        System.out.println("[模版方法模式-通用模版]创建订单："+orderRequest.getOrderId());
    }
    protected abstract void processorSpecificOrder(OrderRequest orderRequest);

    private void finishOrder(OrderRequest orderRequest){
        System.out.println("[模版方法模式-通用模版]订单处理完成："+orderRequest.getOrderId());
    }
}
