package tmp;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

/** 
* @author: jan 
* @date: 2018年6月15日 下午10:23:45 
*/
public class ImageFlip1 {

	private static BufferedImage flipImage(BufferedImage bufferedimage) {
		int imageWidth = bufferedimage.getWidth();
		int imageHeight = bufferedimage.getHeight();

		BufferedImage img = null;
		Graphics2D graphics2d = null;

		try {
		(graphics2d = (img = new BufferedImage(imageWidth, imageHeight, bufferedimage
		.getColorModel().getTransparency())).createGraphics())
		.drawImage(bufferedimage, 0, 0, imageWidth, imageHeight, imageWidth, 0, 0, imageHeight, null);
		} catch (Exception e) {
		throw e;
		} finally {
		graphics2d.dispose();
		}

		return img;
		}
	
	public static void main(String[] args) throws IOException {
//		File f = new File("E:\\BaiduNetdiskDownload\\眼底照\\323\\R.jpg");
//		BufferedImage imgIO = null;
//		try {
//			imgIO = ImageIO.read(f);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		BufferedImage img = flipImage(imgIO);
//		
//		String savePath = "C:/Users/CVTE/Desktop/002.jpg";
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream(new File(savePath));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		ImageIO.write(img, "jpg", fos);
//		fos.flush();
//		fos.close();
				
		int n = 1;
		DecimalFormat df = new DecimalFormat("0000");
		String s = df.format(n);
		System.out.println(s);
		
		//青光眼
		String glaucoma = "E:/第一批/青光眼图片";
		String glaucomapath = "E:/第一批处理/青光眼图片";
		int num1 = 1;
		File[] files = new File(glaucoma).listFiles();
		//System.out.println(files.length);
		for(File tmp : files) {
			if(tmp.isDirectory()) {
				File[] fs = new File(glaucoma + "/" + tmp.getName()).listFiles();
				//System.out.println("tmp len = " + fs.length);
				for(File tp : fs) {
					//System.out.println(tp.getName());
					if(tp.getName().equals("R.jpg") || tp.getName().equals("RR.jpg")) {  //右眼翻转  边上涂掉
						//涂掉
						//ImageCut.imgCut(ImageIO.read(new File("C:/Users/CVTE/Desktop/002.jpg")), glaucomapath + "/g" + df.format(num1) + ".jpg");
						String path  = glaucoma + "/" + tmp.getName() + "/" + tp.getName();
						//BufferedImage tmpIO = ImageIO.read(new File("C:/Users/CVTE/Desktop/002.jpg"));
						//tmpIO = ImageIO.read(new File(path));
						BufferedImage iIO = 
								ImageCut.imgCut(ImageIO.read(new File(path)), glaucomapath + "/g" + df.format(num1) + ".jpg");
						//翻转
						BufferedImage tpimg = flipImage(iIO);
						//生成图片
						//writePic(tpimg, glaucomapath + "/g" + df.format(num1) + ".jpg");
						System.out.println("orign path = " + path + "=" + num1);
						//writePic(tpimg, "E:\\第一批处理\\青光眼图片\\g" + df.format(num1) + ".jpg");
						RepaintUtil.writePic(tpimg, "E:\\第一批处理2\\青光眼图片\\g" + df.format(num1) + ".jpg");
						num1++;
						//System.gc();
					}
					else{  //左眼涂掉
						String path  = glaucoma + "/" + tmp.getName() + "/" + tp.getName();
						System.out.println("orign path = " + path + "=" + num1);
						//涂掉
						//BufferedImage tmpIO1 = ImageIO.read(new File("C:/Users/CVTE/Desktop/002.jpg"));
						//tmpIO1 = ImageIO.read(new File(path));
						BufferedImage iIO = ImageCut.imgCut(ImageIO.read(new File(path)), glaucomapath + "/g" + df.format(num1) + ".jpg");
						//writePic(iIO, "E:\\第一批处理\\青光眼图片\\g" + df.format(num1) + ".jpg");
						RepaintUtil.writePic(iIO, "E:\\第一批处理2\\青光眼图片\\g" + df.format(num1) + ".jpg");
						num1++;
						//System.gc();
					}
				}
			}
		}
		
		//非青光眼
		String norm = "E:/第一批/非青光眼图片";
		String normpath = "E:/第一批处理/非青光眼图片";
		int num2 = 1;
		File[] files1 = new File(norm).listFiles();
		for (File tmp : files1) {
			if (tmp.isDirectory()) {
				File[] fs = new File(norm + "/" + tmp.getName()).listFiles();
				for (File tp : fs) {
					if (tp.getName().equals("R.jpg") || tp.getName().equals("RR.jpg")) { // 右眼翻转 边上涂掉
						// 涂掉
						// ImageCut.imgCut(ImageIO.read(new File("C:/Users/CVTE/Desktop/002.jpg")),
						// glaucomapath + "/g" + df.format(num1) + ".jpg");
						String path = norm + "/" + tmp.getName() + "/" + tp.getName();
						BufferedImage iIO = ImageCut.imgCut(ImageIO.read(new File(path)),
								normpath + "/n" + df.format(num1) + ".jpg");
						// 翻转
						BufferedImage tpimg = flipImage(iIO);
						// 生成图片
						// writePic(tpimg, glaucomapath + "/g" + df.format(num1) + ".jpg");
						System.out.println("orign path = " + path + "=" + num2);
						//writePic(tpimg, "E:\\第一批处理\\非青光眼图片\\n" + df.format(num2) + ".jpg");
						RepaintUtil.writePic(tpimg, "E:\\第一批处理2\\非青光眼图片\\n" + df.format(num2) + ".jpg");
						num2++;
					} else { // 左眼涂掉
						String path = norm + "/" + tmp.getName() + "/" + tp.getName();
						System.out.println("orign path = " + path + "=" + num2);
						// 涂掉
						BufferedImage iIO = ImageCut.imgCut(ImageIO.read(new File(path)),
								glaucomapath + "/n" + df.format(num2) + ".jpg");
						//writePic(iIO, "E:\\第一批处理\\非青光眼图片\\n" + df.format(num2) + ".jpg");
						RepaintUtil.writePic(iIO, "E:\\第一批处理2\\非青光眼图片\\n" + df.format(num2) + ".jpg");
						num2++;
					}
				}
			}
		}
	}

	private static void writePic(BufferedImage tpimg, String savePath) throws IOException {
		//String savePath = "C:/Users/CVTE/Desktop/002.jpg";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(savePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageIO.write(tpimg, "jpg", fos);
		fos.flush();
		fos.close();
	}
	
}
