package com.xiaoyongcai.io.designmode.Service.CommandPattern;

import com.xiaoyongcai.io.designmode.Service.CommandPattern.Impl.CommentCommand;
import com.xiaoyongcai.io.designmode.Service.CommandPattern.Impl.LikeCommand;
import com.xiaoyongcai.io.designmode.Service.CommandPattern.Impl.PublishNoteCommand;
import com.xiaoyongcai.io.designmode.pojo.CommandPattern.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {



    public void executePublishNoteCommand(PublishNoteRequest request, PublishNoteResponse response) {
        PublishNoteCommand publishNoteCommand = new PublishNoteCommand(request,response);
        publishNoteCommand.execute();
    }

    public void executeLikeCommand(LikeRequest request, LikeResponse response) {
        LikeCommand likeCommand = new LikeCommand(request,response);
        likeCommand.execute();
    }

    public void executeCommentCommand(CommentRequest request, CommentResponse response) {
        CommentCommand commentCommand = new CommentCommand(request,response);
        commentCommand.execute();
    }
}
