package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl.CouponDiscountDecorator;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl.DefaultPriceCalculator;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.DecoratorPattern.Impl.MemberDiscountDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class PriceCalculatorConfig {

    @Bean
    //这里的PriceCalculator和MemberDiscountDecorator CouponDiscountDecorator  DefaultPriceCalculator 三者存在循环依赖
    //因此先把defaultPriceCalculator注入了
    //为什么先注入defaultPriceCalculator？这是因为defaultPriceCalculator里面没有对PriceCalculator的依赖
    public PriceCalculator priceCalculator( DefaultPriceCalculator defaultPriceCalculator,
                                           @Lazy MemberDiscountDecorator memberDiscountDecorator,
                                           @Lazy CouponDiscountDecorator couponDiscountDecorator) {
        /*Spring容器在创建Bean时，默认情况下是按照声明顺序或者依赖关系顺序创建和注入Bean的。
        当Spring容器尝试创建 priceCalculator Bean时，它需要 memberDiscountDecorator 和 couponDiscountDecorator。
        但是，为了创建这两个装饰器Bean，Spring容器又需要 priceCalculator，这样就形成了一个闭环，Spring容器无法解决这个问题，因为它无法确定哪个Bean应该先被创建。*/


        /*
        * 通过使用@Lazy注解，您可以告诉Spring容器在真正需要时才创建依赖的Bean。
        * 这样，Spring容器可以先创建 priceCalculator Bean，而不必立即创建 memberDiscountDecorator 和 couponDiscountDecorator。
        * 当 memberDiscountDecorator 和 couponDiscountDecorator 被实际调用时，Spring容器才会创建它们，并且这时 priceCalculator Bean 已经可用。
        * */


        // 确保装饰器链的顺序：先应用会员折扣，再应用优惠券折扣
        return new CouponDiscountDecorator(new MemberDiscountDecorator(defaultPriceCalculator));
    }
}

