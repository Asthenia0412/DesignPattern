package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FlyweightPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Tag类,作为享元对象
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tag {
    private String name;//内部状态：标签名称，多个商品共享
    private String color;//内部状态：标签颜色，可以共享
    private String description;//外部状态：标签描述，可能因为商品不同而不同

    public Tag(String name,String color){
        this.name=name;
        this.color=color;
    }
}
