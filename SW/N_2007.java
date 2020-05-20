package SWExpertAcademy;

import java.util.Scanner;

public class N_2007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			int result =0 ;
			for (int i = 1; i < 10; i++) {
				String temp1 = str.substring(0,i);
				String temp2 = str.substring(i,i*2);
				if(temp1.equals(temp2)) {
					result = i;
                    break;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}

}

