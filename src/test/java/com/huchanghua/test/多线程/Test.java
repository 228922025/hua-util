package com.huchanghua.test.多线程;

/**
 * @author huchanghua
 * @create 2017-12-24-下午4:39
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread1 t1 = new Thread1("线程A");
        Thread1 t2 = new Thread1("线程B");
        t1.start();
        t2.start();
        System.out.println(t1.getId());
        System.out.println(t2.getId());

        Thread2 my = new Thread2();
        new Thread(my, "C").start();//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常
        new Thread(my, "D").start();
        new Thread(my, "E").start();


    }

    @org.junit.Test
    public void test2(){


    }
}
