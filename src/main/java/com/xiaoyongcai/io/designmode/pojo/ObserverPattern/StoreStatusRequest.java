package com.xiaoyongcai.io.designmode.pojo.ObserverPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 请求参数类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreStatusRequest {
    private String storeStatus;  // 商户的状态
}