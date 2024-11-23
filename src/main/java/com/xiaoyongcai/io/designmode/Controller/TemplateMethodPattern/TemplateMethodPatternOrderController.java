package com.xiaoyongcai.io.designmode.Controller.TemplateMethodPattern;

import com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.Impl.FlashSaleOrderProcessor;
import com.xiaoyongcai.io.designmode.Service.TemplateMethodPattern.Impl.NormalOrderProcessor;
import com.xiaoyongcai.io.designmode.pojo.TemplateMethodPattern.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class TemplateMethodPatternOrderController {

    @Autowired
    private NormalOrderProcessor normalOrderProcessor;

    @Autowired
    private FlashSaleOrderProcessor flashSaleOrderProcessor;

    // 创建普通订单
    @PostMapping("/normal")
    public ResponseEntity<String> createNormalOrder(@RequestBody OrderRequest orderRequest) {
        normalOrderProcessor.processorOrder(orderRequest);
        return ResponseEntity.ok("普通订单处理完成");
    }

    // 创建秒杀订单
    @PostMapping("/flashsale")
    public ResponseEntity<String> createFlashSaleOrder(@RequestBody OrderRequest orderRequest) {
        flashSaleOrderProcessor.processorOrder(orderRequest);
        return ResponseEntity.ok("秒杀订单处理完成");
    }
}
