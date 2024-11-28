package com.xiaoyongcai.io.designmode;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl.DefaultPriceCalculator;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl.MemberDiscountDecorator;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.PriceCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignModeApplicationTests {

    @Test
    void contextLoads() {
        DefaultPriceCalculator defaultPriceCalculator = new DefaultPriceCalculator();
        PriceCalculator memberPriceCalculator = new MemberDiscountDecorator(defaultPriceCalculator);

        double originalPrice = 100.0;
        double finalPrice = memberPriceCalculator.calculatePrice(originalPrice);

        System.out.println("Final price with discounts: " + finalPrice);
    }

}
