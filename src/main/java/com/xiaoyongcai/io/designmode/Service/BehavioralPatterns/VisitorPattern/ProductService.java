package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.VisitorPattern;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.Product;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.VisitorImpl.DiscountVisitor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public double calculateTotalDiscount(List<Product> products) {
        // 创建一个DiscountVisitor实例
        DiscountVisitor discountVisitor = new DiscountVisitor();

        // 遍历每个商品，执行折扣计算
        for (Product product : products) {
            product.accept(discountVisitor);
        }

        // 返回总折扣
        return discountVisitor.getTotalDiscount();
    }
}
