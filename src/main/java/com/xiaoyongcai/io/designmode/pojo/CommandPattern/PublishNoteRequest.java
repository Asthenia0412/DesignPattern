package com.xiaoyongcai.io.designmode.pojo.CommandPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishNoteRequest{
    private String content;
    private String userId;

}