package SWExpertAcademy;

import java.util.Scanner;

public class N_2072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			for(int i=0;i<10;i++) {
				int num = sc.nextInt();
				if(num%2 == 1) result += num;
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	}


