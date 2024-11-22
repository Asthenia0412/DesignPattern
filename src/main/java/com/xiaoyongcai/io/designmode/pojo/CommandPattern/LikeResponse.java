package com.xiaoyongcai.io.designmode.pojo.CommandPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponse{
    private boolean success;
    private String message;
}


