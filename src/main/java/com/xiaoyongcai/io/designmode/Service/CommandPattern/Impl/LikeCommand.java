package com.xiaoyongcai.io.designmode.Service.CommandPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.CommandPattern.Command;
import com.xiaoyongcai.io.designmode.pojo.CommandPattern.LikeRequest;
import com.xiaoyongcai.io.designmode.pojo.CommandPattern.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class LikeCommand implements Command {

    // 删除构造函数中的 LikeRequest 和 LikeResponse 参数
    private final LikeRequest request;
    private final LikeResponse response;

    // 使用 @Autowired 注解让 Spring 自动注入 LikeRequest 和 LikeResponse
    public LikeCommand(LikeRequest request, LikeResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        // 执行点赞业务逻辑
        System.out.println("[命令模式] - 笔记" + request.getNoteId() + "已经被用户" + request.getUserId() + "点赞成功");
        response.setSuccess(true);
        response.setMessage("[命令模式] - 笔记点赞成功");
    }
}
