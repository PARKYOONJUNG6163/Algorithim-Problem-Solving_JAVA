package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_7562 {
	public static int[][] dot = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs(sx,sy,ex,ey));
		}
	}
	
	public static int bfs(int sx,int sy,int ex,int ey) {
		boolean[][] visited = new boolean[N][N];
		Queue<DOT> queue =new LinkedList<>();
		queue.offer(new DOT(sx,sy,0));
		visited[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			DOT d = queue.poll();
			if(d.x == ex && d.y == ey) {
				return d.cnt;
			}
			
			for (int i = 0; i < dot.length; i++) {
				int dx = d.x + dot[i][0];
				int dy = d.y + dot[i][1];
				
				if(dx<0||dy<0||dx>=N||dy>=N||visited[dx][dy])continue;
				
				visited[dx][dy] = true;
				queue.offer(new DOT(dx,dy,d.cnt+1));
			}
		}
		
		return -1;
	}
	
	public static class DOT{
		int x,y,cnt;
		
		public DOT(int x,int y,int cnt) {
			this.x= x;
			this.y= y;
			this.cnt = cnt;
		}
	}
}
