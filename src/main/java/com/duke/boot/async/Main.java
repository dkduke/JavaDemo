package com.duke.boot.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: dengkun11
 * @date: 2022/08/06
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i=0; i<10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        context.close();

    }

}
