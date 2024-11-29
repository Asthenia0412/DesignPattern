package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.AdapterPattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgress;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgressRequest;

public interface LearningProgressAdapter {
    LearningProgress adapt(LearningProgressRequest request);
}

