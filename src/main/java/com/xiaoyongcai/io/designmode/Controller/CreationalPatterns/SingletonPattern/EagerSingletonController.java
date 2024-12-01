package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.EagerSingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eagerSingleton")
public class EagerSingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        EagerSingletonService eagerSingletonService = EagerSingletonService.getInstance();
        String result = eagerSingletonService.processWorkflow();
        return ResponseEntity.ok(result);
    }
}
