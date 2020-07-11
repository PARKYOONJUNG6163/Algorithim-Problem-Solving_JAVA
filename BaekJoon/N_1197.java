package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N_1197 {
	public static int[] parents;
	public static int[] rank;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V];
		rank = new int[V];
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken())-1;
			edges[i][1] = Integer.parseInt(st.nextToken())-1;
			edges[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2],  o2[2]);
			}
			
		});
		
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			// 같은 팀이라면 패스
			if(a == b) continue;
			// 간선이 연결하는 두 정점이 같은 팀이 아니라면 한 팀으로 합쳐주고 간선 선텍
			union(a,b);
			// 간선을 선택
			result += edges[i][2];
			cnt++;
			if(cnt == V-1) break;
		}
		
		System.out.println(result);
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
