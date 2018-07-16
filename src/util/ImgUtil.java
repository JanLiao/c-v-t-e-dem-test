package util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
/** 
* @author: jan 
* @date: 2018年5月16日 上午1:08:02 
*/
public class ImgUtil {
	
	/**
     * 将本地图片转换base64 的二进制 e:/123.jpg
     * @param imgPath
     * @return
     */
    public static String getImageBinary(String imgPath) {  
        File f = new File(imgPath.trim());  
        BufferedImage bi;  
        try {  
            bi = ImageIO.read(f);  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
            ImageIO.write(bi, "jpg" , baos);  //经测试转换的图片是格式这里就什么格式，否则会失真  
            byte[] bytes = baos.toByteArray();
            
            return javax.xml.bind.DatatypeConverter.printBase64Binary(bytes);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    
    /**
     * 将二进制转换为图片  
     * @param base64String base64转换后的
     * @param outPath 输出的地址
     */
    public static void base64StringToImage(String base64String,String outPath) {  
        try {  
        	Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(base64String);  

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
            BufferedImage bi1 = ImageIO.read(bais);  
            File file = new File(outPath);// 可以是jpg,png,gif格式  
            ImageIO.write(bi1, "jpg", file);// 不管输出什么格式图片，此处不需改动  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
    public static void main(String[] args) {
    	String s = getImageBinary("F:\\eclipse-workspace\\LabelDemo\\admin\\data\\C.Users.CVTE.Desktop.ss\\267\\L.jpg");
    	base64StringToImage(s, "F:\\eclipse-workspace\\LabelDemo\\admin\\data\\C.Users.CVTE.Desktop.ss\\267\\a.jpg");
    }
}
