package com.duke.boot.sirector;

import com.jd.sirector.Callback;
import com.jd.sirector.EventHandler;
import com.jd.sirector.Sirector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengkun11
 * @date: 2023/01/05
 * @description: 基本编排示例
 */
public class SirectorHelloWorld {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sirector<HelloWorldEvent> sirector = new Sirector<HelloWorldEvent>(executorService);

        //准备事件处理器实例和回调实例
        HelloWorldEventHandler onceHandler = new HelloWorldEventHandler(1);
        HelloWorldEventHandler twiceHandler = new HelloWorldEventHandler(2);
        HelloWorldEventHandler threeHandler = new HelloWorldEventHandler(3);
        HelloWorldEventHandler fourHandler = new HelloWorldEventHandler(4);
        Callback<HelloWorldEvent> alertCallback = new AlertCallback();

        //编排事件处理器
//        sirector.begin(onceHandler).then(twiceHandler);
//        sirector.after(onceHandler).then(threeHandler);
//        sirector.after(twiceHandler, threeHandler).then(fourHandler);
//        sirector.ready();

        sirector.begin(onceHandler).then(twiceHandler, threeHandler);
        sirector.after(twiceHandler, threeHandler).then(fourHandler);
        sirector.ready();

        /**

         --> 2 -->
         |        |
         1        --> 4
         |        |
         --> 3 -->

         */

        //同步发布事件
        HelloWorldEvent event = sirector.publish(new HelloWorldEvent());
        System.out.println("  hello world are called " + event.callCount + " times");
        sirector.publish(new HelloWorldEvent(), alertCallback);

    }

    static class HelloWorldEvent {
        private int callCount;

        public void increaseCallCount() {
            callCount++;
        }

        public int getCallCount() {
            return callCount;
        }
    }

    static class HelloWorldEventHandler implements EventHandler<HelloWorldEvent> {

        private final int times;

        public HelloWorldEventHandler(int times) {
            this.times = times;
        }

        @Override
        public void onEvent(HelloWorldEvent helloWorldEvent) {
            if (times == 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("handler " + times);
            for (int i=0; i<times; i++) {
                helloWorldEvent.increaseCallCount();
            }
        }
    }

    static class AlertCallback implements Callback<HelloWorldEvent> {

        @Override
        public void onSuccess(HelloWorldEvent event) {
            System.out.println("hello world are called " + event.callCount + " times");
        }

        @Override
        public void onError(HelloWorldEvent helloWorldEvent, Throwable throwable) {
            //处理异常
            System.out.println("异常处理");
        }
    }
}
