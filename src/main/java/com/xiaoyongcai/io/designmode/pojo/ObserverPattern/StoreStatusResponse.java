package com.xiaoyongcai.io.designmode.pojo.ObserverPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreStatusResponse {
    private String message;  // 响应消息
    private int code;        // 响应码
}