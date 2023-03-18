package com.duke.boot.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.jd.fastjson.JSON;

import java.util.concurrent.*;

/**
 * @author: dengkun11
 * @date: 2022/11/28
 * @description: 在使用线程池等会池化复用线程的执行组件情况下，transmittable-thread-local(简称TTL)提供ThreadLocal值的传递功能，解决异步执行时上下文传递的问题。
 *
 * TTL主要解决了：
 * 1、透传上下文信息，run方法调用结束时自动restore上下文信息
 * 2、线程池使用CallerRunsPolicy时，避免了手动回收上下文信息会将主线程的上下文信息清空
 */
public class TransmittableThreadLocalDemo {

    static TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = new ThreadPoolExecutor(
                1,
                4,
                6,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        //用TtlExecutors装饰线程池
        executor = TtlExecutors.getTtlExecutorService(executor);

        transmittableThreadLocal.set("i am a transmittable parent");
        executor.execute(() -> {
            System.out.println(transmittableThreadLocal.get());
            //子线程设置新的值
            transmittableThreadLocal.set("i am a old transmittable parent");
        });

        System.out.println(transmittableThreadLocal.get());

        TimeUnit.SECONDS.sleep(1);

        //主线程设置新的值
        transmittableThreadLocal.set("i am a new transmittable parent");
        executor.execute((Runnable) () -> {
            System.out.println(transmittableThreadLocal.get());
            System.out.println(JSON.toJSONString(transmittableThreadLocal));
        });

        executor.shutdown();

        /**
         执行代码后发现，使用TTL和TtlExecutors.getTtlExecutorService(executorService)装饰线程池之后，
         在每次调用任务的时，都会将当前的主线程的TTL数据copy到子线程里面，执行完成后，再清除掉。同时子线程里面的修改回到主线程时其实并没有生效。
         这样可以保证每次任务执行的时候都是互不干涉的
         */
    }
}
