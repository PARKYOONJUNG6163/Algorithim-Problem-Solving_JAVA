package SWExpertAcademy;

import java.util.Scanner;

public class N_1217 {
	static int num = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int TN = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int count = 0;
			num = 1;
			Square(count, N, M);
			System.out.println("#"+TN+" "+num);
		}
	}
	
	public static void Square(int count, int N, int M) {
		if(count == M) return;
		count++;
		num *= N;
		Square(count, N, M);
	}

}
