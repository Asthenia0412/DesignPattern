package com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern;

import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.Impl.CommentCommand;
import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.Impl.LikeCommand;
import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.Impl.PublishNoteCommand;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.CommandPattern.*;
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
