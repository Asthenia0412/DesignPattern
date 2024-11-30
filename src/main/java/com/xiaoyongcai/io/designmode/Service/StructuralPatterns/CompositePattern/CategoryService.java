package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.CompositePattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern.CategoryComponent;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern.CategoryComposite;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.CompositePattern.CategoryLeaf;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public CategoryComponent getCategoryTree(){
        CategoryComposite root = new CategoryComposite("课程综合");

        CategoryComposite baseClass = new CategoryComposite("学科基础课");

        baseClass.add(new CategoryLeaf("微积分"));
        baseClass.add(new CategoryLeaf("离散数学"));
        baseClass.add(new CategoryLeaf("线性代数"));
        baseClass.add(new CategoryLeaf("概率论与数理统计"));

        CategoryComposite ProjectClass = new CategoryComposite("工程专业课");

        ProjectClass.add(new CategoryLeaf("JavaSE"));
        ProjectClass.add(new CategoryLeaf("Spring单体开发"));
        ProjectClass.add(new CategoryLeaf("分布式计算理论"));
        ProjectClass.add(new CategoryLeaf("Redis技术原理"));
        ProjectClass.add(new CategoryLeaf("消息队列分析-Kafka,RabbitMQ,RocketMQ"));
        ProjectClass.add(new CategoryLeaf("SpringCloud微服务开发"));

        root.add(baseClass);
        root.add(ProjectClass);
        return root;
    }
}
