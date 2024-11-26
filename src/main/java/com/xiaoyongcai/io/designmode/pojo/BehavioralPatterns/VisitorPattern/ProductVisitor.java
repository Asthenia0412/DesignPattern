package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern;

import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Clothing;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Electronics;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Food;

public interface ProductVisitor {
    void visit(Electronics electronics);
    void visit(Clothing clothing);
    void visit(Food food);
}
