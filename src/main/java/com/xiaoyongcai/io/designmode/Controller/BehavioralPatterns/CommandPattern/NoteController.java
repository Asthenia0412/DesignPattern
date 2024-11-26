package com.xiaoyongcai.io.designmode.Controller.BehavioralPatterns.CommandPattern;
import com.xiaoyongcai.io.designmode.Service.BehavioralPatterns.CommandPattern.CommandService;
import com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.CommandPattern.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private CommandService commandService;

    @PostMapping("/publishNote")
    public PublishNoteResponse publishNote(@RequestBody PublishNoteRequest request) {
        PublishNoteResponse response = new PublishNoteResponse();
        commandService.executePublishNoteCommand(request, response);
        return response;
    }

    @PostMapping("/like")
    public LikeResponse like(@RequestBody LikeRequest request) {
        LikeResponse response = new LikeResponse();
        commandService.executeLikeCommand(request, response);
        return response;
    }

    @PostMapping("/comment")
    public CommentResponse comment(@RequestBody CommentRequest request) {
        CommentResponse response = new CommentResponse();
        commandService.executeCommentCommand(request, response);
        return response;
    }
}
