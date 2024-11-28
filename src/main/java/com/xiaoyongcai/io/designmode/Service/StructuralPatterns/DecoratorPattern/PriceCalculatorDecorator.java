package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public abstract class PriceCalculatorDecorator implements PriceCalculator {

    protected PriceCalculator priceCalculator;  // 被装饰的 PriceCalculator

    // 构造器注入 PriceCalculator
    public PriceCalculatorDecorator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}



