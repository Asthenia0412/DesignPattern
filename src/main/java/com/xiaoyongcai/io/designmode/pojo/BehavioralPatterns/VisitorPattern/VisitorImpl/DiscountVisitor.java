package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.VisitorImpl;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Clothing;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Electronics;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Food;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DiscountVisitor implements ProductVisitor {
    private double totalDiscount = 0;
    @Override
    public void visit(Electronics electronics) {
        //电子产品打八折
        totalDiscount += electronics.getPrice()*0.2;
        log.info("[访问者模式]：电子产品打8折后价格为"+electronics.getPrice()*0.2+"原价为"+electronics.getPrice());

    }

    @Override
    public void visit(Clothing clothing) {
        //衣物商品打7折
        totalDiscount+=clothing.getPrice()*0.3;
        log.info("[访问者模式]衣物商品打7折后价格为"+clothing.getPrice()*0.2+"原价为"+clothing.getPrice());
    }

    @Override
    public void visit(Food food) {
        //食品商品打9折
        totalDiscount += food.getPrice()*0.1;
        log.info("[访问者模式]食品商品打9折后价格为"+food.getPrice()*0.2+"原价为"+food.getPrice());
    }
}
