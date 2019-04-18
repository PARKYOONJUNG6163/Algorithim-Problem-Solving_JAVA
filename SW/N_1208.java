package SWExpertAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class N_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<100;i++) {
				int height = sc.nextInt();
				list.add(height);
			}
			
			for(int i=0;i<N;i++) {
				Collections.sort(list);
				list.set(list.size()-1, list.get(list.size()-1)-1);
				list.set(0,list.get(0)+1);
			}
			
			Collections.sort(list);
			System.out.println("#"+test_case+" "+(list.get(list.size()-1) - list.get(0)));
		}
	}

}
