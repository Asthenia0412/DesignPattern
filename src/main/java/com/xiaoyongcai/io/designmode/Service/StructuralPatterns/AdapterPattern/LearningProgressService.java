package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.AdapterPattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgress;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningProgressService {

    @Autowired
    private LearningProgressAdapter learningProgressAdapter;

    public LearningProgress getLearningProgress(LearningProgressRequest request) {
        return learningProgressAdapter.adapt(request);
    }
}
