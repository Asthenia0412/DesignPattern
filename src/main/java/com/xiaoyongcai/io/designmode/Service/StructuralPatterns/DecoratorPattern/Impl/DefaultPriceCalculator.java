package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component  // 将 DefaultPriceCalculator 注册为 Spring Bean
public class DefaultPriceCalculator implements PriceCalculator {

    @Override
    public double calculatePrice(double originalPrice) {
        log.info("[装饰器模式]defaultPriceCalculator被调用了一次");
        return originalPrice;  // 默认返回原价
    }
}