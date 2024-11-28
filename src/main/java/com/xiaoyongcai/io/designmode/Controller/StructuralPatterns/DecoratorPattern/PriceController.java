    package com.xiaoyongcai.io.designmode.Controller.StructuralPatterns.DecoratorPattern;

    import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculator;
    import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.DecoratorPattern.DecoratorRequest;
    import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.DecoratorPattern.DecoratorResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/DecoratorPattern")
    public class PriceController {

        private final PriceCalculator priceCalculator;

        // 构造器注入 PriceCalculator 装饰器链
        @Autowired
        public PriceController(PriceCalculator priceCalculator) {
            this.priceCalculator = priceCalculator;
        }

        @PostMapping("/calculatePrice")
        public DecoratorResponse calculatePrice(@RequestBody DecoratorRequest request) {
            // 使用传入的装饰器链计算最终价格
            double finalPrice = priceCalculator.calculatePrice(request.getOriginalPrice());
            /*
            * 总结来说，装饰器链的调用顺序是由链的构建方式决定的，而不是由Bean的注入顺序决定的。在您提供的配置中，CouponDiscountDecorator是链的入口点，因此它的calculatePrice方法首先被调用。
            * */
            return new DecoratorResponse(finalPrice);
        }
    }