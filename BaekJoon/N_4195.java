package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_4195 {
	public static int[] parent;
	public static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int F = Integer.parseInt(br.readLine());
			HashMap<String,Integer> hm = new HashMap<>();
			parent = new int[2*F+1];
			rank = new int[2*F+1];
			
			for (int i = 1; i < parent.length; i++) {
				parent[i] = i;
			}
			
			int idx = 1;
			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String A = st.nextToken();
				String B = st.nextToken();
				
				int A_Idx = idx;
				if(!hm.containsKey(A)){
					hm.put(A, idx++);
				}else {
					A_Idx = hm.get(A);
				}
				
				int B_Idx = idx;
				if(!hm.containsKey(B)){	
					hm.put(B, idx++);
				}else {
					B_Idx = hm.get(B);
				}
				
				union(A_Idx,B_Idx);
				
				int tmpA = findSet(A_Idx);
				int tmpB = findSet(B_Idx);
				int answer = 0;
				for (int j = 1; j <= hm.size(); j++) {
					int p = findSet(parent[j]);
					if(p == tmpA || p == tmpB) {
						answer++;
					}
				}
				sb.append(answer+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = findSet(parent[x]);
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parent[py] = px;
		}else{
			parent[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
