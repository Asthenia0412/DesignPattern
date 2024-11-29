package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.AdapterPattern;

import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgress;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.AdapterPattern.LearningProgressRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class LearningProgressAdapterImpl implements LearningProgressAdapter {


    @Override
    public LearningProgress adapt(LearningProgressRequest request) {
        // 假设前端传递的数据中，学习进度是以double类型转换，你要返回给前端的是Integer类型的进度。
        LearningProgress progress = new LearningProgress();
        progress.setStudentId(request.getStudentId());
        progress.setProgressPercentage(Integer.valueOf((int)request.getProgressPercentage()));
        progress.setCompletionDate(request.getCompletionDate());
        progress.setAdditionalMessage("适配器成功将前端传入的double类型进度转化为了Integer类型进度");
        log.info("[适配器模式]：成功获取传入对象"+request.getCompletionDate() +" "+request.getProgressPercentage()+" "+request.getStudentId());
        log.info("[适配器模式]：成功适配完成，产生新对象"+progress.getCompletionDate()+" "+progress.getProgressPercentage()+" "+progress.getStudentId()+" "+progress.getAdditionalMessage());

        return progress;
    }
}
