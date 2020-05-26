package BaekJoon;

import java.util.Scanner;

public class N_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] weight = new int[N];
		int[] height = new int[N];
		int[] count = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();	
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(weight[i] > weight[j] && height[i] > height[j]) {
					count[j]++;
				}else if(weight[i] < weight[j] && height[i] < height[j]) {
					count[i]++;
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i]+1 + " ");
		}
	}

}

