package SWExpertAcademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_1228{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				list.add(n);
			}
			
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				char x = sc.next().charAt(0);
				int y = sc.nextInt();
				int s = sc.nextInt();
				for (int j = 0; j < s; j++) {
					int n = sc.nextInt();
					list.add(y+j, n);
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
