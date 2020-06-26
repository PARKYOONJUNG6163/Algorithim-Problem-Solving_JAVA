package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1976 {
	public static int[] parent;
	public static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		parent = new int[N+1];
		rank = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					union(i,j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int result = findSet(Integer.parseInt(st.nextToken()));
		boolean check = true;
		for (int i = 1; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(result != findSet(n)) {
				check = false;
				break;
			}
		}
		
		if(check) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else{
			return parent[x] = findSet(parent[x]);
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[px]) {
			parent[py] = px;
		}else {
			parent[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
