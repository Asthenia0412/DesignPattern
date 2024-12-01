package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.StaticInnerClassSingletonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staticInnerClassSingleton")
public class StaticInnerClassSingletonController {

    @GetMapping("/process")
    public ResponseEntity<String> processWorkflow() {
        StaticInnerClassSingletonService staticInnerClassSingletonService = StaticInnerClassSingletonService.getInstance();
        String result = staticInnerClassSingletonService.processWorkflow();
        return ResponseEntity.ok(result);
    }
}
