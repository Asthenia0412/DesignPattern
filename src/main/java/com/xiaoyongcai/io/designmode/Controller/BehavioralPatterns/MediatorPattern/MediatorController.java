    package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.MediatorPattern;

    import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.MediatorPattern.OrderMediator;
    import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.MediatorPattern.MediatorOrder;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/MediatorPattern")
    public class MediatorController {
        private final OrderMediator orderMediator;

        @Autowired
        public MediatorController(OrderMediator orderMediator) {
            this.orderMediator = orderMediator;
        }

        @PostMapping("/process")
        public ResponseEntity<String> processOrder(@RequestBody MediatorOrder order) {
            try {
                orderMediator.processOrder(order);
                return ResponseEntity.ok("订单已经交给后端处理");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    }
