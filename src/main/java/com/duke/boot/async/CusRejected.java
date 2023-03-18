package com.duke.boot.async;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: dengkun11
 * @date: 2022/11/14
 * @description: 拒绝策略
 */
public class CusRejected implements RejectedExecutionHandler {

    public CusRejected() {}

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理...");
        System.out.println("当前被拒绝任务为：" + r.toString());
    }
}
