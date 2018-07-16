package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/** 
* @author: jan 
* @date: 2018年5月29日 下午4:08:37 
*/
public class ImageTest {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\CVTE\\Desktop\\test1\\7.jpg");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(fis.toString());
	}
	
}
