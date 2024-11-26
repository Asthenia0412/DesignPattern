package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.StatePattern;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.StatePattern.StatePatternOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class StatePatternController {
    @Autowired
    private final StatePatternOrderService statePatternOrderService;

    public StatePatternController(StatePatternOrderService statePatternOrderService) {
        this.statePatternOrderService = statePatternOrderService;
    }
    // 创建订单并设置初始状态
    @PostMapping("/create")
    public ResponseEntity<String> createOrder() {
        StatePatternOrderService.createOrder();
        return ResponseEntity.ok("订单创建成功，当前状态：待支付");
    }

    // 触发状态变化
    @PostMapping("/pay/{orderId}")
    public ResponseEntity<String> payOrder(@PathVariable Long orderId) {
        StatePatternOrderService.payOrder(orderId);
        return ResponseEntity.ok("订单支付成功，当前状态：已支付");
    }

    @PostMapping("/ship/{orderId}")
    public ResponseEntity<String> shipOrder(@PathVariable Long orderId) {
        StatePatternOrderService.shipOrder(orderId);
        return ResponseEntity.ok("订单发货成功，当前状态：已发货");
    }

    @PostMapping("/complete/{orderId}")
    public ResponseEntity<String> completeOrder(@PathVariable Long orderId) {
        StatePatternOrderService.completeOrder(orderId);
        return ResponseEntity.ok("订单已完成");
    }

}
