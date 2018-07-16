package test;

public class KNum {

	public static void main(String[] args) {
		int[] arr = new int[] {
				100, 3, 33, 98, 102, 23, 45
		};
		int k = Integer.MIN_VALUE;
		for(int i : arr) {
			if(i > k) {
				k = i;
			}
		}
		
		int[] arr1 = new int[k + 1];
		for(int i : arr) {
			arr1[i] = 1;
		}
		
		int kk = 0;
		for(int i = k; i >= 0; i--) {
			if(kk >= 3) {
				break;
			}else {
				if(arr1[i] == 1) {
					System.out.println(i);
					kk++;
				}
			}
		}
	}
}
