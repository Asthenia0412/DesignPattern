package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.CommandPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequest{
    private String noteId;
    private String userId;

    // Getters and Setters
}
