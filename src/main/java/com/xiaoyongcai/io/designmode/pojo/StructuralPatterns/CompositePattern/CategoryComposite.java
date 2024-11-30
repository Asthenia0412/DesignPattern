package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryComposite implements CategoryComponent{
    private String name;
    private List<CategoryComponent> children = new ArrayList<CategoryComponent>();
    public CategoryComposite(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(CategoryComponent categoryComponent) {
        children.add(categoryComponent);
    }

    @Override
    public void remove(CategoryComponent categoryComponent) {
        children.remove(categoryComponent);
    }

    @Override
    public List<CategoryComponent> getChildren() {
        return children;
    }
}
