package com.xiaoyongcai.io.designmode.pojo.BehavioralPatterns.ChainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private boolean loggedIn;
    private boolean hasPermission;
    private boolean valid;
    public boolean isLoggedIn(){
        return loggedIn;
    }

    public boolean hasPermission(){
        return hasPermission;
    }

    public boolean isValid(){
        return valid;
    }
}
