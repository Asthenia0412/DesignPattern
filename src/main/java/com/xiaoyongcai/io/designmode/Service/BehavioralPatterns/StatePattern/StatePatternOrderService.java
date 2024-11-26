package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.StatePattern;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.Impl.PendingState;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.StatePattern.OrderContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@Slf4j
public class StatePatternOrderService {
    private static Map<Long, OrderContext> orders = new HashMap<>();
    private static Long orderIdCounter = 0L;

    // 创建订单并初始化状态为待支付
    public static void createOrder() {
        orderIdCounter++;
        OrderContext context = new OrderContext(new PendingState());
        log.info("[状态模式]：订单创建成功，订单序号为"+orderIdCounter);
        orders.put(orderIdCounter, context);

    }

    // 支付订单
    public static void payOrder(Long orderId) {
        OrderContext context = orders.get(orderId);
        if(context == null) {
            log.info("[状态模式]：尚未查询到该订单号，还请生成订单后再做订单状态变更");

        }
        if (context != null) {
            context.request(); // 执行状态转换
            log.info("[状态模式]：订单支付成功，订单序号为"+orderIdCounter);
        }

    }

    // 发货订单
    public static void shipOrder(Long orderId) {
        OrderContext context = orders.get(orderId);
        if(context == null) {
            log.info("[状态模式]：尚未查询到该订单号，还请生成订单后再做订单状态变更");

        }
        if (context != null) {
            context.request(); // 执行状态转换
            log.info("[状态模式]：订单发货成功，订单序号为"+orderIdCounter);
        }

    }

    // 完成订单
    public static void completeOrder(Long orderId) {
        OrderContext context = orders.get(orderId);
        if(context == null) {
            log.info("[状态模式]：尚未查询到该订单号，还请生成订单后再做订单状态变更");

        }
        if (context != null) {
            context.request(); // 执行状态转换
            log.info("[状态模式]：订单已经完成交易，订单序号为"+orderIdCounter);
        }
    }
}
