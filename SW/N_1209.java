package SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class N_1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int TN = sc.nextInt();
			int[][] arr= new int[100][100];
			int[] row_sum = new int[100]; // 행
			int[] column_sum= new int[100]; // 열
			int[] diagonal_sum = new int[2];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					int temp =  sc.nextInt();
					arr[i][j] = temp;
					row_sum[i] += temp; // 행의 합
					if(i==j) diagonal_sum[0] += temp;
				}
			}
			
			for(int i=0;i<100;i++) { // 열의 합
				for(int j=0;j<100;j++) {
					column_sum[i] += arr[j][i];
				}
			}
			
			int x = 0;
			int y= 99;
			while(y >= 0) {
				diagonal_sum[1] += arr[x++][y--];
			}
			
			int max = Math.max(diagonal_sum[0], diagonal_sum[1]);
			Arrays.sort(row_sum);
			Arrays.sort(column_sum);
			int m = Math.max(row_sum[99], column_sum[99]);
			max = Math.max(max, m);
			
			System.out.println("#"+TN+" "+max);
		}
	}
}
