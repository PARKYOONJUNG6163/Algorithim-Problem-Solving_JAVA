package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_2887 {
	public static int[] p;
	public static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		rank = new int[N+1];
		
		Pos[] star = new Pos[N];
		StringTokenizer st=  null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			star[i] = new Pos(x,y,z,i);
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Comparator<Pos> comparator = new Comparator<Pos>() {
		    @Override
		    public int compare(Pos a, Pos b) {
		        return a.x-b.x;
		    }
		};
		Arrays.sort(star, comparator);
		for (int i = 1; i < star.length; i++) {
			pq.offer(new Edge(star[i].id,star[i-1].id,Math.abs(star[i].x-star[i-1].x)));
		}
		
		comparator = new Comparator<Pos>() {
		    @Override
		    public int compare(Pos a, Pos b) {
		        return a.y-b.y;
		    }
		};
		Arrays.sort(star, comparator);
		for (int i = 1; i < star.length; i++) {
			pq.offer(new Edge(star[i].id,star[i-1].id,Math.abs(star[i].y-star[i-1].y)));
		}
		
		comparator = new Comparator<Pos>() {
		    @Override
		    public int compare(Pos a, Pos b) {
		        return a.z-b.z;
		    }
		};
		Arrays.sort(star, comparator);
		for (int i = 1; i < star.length; i++) {
			pq.offer(new Edge(star[i].id,star[i-1].id,Math.abs(star[i].z-star[i-1].z)));
		}
		
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		
		int cnt = 0;
		int answer = 0;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			int px = findSet(e.start);
			int py = findSet(e.end);
			if(px != py) {
				union(px,py);
				cnt++;
				answer += e.dist;
				if(cnt == N-1) {
					break;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static int findSet(int x) {
		if(p[x] == x){
			return x;
		}else {
			return p[x] = findSet(p[x]);
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			p[py] = px;
		}else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
	
	public static class Pos{
		int x,y,z,id;
		public Pos(int x,int y,int z,int id) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.id= id;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int start,end,dist;
		
		public Edge(int start,int end,int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return -Integer.compare(o.dist,this.dist);
		}
	}
}
