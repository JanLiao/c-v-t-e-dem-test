package util;

import cn.easyproject.easyocr.EasyOCR;

/** 
* @author: jan 
* @date: 2018年6月15日 下午4:02:10 
*/
public class OCRDemo {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		EasyOCR e = new EasyOCR();
		System.out.println(e.discern("C:\\Program Files (x86)\\Tesseract-OCR\\8.png"));
		System.out.println("time = " + (System.currentTimeMillis() - start));
	}
	
}
