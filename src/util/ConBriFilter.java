package util;
import java.awt.Color;
/** 
* @author: jan 
* @date: 2018年6月5日 上午1:13:19 
*/
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;  
  
public class ConBriFilter {  
  
    private static float contrast = 5.0f; // default value;  
    private static float brightness = 3.5f; // default value;  
      
    public ConBriFilter() {
        // do stuff here if you need......  
    }  
    
    public static void main(String[] args) {
    	BufferedImage bi=file2img("C:\\Users\\CVTE\\Desktop\\新建文件夹 (2)\\王美娜_20170718101028786.jpg");  //读取图片
    	BufferedImage dest = filter(bi);
    	img2file(dest,"jpg","C:\\Users\\CVTE\\Desktop\\新建文件夹 (2)\\test1.jpg");  //生成图片
    }
    
  //读取图片
    public static BufferedImage file2img(String imgpath) {
        try {
            BufferedImage bufferedImage=ImageIO.read(new File(imgpath));
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      
    public static BufferedImage filter(BufferedImage src) {  
        int width = src.getWidth();  
        int height = src.getHeight();
        BufferedImage dest=new BufferedImage(src.getWidth(), src.getHeight(),BufferedImage.TYPE_INT_RGB);
        int[] inPixels = new int[width*height];  
        int[] outPixels = new int[width*height];  
        src.getRGB( 0, 0, width, height, inPixels, 0, width );  
          
        // calculate RED, GREEN, BLUE means of pixel  
        int index = 0;  
        int[] rgbmeans = new int[3];  
        double redSum = 0, greenSum = 0, blueSum = 0;  
        double total = height * width;  
        for(int row=0; row<height; row++) {  
            int ta = 0, tr = 0, tg = 0, tb = 0;  
            for(int col=0; col<width; col++) {  
                index = row * width + col;  
                ta = (inPixels[index] >> 24) & 0xff;  
                tr = (inPixels[index] >> 16) & 0xff;  
                tg = (inPixels[index] >> 8) & 0xff;  
                tb = inPixels[index] & 0xff;  
                redSum += tr;  
                greenSum += tg;  
                blueSum +=tb;  
            }  
        }  
          
        rgbmeans[0] = (int)(redSum / total);  
        rgbmeans[1] = (int)(greenSum / total);  
        rgbmeans[2] = (int)(blueSum / total);  
          
        // adjust contrast and brightness algorithm, here  
        for(int row=0; row<height; row++) {  
            int ta = 0, tr = 0, tg = 0, tb = 0;  
            for(int col=0; col<width; col++) {  
                index = row * width + col;  
                ta = (inPixels[index] >> 24) & 0xff;  
                tr = (inPixels[index] >> 16) & 0xff;  
                tg = (inPixels[index] >> 8) & 0xff;  
                tb = inPixels[index] & 0xff;  
                  
                // remove means  
                tr -=rgbmeans[0];  
                tg -=rgbmeans[1];  
                tb -=rgbmeans[2];  
                  
                // adjust contrast now !!!  
                tr = (int)(tr * getContrast());  
                tg = (int)(tg * getContrast());  
                tb = (int)(tb * getContrast());  
                  
                // adjust brightness  
                tr += (int)(rgbmeans[0] * getBrightness());  
                tg += (int)(rgbmeans[1] * getBrightness());  
                tb += (int)(rgbmeans[2] * getBrightness());  
                outPixels[index] = (ta << 24) | (clamp(tr) << 16) | (clamp(tg) << 8) | clamp(tb);  
//                Color color = new Color((clamp(tr)),(clamp(tg)),clamp(tb));
//                int x=color.getRGB();
//                dest.setRGB(col, row, x);
            }
        }
        dest.setRGB(0, 0, width, height, outPixels, 0, width);
        return dest;  
    }
      
    public static int clamp(int value) {  
        return value > 255 ? 255 :(value < 0 ? 0 : value);  
    }  
  
    public static float getContrast() {  
        return contrast;  
    }  
  
    public void setContrast(float contrast) {  
        this.contrast = contrast;  
    }  
  
    public static float getBrightness() {  
        return brightness;  
    }  
  
    public void setBrightness(float brightness) {  
        this.brightness = brightness;  
    }  
    
  //保存图片,extent为格式，"jpg"、"png"等
    public static void img2file(BufferedImage img,String extent,String newfile) {
        try {
            ImageIO.write(img, extent, new File(newfile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
}  
