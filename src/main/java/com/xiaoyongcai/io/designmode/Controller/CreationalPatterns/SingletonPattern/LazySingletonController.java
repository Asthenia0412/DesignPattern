package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.LazySingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazySingleton")
public class LazySingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        LazySingletonService lazySingletonService = LazySingletonService.getInstance();
        String result = lazySingletonService.processWorkflow();
        return ResponseEntity.ok(result);
    }
}
