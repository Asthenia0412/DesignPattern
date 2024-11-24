package com.xiaoyongcai.io.designmode.pojo.VisitorPattern;

public interface Product {
    void accept(ProductVisitor visitor);
}
