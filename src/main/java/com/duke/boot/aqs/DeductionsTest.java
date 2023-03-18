package com.duke.boot.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: dengkun11
 * @date: 2023/03/02
 * @description:
 */
public class DeductionsTest {

    private static SyncDeductions syncDeductions = new SyncDeductions();

    private static Integer getNo(){
        Integer no = syncDeductions.getNo();
        if(null == no){
            System.out.println("今日已达到最多客流量");
            return null;
        }
        System.out.println("no="+no);
        return no;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for(int i = 0;i<1000000;i++) {
            FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return getNo();
                }
            });
            Thread thread = new Thread(task);
            thread.start();
            Integer no = task.get();
            if(no == null){
                break;
            }
        }
    }
}
