package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryLeaf implements CategoryComponent{
    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(CategoryComponent categoryComponent) {
        throw new UnsupportedOperationException("叶子结点不允许朝其中添加元素");
    }

    @Override
    public void remove(CategoryComponent categoryComponent) {
        throw new UnsupportedOperationException("叶子结点不允许删去其子元素，因为其没有子元素");
    }

    @Override
    public List<CategoryComponent> getChildren() {
        return new ArrayList<>();//叶子结点不存在子节点集合
    }
}
