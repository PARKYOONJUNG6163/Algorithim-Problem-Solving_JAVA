package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2234_02 {
	public static int[][] visited;
	public static int[][] dot = {{1,0},{0,1},{-1,0},{0,-1}}; // 남 동 북 서
	public static String[][] arr;
	public static int max;
	public static List<Integer> total;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new String[m][n];
		for (int i = 0; i < arr.length; i++) { // 남동북서
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				int num = Integer.parseInt(st.nextToken());
				String tmp = Integer.toBinaryString(num);
				while(tmp.length() < 4) {
					tmp = "0" + tmp;
				}
				arr[i][j] = tmp;
			}
		}
		
		total = new ArrayList<>();
		max = Integer.MIN_VALUE;
		visited = new int[m][n];
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(visited[i][j] == 0) {
					num++;
					bfs(i,j,num);
				}
			}
		}
		
		// 하나 제거 후 가장 넓은 방
		int removeMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {				
				for (int k = 0; k < 4; k++) {
					if(arr[i][j].charAt(k) == '1') {
						int dx = i + dot[k][0];
						int dy = j + dot[k][1];
						
						if(dx < 0||dy<0||dx>=arr.length||dy>=arr[0].length||visited[dx][dy]==visited[i][j]) continue;
						
						int n1 = total.get(visited[i][j]-1);
						int n2 = total.get(visited[dx][dy]-1);
						removeMax = Math.max(removeMax, n1+n2);
					}
				}
			}
		}
		System.out.println(num);
		System.out.println(max);
		System.out.println(removeMax);
	}
	
	public static void bfs(int x,int y,int num) {
		Queue<DOT> queue = new LinkedList<>();
		queue.offer(new DOT(x,y));
		visited[x][y] = num;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			DOT d = queue.poll();
			cnt++;
			for (int i = 0; i < dot.length; i++) { // 남동북서
				if(arr[d.x][d.y].charAt(i) == '1') continue;
				int dx = d.x + dot[i][0];
				int dy = d.y + dot[i][1];
				
				if(dx <0||dy<0||dx>=arr.length||dy>=arr[0].length||visited[dx][dy] != 0)continue;
				
				visited[dx][dy] = num;
				queue.offer(new DOT(dx,dy));
			}
		}
		total.add(cnt);
		max = Math.max(max, cnt);
	}
	
	public static class DOT{
		int x,y;
		
		public DOT(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}
