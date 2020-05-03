package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N_4366 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			String str2 = br.readLine();
			
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				int n = str.charAt(i) - 48;
				String temp = str.substring(0, i) + Math.abs(n-1) +str.substring(i+1);
				hs.add(Integer.parseInt(temp,2));
			}
			
			int answer = 0;
			fin : for (int i = 0; i < str2.length(); i++) {
					int n = str2.charAt(i) - 48;
					for (int j = 0; j < 3; j++) {
						if(n!=j) {						
							String temp = str2.substring(0, i) + j +str2.substring(i+1);
							int result = Integer.parseInt(temp,3);
							if(hs.contains(result)) {
								answer = result;
								break fin;
							}
						}
					}
			}
			System.out.println("#"+ test_case + " " + answer);
		}
	}

}
