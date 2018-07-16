package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

/** 
* @author: jan 
* @date: 2018年5月4日 下午10:33:58 
*/
public class ImageDemo {
	public static void main(String[] args) throws Exception{  
        // TODO Auto-generated method stub  
        /* 
         * 待处理的图片 
         * */  
        File dir = new File("C:/Users/CVTE/Desktop/mm/");  
        /* 
         * 列出目录中的图片，得到数组 
         * */  
        File[] files = dir.listFiles();
        int k = 1;
        /* 
         * 遍历数组 
         * */  
        /* 
         * 定义一个数组，存放RGB值 
         * */  
        int[] rgb = new int[3];  
        /* 
         * byte转换BuffereImage 
         * */  
        BufferedImage bImage = null;  
        bImage = ImageIO.read(files[k]);  
          
        int width = bImage.getWidth();  
        int height = bImage.getHeight();  
        int minx = bImage.getMinTileX();  
        int miny = bImage.getMinTileY();  
        System.out.println("正在处理..."+files[k].getName());  
          
        /* 
         * 遍历像素点，判断是否更换颜色 
         * */  
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
                /* 
                 * 换色 
                 * */  
                int pixel = bImage.getRGB(i, j);  
                rgb[0] = (pixel & 0xff0000) >>16;  
                rgb[1] = (pixel & 0xff00) >>8;  
                rgb[2] = (pixel & 0xff) ;  
                  //System.out.println(rgb[0] + "," + rgb[1] + "," + rgb[2]);
//                if (rgb[0]<230&&rgb[0]>100&& rgb[1]<230&&rgb[1]>100 && rgb[2]<230&&rgb[2]>100) {  
//                    bImage.setRGB(i, j, 0xffffff);  
//                }  
                if(((255-rgb[0])>=225) && ((255-rgb[1])>=225) && ((255-rgb[2])>=225)){//去除黑色背景——dlgcy；

                    //rgb = (pixel & 0x00ffffff);
                	bImage.setRGB(i, j, 0xffffff);

                }

                
            }  
        }  
        System.out.println("\t处理完毕："+files[k].getName());  
        System.out.println();  
        /* 
         * 输出 
         * */  
        FileOutputStream ops;  
        try {  
            ops = new FileOutputStream(new File("C:/Users/CVTE/Desktop/mm/000.jpg"));  
            ImageIO.write(bImage, "jpg", ops);  
            ops.flush();  
            ops.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  