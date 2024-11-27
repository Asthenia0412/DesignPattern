package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FlyweightPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class TagFactory {
    private Map<String,Tag> tagCache = new HashMap<>();

    public Tag getInstance(String name,String color){
        //生成唯一的key，由name和color组成
        //在真实业务中，这一块生成的是redis中的key
        String key = name+"-"+color;
        if(!tagCache.containsKey(key)){
            log.info("key:"+key+"尚未出现在缓存中,此时往缓存中添加该key对应的Tag,注意：在工厂中并没有设置其description这个外部属性");
            tagCache.put(key,new Tag(name,color));
        }else if(tagCache.containsKey(key)){
            log.info("key:"+key+"享元模式发挥作用咯！因为你两次请求的tag的内部属性都是一样的！享元模式会复用缓存中已经存在的color和name!只有你的description是不同的");
        }
        return tagCache.get(key);
    }
}
