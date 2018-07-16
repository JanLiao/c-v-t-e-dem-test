package util;
/** 
* @author: jan 
* @date: 2018年4月21日 下午9:09:15 
*/
public class ImgPath {

	public static void main(String[] args) {
		String path = "C:/Users/CVTE/Desktop/mm/";
		String imgPath = "";
		for(int i = 0; i <= 50; i++) {
			imgPath = imgPath + path + i + ".jpg,";
		}
		System.out.println(imgPath);
	}
	
}
