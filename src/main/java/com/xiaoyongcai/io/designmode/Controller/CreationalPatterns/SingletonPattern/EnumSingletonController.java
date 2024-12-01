package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.EnumSingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enumSingleton")
public class EnumSingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        String result = EnumSingletonService.INSTANCE.processWorkflow();
        return ResponseEntity.ok(result);
    }
}
