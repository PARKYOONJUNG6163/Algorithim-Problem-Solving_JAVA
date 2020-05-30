package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2636 {
	static int dot[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상하좌우
	static int[][] arr;
	static boolean[][] visited;
	static int totalCnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		totalCnt = 0; // 치즈 총 개수
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) totalCnt++;
			}
		}
		
		int time = 0;
		int answer = 0;
		while(totalCnt > 0) {
			visited = new boolean[N][M];
			answer = totalCnt;
			dfs(0,0);
			// 바깥 치즈 없애기
			for (int i = 0; i < arr.length; i++) { 
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == 2) {
						totalCnt--;
						arr[i][j] = 0;
					}
				}
			}
			time++;
		}
		System.out.println(time);
		System.out.println(answer);
	}
	
	public static void dfs(int x,int y) {
		visited[x][y] = true;
		for (int i = 0; i < dot.length; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx < 0 || dy <0 || dx>=arr.length || dy>=arr[0].length || visited[dx][dy] || arr[dx][dy] == 2) continue;
			if(arr[dx][dy] == 1) {
				arr[dx][dy] = 2;
			}else {
				dfs(dx,dy);
			}
		}
	}
}
