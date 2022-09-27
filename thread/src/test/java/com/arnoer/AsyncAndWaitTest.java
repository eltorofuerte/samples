package com.arnoer;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 开启线程执行任务的几种方式
 *
 * @author Arnoer
 * @since 2022/9/26 16:52
 */
public class AsyncAndWaitTest {

    @Test
    public void testThread() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "========>正在执行");

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "========>正在执行");
            }
        };
        thread.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "========>正在执行");
        }).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "========>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });
        String s = submit.get();
        System.out.println(s);

        // 关闭线程池
        executorService.shutdown();
    }

    @Test
    public void beginThread() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "主线程开始");
        new Worker().begin();
        System.out.println(Thread.currentThread().getName() + "主线程结束");
        Thread.sleep(4 * 1000L);
    }

    static class Worker implements Runnable {

        /**
         * 当前对象实现了runnable，作为一个任务，传入Thread，开启一个线程
         */
        public void begin() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "===========>开始执行Worker#run()");
            try {
                Thread.sleep(3 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "===========>结束执行Worker#run()");
        }
    }

}
