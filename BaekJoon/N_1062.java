package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class N_1062 {
	public static int answer;
	public static int[] selected;
	public static int K;
	public static String[] word;
	public static int total;
	public static List<Integer> arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// a n t i c
		HashSet<Integer> hs = new HashSet<>();
		word = new String[N];
		total = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			word[i] = str.substring(4, str.length()-4);
			for (int j = 0; j < word[i].length(); j++) {
				total++;
				int n = word[i].charAt(j) - 97;
				if(n == 0 || n == 2 || n == 8 || n == 13 || n == 19) continue;
				hs.add(n);
			}
		}
		arr = new ArrayList<>(hs);
		answer = 0;
		if(arr.size() == 0 || arr.size() <= K-5) answer = N;
		else if(K >= 5) {
			selected = new int[K-5];
			comb(0,0);
		}
		System.out.println(answer);
	}
	
	public static void comb(int idx,int cnt) {
		if(cnt == K-5) { 
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < selected.length; i++) {
				temp.add(selected[i]);
			}
			
			int result = 0;
			for (int j = 0; j < word.length; j++) {
				int count = 0;
				for (int k = 0; k < word[j].length(); k++) {
					int n = word[j].charAt(k) - 97;
					if(n == 0 || n == 2 || n == 8 || n == 13 || n == 19 || temp.contains(n)) {
						count++;
					}
				}
				if(count == word[j].length()) {
					result++;
				}
			}
			answer = Math.max(answer, result);
			return;
		}

		for (int i = idx; i < arr.size(); i++) {
			selected[cnt] = arr.get(i);
			comb(i+1,cnt+1);				
			
		}
	}
}
