package util;

/** 
* @author: jan 
* @date: 2018年5月18日 上午12:55:12 
*/
public class Test {

	
	public static void main(String[] args) {
		String s = "";
		String path = s;
		path = path.split(":")[0] + "." + path.split(":")[1];
		path = path.replace('/', '.');
		s = "/data/" + path;
		System.out.println(s);
	}
}
