package com.xiaoyongcai.io.designmode.pojo.VisitorPattern;

import com.xiaoyongcai.io.designmode.pojo.VisitorPattern.ProductImpl.Clothing;
import com.xiaoyongcai.io.designmode.pojo.VisitorPattern.ProductImpl.Electronics;
import com.xiaoyongcai.io.designmode.pojo.VisitorPattern.ProductImpl.Food;

public interface ProductVisitor {
    void visit(Electronics electronics);
    void visit(Clothing clothing);
    void visit(Food food);
}
