package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculator;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculatorDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component  // 使用 @Component 注解以便 Spring 管理这个装饰器
public class CouponDiscountDecorator extends PriceCalculatorDecorator {

    private static final double COUPON_DISCOUNT = 0.8; // 优惠券折扣 20%

    // 构造器注入 PriceCalculator
    public CouponDiscountDecorator(PriceCalculator priceCalculator) {
        super(priceCalculator);  // 传递给父类构造器
    }

    @Override
    public double calculatePrice(double originalPrice) {

        double price = priceCalculator.calculatePrice(originalPrice);  // 调用下一个装饰器或默认计算器
        log.info("[装饰器模式]经过优惠卷判断：目前需要花费"+price*COUPON_DISCOUNT);
        return price * COUPON_DISCOUNT; // 应用优惠券折扣
    }
}