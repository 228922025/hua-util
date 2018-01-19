package com.huchanghua.test.多线程;

/**
 * 继承Thread, 资源不能共享
 * @author huchanghua
 * @create 2017-12-26-上午10:05
 */
public class Thread1 extends Thread {
    private int count = 5;
    private String name;

    public Thread1 (String name){
        this.name = name;
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(name + " 运行 count=" + count--);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
