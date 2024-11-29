package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearningProgressRequest {
    private String studentId;
    private double progressPercentage;
    private String completionDate;

    // getters and setters
}
