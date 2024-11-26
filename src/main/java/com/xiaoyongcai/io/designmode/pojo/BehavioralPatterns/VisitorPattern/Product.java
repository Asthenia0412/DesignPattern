package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern;

public interface Product {
    void accept(ProductVisitor visitor);
}
