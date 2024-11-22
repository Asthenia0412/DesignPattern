package com.xiaoyongcai.io.designmode.Service.BridgePattern;

import com.xiaoyongcai.io.designmode.Service.BridgePattern.Impl.OfflineOrderProcessor;
import com.xiaoyongcai.io.designmode.Service.BridgePattern.Impl.OnlineOrderProcessor;
import com.xiaoyongcai.io.designmode.Service.Strategy.Impl.AlipayPayment;
import com.xiaoyongcai.io.designmode.Service.Strategy.Impl.CreditCardPayment;
import com.xiaoyongcai.io.designmode.Service.Strategy.Impl.WeChatPayment;
import com.xiaoyongcai.io.designmode.Service.Strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final Map<String, OrderProcessor> orderProcessorMap;

    @Autowired
    public OrderService(List<OrderProcessor> orderProcessors) {
        orderProcessorMap = new HashMap<>();
        for (OrderProcessor orderProcessor : orderProcessors) {
            if (orderProcessor instanceof OnlineOrderProcessor) {
                orderProcessorMap.put("Online", orderProcessor);
            } else if (orderProcessor instanceof OfflineOrderProcessor) {
                orderProcessorMap.put("Offline", orderProcessor);
            }
        }
    }

    public void processOrder(String orderType, String paymentMethod, double amount) {
        // 获取对应的 OrderProcessor
        OrderProcessor processor = orderProcessorMap.get(orderType);
        if (processor == null) {
            throw new IllegalArgumentException("注意：你的订单类型无效,请确认是否为Online或者Offline: " + orderType);
        }

        // 根据传入的支付方式选择支付策略
        PaymentStrategy paymentStrategy = choosePaymentStrategy(paymentMethod);

        // 将选择的支付策略注入到处理器中
        processor.setPaymentStrategy(paymentStrategy);

        // 执行订单处理逻辑
        processor.processOrder(amount);
    }

    // 动态选择支付策略的逻辑
    private PaymentStrategy choosePaymentStrategy(String paymentMethod) {
        switch (paymentMethod) {
            case "credit_card":
                return new CreditCardPayment();
            case "alipay":
                return new AlipayPayment();
            case "wechat":
                return new WeChatPayment();
            default:
                throw new IllegalArgumentException("前端传入的支付方式请求出错/请检查是否为credit_card, alipay, wechat: " + paymentMethod);
        }
    }
}
