package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class N_7701 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer,List<String>> hm = new HashMap<>();
			for (int i = 0; i < N; i++) {
				List<String> list;
				String str = br.readLine();
				if(hm.containsKey(str.length())) {
					list = hm.get(str.length());
					if(!list.contains(str)) {
						list.add(str);
					}
				}else {
					list = new ArrayList<>();
					list.add(str);
				}
				hm.put(str.length(), list);
			}
			
			System.out.println("#" + test_case);
			List<String> li;
			for (int key : hm.keySet()) {
				li = hm.get(key);
				Collections.sort(li);
				for (String s : li) {
					System.out.println(s);
				}
			}
		}
	}
	
}
