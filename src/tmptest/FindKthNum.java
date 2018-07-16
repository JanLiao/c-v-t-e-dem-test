package tmptest;

import java.util.LinkedList;
import java.util.Queue;

public class FindKthNum {
	
	public static int findKthNum(int k) {
		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue5 = new LinkedList<Integer>();
		Queue<Integer> queue7 = new LinkedList<Integer>();
		queue3.offer(1);
		int tmp = 1;
		for(int i = 0; i <= k; i++) {
			int val3 = queue3.size() > 0 ? queue3.peek():Integer.MAX_VALUE;
			int val5 = queue5.size() > 0 ? queue5.peek():Integer.MAX_VALUE;
			int val7 = queue7.size() > 0 ? queue7.peek():Integer.MAX_VALUE;
		}
	}
	
	public static int findKthNumNormal(int k) {
		
	}

	public static void main(String[] args) {
		int num = findKthNum(200);
		int num1 = findKthNumNormal(200);
	}
}
