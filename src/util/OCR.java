package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

/** 
* @author: jan 
* @date: 2018年6月14日 上午12:33:28 
*/
public class OCR {
    /**
     *
     * @param srImage 图片路径
     * @param ZH_CN 是否使用中文训练库,true-是
     * @return 识别结果
     */
    public static String FindOCR(String srImage, boolean ZH_CN) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println("start");
            String path = "C:\\Program Files (x86)\\Tesseract-OCR\\tessdata".replace('\\', '/');
            double start=System.currentTimeMillis();
            File imageFile = new File(srImage);
            if (!imageFile.exists()) {
                return "图片不存在";
            }
            System.out.println("time = " + format.format(imageFile.lastModified()));
            BufferedImage textImage = ImageIO.read(imageFile);
            //textImage.
            //Tesseract instance=Tesseract.getInstance();
            int endxs = (int) (textImage.getWidth()*0.3);
            int endys = (int) (textImage.getHeight()*0.3);
            int endxe = (int) (textImage.getWidth()*0.4);
            int endye = (int) (textImage.getHeight()*0.6);
//            textImage = ImageHelper.convertImageToGrayscale(
//            		ImageHelper.getSubImage(textImage, endxs, endys, endxe, endye));
//            textImage = ImageHelper.getSubImage(textImage, endxs, endys, endxe, endye);
//            try {
//                ImageIO.write(textImage, "jpg", new File("C:\\Users\\CVTE\\Desktop\\手持demo-data\\data\\image\\2018-04-10\\3.png"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            int endX = (int) (textImage.getWidth()*1.0);
            int endY = (int) (textImage.getHeight()*1.0);
            textImage = ImageHelper.getScaledInstance(textImage, endX, endY);
            ITesseract instance = new Tesseract();
            instance.setDatapath(path);//设置训练库
//            if (ZH_CN)
//                instance.setLanguage("chi_sim");//中文识别
            String result = null;
            result = instance.doOCR(textImage);
            double end=System.currentTimeMillis();
            System.out.println("耗时"+(end-start)/1000+" s");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "发生未知错误";
        }
    }
    public static void main(String[] args) throws Exception {
        String result=FindOCR("C:\\Users\\CVTE\\Desktop\\手持demo-data\\data\\image\\2018-04-10\\OD0071EY.JPG",true);
        System.out.println(result);
    }
}
