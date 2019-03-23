package sw_expert_academy;

import java.util.HashMap;
import java.util.Scanner;

public class N_1259 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[2*N][2*N];
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for (int i = 0; i < N; i++) {
				hm.put(sc.nextInt(), sc.nextInt());
			}
			
			HashMap<Integer, Integer> test = new HashMap<Integer, Integer>(); // 임시저장
			test.putAll(hm);
			int max = Integer.MIN_VALUE;
			int arr_Index = 0;
			int max_Index= 0;
			for (int i : hm.keySet()) {
				int count = 0;
				int value = test.get(i);
				arr[arr_Index][0] = i;
				arr[arr_Index][1] = value;
				test.remove(i);
				int j=2;
				while (test.containsKey(value)) {
					int temp = test.get(value);
					arr[arr_Index][j] = value;
					arr[arr_Index][j+1] = temp;
					test.remove(value);
					value = temp;
					count++;
					j += 2;
				}
				if(max<count) {
					max = count;
					max_Index = arr_Index;
				}
				arr_Index++;
				test.putAll(hm);
			}
			
			System.out.print("#"+test_case+" ");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[max_Index][i]+" ");
			}
			System.out.println();
		}
	}

}
