package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.DoubleCheckedLockingSingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doubleCheckedLockingSingleton")
public class DoubleCheckedLockingSingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        DoubleCheckedLockingSingletonService doubleCheckedLockingSingletonService = DoubleCheckedLockingSingletonService.getInstance();
        String result = doubleCheckedLockingSingletonService.processWorkflow();
        return ResponseEntity.ok(result);
    }
}
