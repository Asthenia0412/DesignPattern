package com.xiaoyongcai.io.designmode.Service.CommandPattern.Impl;

import com.xiaoyongcai.io.designmode.Service.CommandPattern.Command;
import com.xiaoyongcai.io.designmode.pojo.CommandPattern.CommentRequest;
import com.xiaoyongcai.io.designmode.pojo.CommandPattern.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class CommentCommand implements Command {
    private final CommentRequest request;
    private final CommentResponse response;

    public CommentCommand(CommentRequest request, CommentResponse response) {
        this.request = request;
        this.response = response;
    }
    @Override
    public void execute() {
        // 模拟评论的业务逻辑
        System.out.println("[命令模式]-笔记" + request.getNoteId()+"被用户"+request.getUserId()+"评论成功！内容是："+request.getComment());
        response.setSuccess(true);
        response.setMessage("[命令模式]-评论成功");
    }
}
