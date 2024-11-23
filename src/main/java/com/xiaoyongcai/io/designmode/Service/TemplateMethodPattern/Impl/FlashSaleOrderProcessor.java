package com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.OrderProcessor;
import com.xiaoyongcai.io.designmode.pojo.TemplateMethodPattern.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class FlashSaleOrderProcessor extends OrderProcessor {
    @Override
    protected void processorSpecificOrder(OrderRequest orderRequest) {
        System.out.println("[模板方法模式->具体订单处理]:秒杀订单处理：因为是秒杀订单，因此需要执行库存检查的业务");
    }
}
