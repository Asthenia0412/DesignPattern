package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.ThreadSafeLazySingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threadSafeLazySingleton")
public class ThreadSafeLazySingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        ThreadSafeLazySingletonService threadSafeLazySingletonService = ThreadSafeLazySingletonService.getInstance();
        String result = threadSafeLazySingletonService.processWorkflow();
        return ResponseEntity.ok(result);
    }
}

