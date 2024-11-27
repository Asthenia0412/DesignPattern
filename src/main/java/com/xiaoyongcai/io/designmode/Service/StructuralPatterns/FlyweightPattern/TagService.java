package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FlyweightPattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FlyweightPattern.Tag;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FlyweightPattern.TagFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TagService {
    private TagFactory tagFactory = new TagFactory();

    public Tag getTagForProduct(String name,String color,String description){
        //获取享元对象
        Tag tag = tagFactory.getInstance(name,color);
        //设置外部状态
        tag.setDescription(description);

        return tag;
    }

}
