package tmp;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/** 
* @author: jan 
* @date: 2018年6月15日 下午10:23:45 
*/
public class ImageFlip2 {

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
	
	public static void thirdProcess() throws IOException {
		//翻转
		BufferedImage tpimg = flipImage(ImageIO.read(new File("C:\\Users\\CVTE\\Desktop\\HP打印\\sole\\22343_R.bmp")));
		
		File fileA = new File("C:/Users/CVTE/Desktop/HP打印/sole/22343.bmp");
		try {
			ImageIO.write(tpimg, "BMP", fileA);
		} catch (Exception s) {
		}
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
		
		
				
		//firstProcess();
		//secondProcess();
		thirdProcess();
		
	}
	
	public static void secondProcess() throws IOException {
		String path = "E:/第二批";
		String savepath = "E:/第二批处理";
		String filepath = "E:/第二批标注/user1/file/imgAllLabel.csv";
		
		List<String[]> list = ReadCSV.readCSV(filepath);
		System.out.println(list.size());
		for(String[] s : list) {
			String name = s[3].split("___")[1];
			String imgpath = path + "/" + name;
			if(strToObj(s[7], "shibei")) {
				BufferedImage iIO = 
						ImageCut.imgCut1(ImageIO.read(new File(imgpath)));
				//翻转
				BufferedImage tpimg = flipImage(iIO);
				//生成图片
				//writePic(tpimg, savepath + "/" + name);
				//writePic(tpimg, "E:\\第一批处理\\青光眼图片\\g" + df.format(num1) + ".jpg");
				RepaintUtil.writePic(tpimg, savepath + "/" + name);
			}else {
				BufferedImage iIO = 
						ImageCut.imgCut1(ImageIO.read(new File(imgpath)));
				//生成图片
				//writePic(iIO, savepath + "/" + name);
				//writePic(tpimg, "E:\\第一批处理\\青光眼图片\\g" + df.format(num1) + ".jpg");
				RepaintUtil.writePic(iIO, savepath + "/" + name);
			}
		}
	}
	
	public static void firstProcess() throws FileNotFoundException, IOException {
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
	}
	public static boolean strToObj(String label, String name) {
		JSONObject json = JSON.parseObject(label);
		JSONArray arr = json.getJSONArray("label_data");
		JSONObject obj = null;
		for (int i = 0; i < 3; i++) {
			JSONObject tmp = arr.getJSONObject(i);
			if (name.equals(tmp.getString("name"))) {
				obj = JSON.parseObject(tmp.getString("data"));
				break;
			}
		}
		
		double s = Double.parseDouble(obj.getString("left"));
		if(s > 265) {
			return true;
		}else {
			return false;
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
