package BaekJoon;

import java.util.Scanner;

public class N_2798 {
//	static int M;
//	static int[] arr;
//	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				for (int k = j+1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if(sum <= M) {
						result = Math.max(sum, result);						
					}
				}
			}
		}

		System.out.println(result);
	}
	
//	public static void recur(int index,int count,int sum) {
//		if(count >= 3 && sum <= M) {
//			result = Math.max(sum, result);
//			return;
//		}
//		
//		for (int i = index; i < arr.length; i++) {
//          recur(i+1, count+1, sum + arr[i]);
//		}
//	}
}
