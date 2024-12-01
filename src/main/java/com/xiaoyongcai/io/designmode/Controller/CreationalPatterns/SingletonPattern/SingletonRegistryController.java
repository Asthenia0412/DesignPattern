package com.xiaoyongcai.io.designmode.Controller.CreationalPatterns.SingletonPattern;

import com.xiaoyongcai.io.designmode.Service.CreationalPatterns.SingletonPattern.SingletonRegistryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singletonRegistry")
public class SingletonRegistryController {

    @GetMapping("/process/{className}")
    public ResponseEntity<String> processWorkflow(@PathVariable String className) {
        Object instance = SingletonRegistryService.getInstance(className);
        if (instance instanceof SingletonRegistryService) {
            String result = ((SingletonRegistryService) instance).processWorkflow();
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body("Invalid class name");
    }
}
