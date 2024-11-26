package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.Strategy;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.BridgePattern.OrderService;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.Strategy.StrategyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody StrategyRequest request) {
        try{
            orderService.processOrder(request.getOrderType(),request.getPaymentMethod(),request.getAmount());
            return ResponseEntity.ok("订单成功的添加了");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("错误的执行订单"+e.getMessage());
        }
    }
}
