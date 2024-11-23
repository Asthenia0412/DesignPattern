package com.xiaoyongcai.io.designmode.pojo.TemplateMethodPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String orderId;
    private String userId;
    private double totalPrice;
}
