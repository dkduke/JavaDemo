package com.duke.boot.sirector;

import com.jd.sirector.EventHandler;
import com.jd.sirector.Sirector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * @author: dengkun11
 * @date: 2023/01/05
 * @description: 超时demo
 */
public class SirectorSynTimeout {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sirector<Event> sirector = new Sirector<Event>(executorService);

        SleepHandler handler = new SleepHandler();
        sirector.begin(handler);
        sirector.ready();
        try {
            sirector.publish(new Event(), 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    static class Event {

    }

    static class SleepHandler implements EventHandler<Event> {

        @Override
        public void onEvent(Event event) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
