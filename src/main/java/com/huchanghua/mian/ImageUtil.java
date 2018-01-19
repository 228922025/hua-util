package com.huchanghua.mian;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * @author huchanghua
 * @create 2017-12-18-下午9:42
 */
public class ImageUtil {

    public static void main(String[] args) throws IOException {

        long starttime = System.currentTimeMillis();
        BufferedImage bi = (BufferedImage)ImageIO.read(new File("/users/huchanghua/documents/image/1514033439187.png"));
        List<Object> list = new ArrayList<Object>();

        //获取图像的宽度和高度
        int width = bi.getWidth();
        int height = bi.getHeight();

        //扫描图片
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){//行扫描
                int dip = bi.getRGB(j, i);
//=============volcano add 20120414========start=========//
                int p = dip;
//                int red = 0xff & (p >> 16);
//                int green = 0xff & (p >> 8);
//                int blue = 0xff & p;
                int red = (p & 0xff0000) >> 16;
                int green = (p & 0xff00) >> 8;
                int blue = (p & 0xff) ;
                // if(i == 0)
                // System.out.println("i:" + i + " red:" + red + " green:"
                // + green + " blue:" + blue);

                /*红色*/
                if (red > 250 && green < 5 && blue < 5) {
                    Object obj = new Object();
                    list.add(obj);
                    System.out.print("R");
                }else {
                    System.out.print("-");//用0比用空格好，用以看清有多少位像素
                }
//=============volcano add 20120414========end =========//

            }
            System.out.println();//换行
        }

        long endtime = System.currentTimeMillis();
        System.out.println("扫描耗时: " + (endtime - starttime) + "毫秒");

    }
}
