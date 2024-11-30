package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern;

import java.util.List;

public interface CategoryComponent {
    String getName();
    void add(CategoryComponent categoryComponent);//组合模式的add方法
    void remove(CategoryComponent categoryComponent);//组合模式的删除方法
    List<CategoryComponent> getChildren();
}
