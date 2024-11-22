package com.xiaoyongcai.io.designmode.pojo.Strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrategyRequest {
    private String orderType;
    private String paymentMethod;
    private double amount;
}
