package SWExpertAcademy;

import java.util.Scanner;

public class N_4408{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[201];
			for (int i = 0; i < N; i++) {
				int nowR = sc.nextInt();
				int returnR = sc.nextInt();
				boolean max = false;
				if(nowR > returnR) {
					max = true; // ū�� -> ������
				}
				int index = nowR/2; // ¦��
				int end_index = returnR/2; // ¦��
				if(nowR%2 != 0) { // Ȧ��
					 index += 1;
				}
				
				if(returnR%2 != 0) { // Ȧ��
					 end_index += 1;
				}
				
				if(max) { // ū�� -> ������
					while(true) {
						if(index < end_index) break;
						arr[index--]++;
					}
				}else { // ������ -> ū��
					while(true) {
						if(index > end_index) break;
						arr[index++]++;
					}
				}
			}
			int result = Integer.MIN_VALUE;
			for (int i = 1; i < arr.length; i++) {
				result = Math.max(result, arr[i]);
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
