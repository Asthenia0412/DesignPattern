package com.xiaoyongcai.io.designmode.pojo.VisitorPattern.ProductImpl;

import com.xiaoyongcai.io.designmode.pojo.VisitorPattern.Product;
import com.xiaoyongcai.io.designmode.pojo.VisitorPattern.ProductVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food implements Product {
    private double price;
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);  // 传递给访问者
    }
}
