package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.VisitorPattern;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.VisitorPattern.ProductService;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.Product;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Clothing;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Electronics;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.VisitorPattern.ProductImpl.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("VisitorPattern")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/calculateDiscount")
    public String calculateDiscount(@RequestBody List<String> productTypes) {
        List<Product> products = new ArrayList<>();

        // 根据传入的商品类型，创建不同的商品实例
        for (String type : productTypes) {
            switch (type) {
                case "electronics":
                    products.add(new Electronics(100));  // 假设价格是100
                    break;
                case "clothing":
                    products.add(new Clothing(150));    // 假设价格是150
                    break;
                case "food":
                    products.add(new Food(50));         // 假设价格是50
                    break;
            }
        }
        productService.calculateTotalDiscount(products);
        // 调用Service层计算折扣
        return "请在控制台检查访问者模式是否工作";
    }
}
