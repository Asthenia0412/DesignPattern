package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.DecoratorPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecoratorRequest {
    private Integer originalPrice;
    private boolean isMember;
    private boolean hasCoupon;
}
