package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern;

import org.springframework.stereotype.Service;
public interface PriceCalculator {
    double calculatePrice(double originalPrice);
}
