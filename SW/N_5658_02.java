package SWExpertAcademy;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class N_5658_02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N/4; i++) {
				for (int j = 0; j < str.length(); j+=N/4) {
					int temp = Integer.parseInt(str.substring(j,j+N/4), 16);
					if(!list.contains(temp)) list.add(temp);
				}
				char end = str.charAt(str.length()-1);
				str = str.substring(0,str.length()-1);
				str = end + str;
			}
			Collections.sort(list);
			
			System.out.println("#"+ test_case + " " + list.get(list.size()-K));	
		}
	}

}
