package SSAFY_TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_17142_02 {
	public static int[][] arr;
	public static List<DOT> virus;
	public static int[] selected;
	public static boolean[][] visited;
	public static int answer;
	public static int total;
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 연구소크기
		int M = Integer.parseInt(st.nextToken()); // 바이러스개수
		// 0빈칸 1벽 2바이러스
		virus = new ArrayList<>();
		arr = new int[N][N];
		total = 0;
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) virus.add(new DOT(i,j,0));
				if(arr[i][j] == 0) total++;
			}
		}
		
		answer =Integer.MAX_VALUE;
		selected = new int[M];
		if(total == 0) { // 이미 꽉 차있는 경우
			answer = 0;
		}else {
			go(0,0);			
		}
		
		if(answer == Integer.MAX_VALUE) answer= -1;
		System.out.println(answer);
	}

	public static void go(int index,int count) {
		if(count == selected.length) {
			visited = new boolean[arr.length][arr[0].length];
			Queue<DOT> queue = new LinkedList<>();
			int result = Integer.MAX_VALUE;
			
			for (int i = 0; i < selected.length; i++) {
				DOT d = virus.get(selected[i]);
				queue.add(d);
				visited[d.x][d.y] = true;
			}
			
			int num = 0;
			if(answer == 0) return;
			while(!queue.isEmpty()) {
				DOT d = queue.poll();
				
				if(num == total) {
					answer = Math.min(result, answer);	
					return;
				}
				for (int i = 0; i < dot.length; i++) {
					int dx = d.x + dot[i][0];
					int dy = d.y + dot[i][1];
					
					if(dx<0||dy<0||dx>=arr.length||dy>=arr[0].length||visited[dx][dy]||arr[dx][dy] == 1) continue;
					
					if(arr[dx][dy] != 2) {
						num++;
						result = d.cnt+1;
					}
					visited[dx][dy] = true;
					queue.add(new DOT(dx,dy,d.cnt+1));
				}
			}
			return;
		}
		
		for (int i = index; i < virus.size(); i++) {
			selected[count] = i;
			go(i+1,count+1);
		}
	}
	
	public static class DOT{
		int x,y,cnt;
		
		public DOT(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
