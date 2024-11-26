package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.Command;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.CommandPattern.PublishNoteRequest;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.CommandPattern.PublishNoteResponse;

public class PublishNoteCommand implements Command {
    private final PublishNoteRequest request;
    private final PublishNoteResponse response;


    public PublishNoteCommand(PublishNoteRequest request, PublishNoteResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        //模拟发布笔记的业务逻辑
        System.out.println("[命令模式]-发布笔记命令成功"+request.getContent());
        response.setSuccess(true);
        response.setMessage("[命令模式]-发布笔记已经成功执行");
    }
}
