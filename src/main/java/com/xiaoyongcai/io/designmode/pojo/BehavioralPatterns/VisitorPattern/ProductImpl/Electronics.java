package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.Product;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electronics implements Product {
    private double price;
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);  // 传递给访问者
    }
}
