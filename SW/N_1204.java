package SWExpertAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class N_1204 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			HashMap<Integer, Integer> test = new HashMap<Integer, Integer>(); // 임시저장
			int TN = sc.nextInt();
			for(int i=0;i<1000;i++) {
				int num = sc.nextInt();
				if(test.containsKey(num)) {
					test.put(num, test.get(num)+1);
				}else {
					test.put(num, 1);
				}
			}
			
			List<HashMap.Entry<Integer, Integer>> list = new ArrayList<>(test.entrySet());
			Collections.sort(list, new Comparator<HashMap.Entry<Integer, Integer>>() {
		        public int compare(HashMap.Entry<Integer, Integer> o1,
		                HashMap.Entry<Integer, Integer> o2) {
		        	int com = o2.getValue().compareTo(o1.getValue());
		        	if(com == 0) {
		        		 return o2.getKey().compareTo(o1.getKey());
		        	}else {
		        		 return com;
		        	}
		        }
		    });
			
			
			System.out.println("#"+TN+" "+list.get(0).getKey());
		}
}
}
