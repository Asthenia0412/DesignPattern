    package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl;

    import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculator;
    import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculatorDecorator;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Component;

    @Slf4j
    @Component  // 使用 @Component 注解以便 Spring 管理这个装饰器
    public class MemberDiscountDecorator extends PriceCalculatorDecorator {

        private static final double MEMBER_DISCOUNT = 0.9; // 会员折扣 10%

        // 构造器注入 PriceCalculator
        public MemberDiscountDecorator(PriceCalculator priceCalculator) {
            super(priceCalculator);  // 传递给父类构造器
        }

        @Override
        public double calculatePrice(double originalPrice) {
            double price = priceCalculator.calculatePrice(originalPrice);
            log.info("[装饰器模式]经过会员判断：目前需要花费"+price*MEMBER_DISCOUNT);// 调用下一个装饰器或默认计算器
            return price * MEMBER_DISCOUNT; // 应用会员折扣
        }
    }

