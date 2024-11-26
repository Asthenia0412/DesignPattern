    package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern;

    import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern.TrueService.InventoryService;
    import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern.TrueService.LogisticsService;
    import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern.TrueService.PaymentService;
    import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.MediatorPattern.MediatorOrder;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;
    @Slf4j
    @Service
    public class OrderProcessingMediator implements OrderMediator{
        private final InventoryService inventoryService;
        private final PaymentService paymentService;
        private final LogisticsService logisticsService;

        public OrderProcessingMediator(InventoryService inventoryService, PaymentService paymentService, LogisticsService logisticsService) {
            this.inventoryService = inventoryService;
            this.paymentService = paymentService;
            this.logisticsService = logisticsService;
        }

        @Override
        public void processOrder(MediatorOrder order) {
            // 库存检查
            if (inventoryService.checkStock(order)) {
                // 进行支付处理
                if (paymentService.processPayment(order)) {
                    // 发货
                    logisticsService.shipOrder(order);
                } else {
                    throw new RuntimeException("[中介者模式]:捕获支付异常" + order.getId());
                }
            } else {
                throw new RuntimeException("[中介者模式]:捕获库存检查异常 " + order.getId());
            }
        }
    }
