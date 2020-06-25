package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1717 {
	public static int[] parent;
	public static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		rank = new int[N+1];
		
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				union(a,b);
			}else {
				if(findSet(a) == findSet(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parent[py] = px;
		}else {
			parent[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
