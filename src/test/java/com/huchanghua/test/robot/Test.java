package com.huchanghua.test.robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author huchanghua
 * @create 2017-12-19-上午10:31
 */
public class Test {

    @org.junit.Test
    public void test1(){
        try {
            Robot bot = new Robot();
            bot.setAutoDelay(500);  //设置每次输入延迟
            bot.mouseMove(1680, 1050);    //移动鼠标到指定坐标
            bot.mousePress(KeyEvent.BUTTON1_DOWN_MASK); //按下鼠标左键
            bot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);   //释放鼠标左键
        } catch (AWTException e) {
            e.printStackTrace();
        }


    }

    @org.junit.Test
    public void test2() throws AWTException, IOException {
        Robot bot = new Robot();
        //获取屏幕分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(d.toString());
        //以屏幕的尺寸创建个矩形
        Rectangle screenRect = new Rectangle(d);
        //截图（截取整个屏幕图片）
        BufferedImage bufferedImage = bot.createScreenCapture(screenRect);
        //保存截图
        File file = new File("screenRect.png");
        ImageIO.write(bufferedImage, "png", file);

    }
}
