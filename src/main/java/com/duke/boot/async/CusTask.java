package com.duke.boot.async;

/**
 * @author: dengkun11
 * @date: 2022/11/14
 * @description: 自定义Task
 */
public class CusTask implements Runnable {

    private int taskId;
    private String taskName;

    public CusTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("run taskId=" + this.taskId + ", curThread=" + Thread.currentThread().getId());
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.taskId);
    }
}
