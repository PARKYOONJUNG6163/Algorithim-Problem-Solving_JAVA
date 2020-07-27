package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class N_2143 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long T = Long.parseLong(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] arr1 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Long> list1 = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			long tmp = 0;
			for (int j = i; j < arr1.length; j++) {
				tmp += arr1[j];
				list1.add(tmp);
			}
		}
		
		List<Long> list2 = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			long tmp = 0;
			for (int j = i; j < arr2.length; j++) {
				tmp += arr2[j];
				list2.add(tmp);
			}
		}
		
		HashMap<Long,Integer> hm = new HashMap<>();
		for (long i : list1) {
			if(hm.containsKey(i)) {
				hm.put(i, hm.get(i)+1);
			}else {
				hm.put(i, 1);
			}
		}
		
		long answer = 0;
		for (long i : list2) {
			if(hm.containsKey(T-i)) {
				answer += hm.get(T-i);
			}
		}

		System.out.println(answer);
	}

}
