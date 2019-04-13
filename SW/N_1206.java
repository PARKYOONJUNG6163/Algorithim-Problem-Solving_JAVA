package SWExpertAcademy;

import java.util.Scanner;

public class N_1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int result = 0;
			int[][] arr = new int[255][N];
			for(int i=0;i<N;i++) {
				int temp = sc.nextInt();
				for(int j=0;j<temp;j++) {
					arr[j][i] = 1;
				}
			}
			
			for(int i = 2;i<N;i++) {
				for(int j=0;j<255;j++) {
					if(arr[j][i] == 1) {
						if(arr[j][i-1] == 0 && arr[j][i-2] == 0 && arr[j][i+1] == 0 && arr[j][i+2] == 0) {
							result++;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
