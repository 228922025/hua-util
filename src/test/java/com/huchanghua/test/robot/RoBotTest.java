package com.huchanghua.test.robot;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author huchanghua
 * @create 2017-12-19-下午12:43
 */
public class RoBotTest {

    /**
     * 鼠标单击（左击）,要双击就连续调用
     *
     * @param r
     * @param x
     *            x坐标位置
     * @param y
     *            y坐标位置
     * @param delay
     *            该操作后的延迟时间
     */
    public static void clickLMouse(Robot r, int x, int y, int delay) {
        r.mouseMove(x, y);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.delay(10);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.delay(delay);

    }

    /**
     * 鼠标右击,要双击就连续调用
     *
     * @param r
     * @param x
     *            x坐标位置
     * @param y
     *            y坐标位置
     * @param delay
     *            该操作后的延迟时间
     */
    public static void clickRMouse(Robot r, int x, int y, int delay) {
        r.mouseMove(x, y);
        r.mousePress(InputEvent.BUTTON3_MASK);
        r.delay(10);
        r.mouseRelease(InputEvent.BUTTON3_MASK);
        r.delay(delay);

    }

    /**
     * 键盘输入（一次只能输入一个字符）
     *
     * @param r
     * @param ks
     *            键盘输入的字符数组
     * @param delay
     *            输入一个键后的延迟时间
     */
    public static void pressKeys(Robot r, int[] ks, int delay) {
        for (int i = 0; i < ks.length; i++) {
            r.keyPress(ks[i]);
            r.delay(10);
            r.keyRelease(ks[i]);
            r.delay(delay);
        }
    }

    /**
     * 复制
     *
     * @param r
     * @throws InterruptedException
     */
    void doCopy(Robot r) throws InterruptedException {
        Thread.sleep(3000);
        r.setAutoDelay(200);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_C);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_C);
    }

    /**
     * 粘贴
     *
     * @param r
     * @throws InterruptedException
     */
    void doParse(Robot r) throws InterruptedException {
        r.setAutoDelay(500);
        Thread.sleep(2000);
        r.mouseMove(300, 300);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
    }

    /**
     * 捕捉全屏慕
     *
     * @param r
     * @return
     */
    public Icon captureFullScreen(Robot r) {
        BufferedImage fullScreenImage = r.createScreenCapture(new Rectangle(
                Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }

    /**
     * 捕捉屏幕的一个矫形区域
     *
     * @param r
     * @param x
     *            x坐标位置
     * @param y
     *            y坐标位置
     * @param width
     *            矩形的宽
     * @param height
     *            矩形的高
     * @return
     */
    public Icon capturePartScreen(Robot r, int x, int y, int width, int height) {
        r.mouseMove(x, y);
        BufferedImage fullScreenImage = r.createScreenCapture(new Rectangle(
                width, height));
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }

    @Test
    public void test1(){
        long starttime = System.currentTimeMillis();
        try {
            Robot bot = new Robot();
            bot.mouseMove(0, 0);
//            bot.delay(200);
            BufferedImage bufferedImage = bot.createScreenCapture(new Rectangle(800, 600));
            System.out.println(bufferedImage.toString());

            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){//行扫描
                    int dip = bufferedImage.getRGB(j, i);
//=============volcano add 20120414========start=========//
                    int p=dip;
                    int red = 0xff & (p >> 16);
                    int green = 0xff & (p >> 8);
                    int blue = 0xff & p;
                    // if(i == 0)
                    // System.out.println("i:" + i + " red:" + red + " green:"
                    // + green + " blue:" + blue);

                    if (red < 180 && green < 180 && blue < 180) {
                        // System.out.println(i+".....get num");
//                        System.out.print("♦");
                    }
//                    else    System.out.print("0");//用0比用空格好，用以看清有多少位像素
//=============volcano add 20120414========end =========//

                }
//                System.out.println();//换行
            }

            // 截图保存的路径
            File screenFile = new File("/users/huchanghua/documents/image");
            // 如果路径不存在,则创建
            if (!screenFile.getParentFile().exists()) {
                screenFile.getParentFile().mkdirs();
            }
            //判断文件是否存在，不存在就创建文件
            if(!screenFile.exists()&& !screenFile .isDirectory()) {
                screenFile.mkdir();
            }

            File f = new File(screenFile, System.currentTimeMillis() + ".png");
            try {
                ImageIO.write(bufferedImage, "png", f);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }

        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime);

    }
}
