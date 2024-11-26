package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.ChainOfResponsibility;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.ChainOfResponsibility.RequestProcessor;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.ChainOfResponsibility.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestProcessor requestProcessor;

    public RequestController(RequestProcessor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    @PostMapping("/validateRequest")
    public String validateRequest(@RequestBody Request request) {
        boolean result = requestProcessor.processRequest(request);
        return result ? "Request processed successfully" : "Request validation failed";
    }
}
