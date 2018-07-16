package util;
/** 
* @author: jan 
* @date: 2018年4月13日 上午11:17:41 
*/
public class SplitTest {

	public static void main(String[] args) {
		String  s = "50%";
		System.out.println(s.split("%")[0]);
		
		String s1 = "1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
		System.out.println(s1.split(",").length);
		
		String s2 = "3232_L.jpg";
		String[] str = s2.split("___");
		System.out.println(str[0]);
	}
}
