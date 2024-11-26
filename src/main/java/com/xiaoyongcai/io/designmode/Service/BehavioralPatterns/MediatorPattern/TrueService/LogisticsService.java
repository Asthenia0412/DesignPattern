    package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern.TrueService;

    import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.MediatorPattern.MediatorOrder;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;
    @Slf4j
    @Service
    public class LogisticsService {
        public void shipOrder(MediatorOrder order){
            //假设发货的逻辑
            log.info("[中介者模式]：模拟发货逻辑中"+" 下单人："+order.getCustomerName()+" 订单号："+order.getId()+" 下单商品："+order.getItems());
        }
    }
