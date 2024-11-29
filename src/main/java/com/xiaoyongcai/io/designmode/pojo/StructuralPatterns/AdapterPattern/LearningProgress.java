package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LearningProgress {
    private String studentId;
    private Integer progressPercentage;
    private String completionDate;
    private String AdditionalMessage;

    // getters and setters
}
