package com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.OrderProcessor;
import com.xiaoyongcai.io.designmode.pojo.TemplateMethodPattern.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class NormalOrderProcessor extends OrderProcessor {
    @Override
    protected void processorSpecificOrder(OrderRequest orderRequest) {
        System.out.println("[模板方法模式->具体订单处理]普通订单特殊处理：发货处理");
    }
}
