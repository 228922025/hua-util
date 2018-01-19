package com.huchanghua.mian;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author huchanghua
 * @create 2017-12-23-下午8:06
 */
public class ScreenshotImage {

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        try {
            Robot bot = new Robot();
            bot.mouseMove(0, 0);
            bot.delay(200);
            BufferedImage bufferedImage = bot.createScreenCapture(new Rectangle(800, 600));
            System.out.println(bufferedImage.toString());

            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();


            // 截图保存的路径
            File screenFile = new File("c:/image");
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
