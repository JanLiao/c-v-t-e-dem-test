package util;
/** 
* @author: jan 
* @date: 2018年6月1日 上午11:29:22 
*/
public class PathTest {

	public static void main(String[] args) {
		String s = "1___112_R.jpg";
		String[] str = s.split("_");
		System.out.println(str.length);
		for(int i = 0 ; i< str.length; i++) {
			if("".equals(str[i])) {
				System.out.println(0);
			}
			//System.out.println(str[i]);
		}
		
		String[] ss = s.split("___");
		System.out.println(ss[0] + "=" + ss[1]);
		String sm = "2___1001_L.jpg";
		String[] sk = sm.split("___");
		System.out.println(sk[0]);
	}
	
}
