package com.xiaoyongcai.io.designmode.Controller.ObserverPattern;

import com.xiaoyongcai.io.designmode.Service.ObserverPattern.StoreService;
import com.xiaoyongcai.io.designmode.pojo.ObserverPattern.StoreStatusRequest;
import com.xiaoyongcai.io.designmode.pojo.ObserverPattern.StoreStatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger log = LoggerFactory.getLogger(StoreController.class);
    @Autowired
    private StoreController storeController;
    @Autowired
    private StoreService storeService;

    @PostMapping("/update-status")
    public StoreStatusResponse updateStoreStatus(@RequestBody StoreStatusRequest request){
        storeService.updateStoreStatus(request.getStoreStatus());
        log.info("Controller层可以正常工作");
        return new StoreStatusResponse("状态更新成功",200);
    }
}
