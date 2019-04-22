package SWExpertAcademy;

import java.util.Scanner;

public class N_1218 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int check = 1;
			int len = sc.nextInt();
			int[] arr = new int[8];
			sc.nextLine();
			String str = sc.next();
			for (int i = 0; i < len; i++) {
				String s = String.valueOf(str.charAt(i));
				switch (s) {
				case "{":
					arr[0]++;
					break;
				case "}":
					arr[1]++;
					break;
				case "[":
					arr[2]++;
					break;
				case "]":
					arr[3]++;
					break;
				case "(":
					arr[4]++;
					break;
				case ")":
					arr[5]++;
					break;
				case "<":
					arr[6]++;
					break;
				case ">":
					arr[7]++;
					break;
				}
			}
	
			if(arr[0] != arr[1] || arr[2] != arr[3] ||arr[4] != arr[5] || arr[6] != arr[7]) check = 0;
			System.out.println("#" + test_case + " " + check);
		}
	}

}
