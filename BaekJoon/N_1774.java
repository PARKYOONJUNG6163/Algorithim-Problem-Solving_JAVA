package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1774 {
	public static int V;
	public static int M;
	public static int[] p;
	public static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Edge[] star = new Edge[V];

		for (int i = 0; i < star.length; i++) {
			st = new StringTokenizer(br.readLine());
			int x = (int)Double.parseDouble(st.nextToken());
			int y = (int)Double.parseDouble(st.nextToken());
			star[i] = new Edge(x,y,i);
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < star.length; i++) {
			for (int j = i+1; j < star.length; j++) {
				pq.offer(new Edge(i,j,getDist(star[i],star[j])));
			}
		}
		rank = new int[V];
		p = new int[V];

		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int star1 = Integer.parseInt(st.nextToken())-1;
			int star2 = Integer.parseInt(st.nextToken())-1;
			union(star1,star2);
		}

		int cnt = 0;
		double answer = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int px = findSet(e.start);
			int py = findSet(e.end);
			if(px != py) {
				union(px,py);
				cnt++;
				answer += e.dist;
				if(cnt == V-1) {
					break;
				}
			}
		}
		System.out.println(String.format("%.2f", answer));
	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		else {
			return p[x] = findSet(p[x]);
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;

			if (rank[px] == rank[py])
				rank[py]++;
		}

	}
	
	public static double getDist(Edge i, Edge j) {
		return Math.sqrt(Math.pow(i.start-j.start ,2) + Math.pow(i.end - j.end,2));
	}
	
	public static class Edge implements Comparable<Edge>{
		int start, end;
		double dist;
		
		public Edge(int start,int end,double dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return -Double.compare(o.dist,this.dist);
		}
	}
}