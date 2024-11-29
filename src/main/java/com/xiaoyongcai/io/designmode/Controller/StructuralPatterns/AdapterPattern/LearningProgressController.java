package com.xiaoyongcai.io.designmode.Controller.StructuralPatterns.AdapterPattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgress;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgressRequest;
import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.AdapterPattern.LearningProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AdapterPattern")
public class LearningProgressController {

    @Autowired
    private LearningProgressService learningProgressService;

    @PostMapping("/get-progress")
    public ResponseEntity<LearningProgress> getLearningProgress(@RequestBody LearningProgressRequest request) {
        LearningProgress progress = learningProgressService.getLearningProgress(request);
        return ResponseEntity.ok(progress);
    }
}