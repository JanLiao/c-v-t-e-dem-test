package tmp;

import java.util.ArrayList;
import java.util.List;

/** 
* @author: jan 
* @date: 2018年6月19日 上午12:55:30 
*/
public class BreakTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int flag = 0;
		list.add(0);list.add(1);list.add(2);list.add(3);list.add(4);
		for(int s :list) {
			if(flag == 0) {
				if(s == 1) {
					System.out.println(666);
					break;
				}else {
					System.out.println("ss = " + s);
				}
			}else {
				System.out.println("s = " + s);
			}
		}
		
		String st = "OD0064EY".substring(0, 2);
		System.out.println(st);
	}
	
}
