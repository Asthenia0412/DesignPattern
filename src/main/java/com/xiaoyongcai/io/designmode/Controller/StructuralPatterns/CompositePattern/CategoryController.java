package com.xiaoyongcai.io.designmode.Controller.StructuralPatterns.CompositePattern;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.CompositePattern.CategoryService;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern.CategoryComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/CompositePattern")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryTree")
    public ResponseEntity<List<String>> getCategoryTree() {
        CategoryComponent root = categoryService.getCategoryTree();
        List<String> categoryNames = new ArrayList<>();

        collectCategoryNames(root, categoryNames);
        return ResponseEntity.ok(categoryNames);
    }

    private void collectCategoryNames(CategoryComponent component, List<String> categoryNames) {
        categoryNames.add(component.getName());
        log.info("子项存在 " + component.getName());
        for (CategoryComponent child : component.getChildren()) {
            log.info(component.getName() + " 的子节点:" + child.getName());
            collectCategoryNames(child, categoryNames);
        }
    }

}
