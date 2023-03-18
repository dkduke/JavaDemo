package com.duke.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.duke.boot.annotation.PermissionsAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author: dengkun11
 * @date: 2022/08/11
 * @description:
 */
@RestController
@RequestMapping(value = "/permission")
public class TestController {

    @Autowired
    private ThreadPoolExecutor executor;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @PermissionsAnnotation()
    public JSONObject getGroupList(@RequestBody JSONObject request) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

    /**
     * URL： http://127.0.0.1:8087/permission/thread
     * 线程池源码详解：https://zhuanlan.zhihu.com/p/34405230
     * @return
     */
    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public String threadPoolTest() {
        try {
            //1、无返回结果的异步任务
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("无返回结果的异步任务");
                }
            });

            //2、有返回结果的异步任务
            Future<List<String>> future = executor.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    List<String> result = new ArrayList<>();
                    result.add("duke");
                    return result;
                }
            });
            List<String> results = future.get();
            System.out.println("有返回结果的异步任务：" + results);


            return "ok";
        } catch (Exception e) {
            return "error";
        }
    }

}
