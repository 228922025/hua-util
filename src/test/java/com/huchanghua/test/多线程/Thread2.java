package com.huchanghua.test.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * 继承runnable，资源能共享
 * @author huchanghua
 * @create 2017-12-26-上午10:20
 */
public class Thread2 implements Runnable{
    private int count=15;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
