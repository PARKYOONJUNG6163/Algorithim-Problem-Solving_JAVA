package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2468_DFS {
	public static int[][] dot = {{0,-1},{0,1},{-1,0},{1,0}};
	public static int[][] arr;
	public static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		// 제일 큰 수는 다 잠겼을 떄이므로 확인해줄 필요없으므로 -1하고 시작
		int result = Integer.MIN_VALUE;
		while(max > 0) {
			visited = new boolean[N][N];
			int count = 0;
			max--;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {	
					if(arr[i][j] > max && !visited[i][j]) {
						dfs(i,j,max);
						count++;
						result = Math.max(result, count);						
					}
				}
			}
		}
		System.out.println(result);
	}

	public static void dfs(int x, int y,int max) {
		visited[x][y] = true;
		for (int i = 0; i < dot.length; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx <0 || dy <0 || dx >= arr.length || dy >= arr[0].length || visited[dx][dy] || arr[dx][dy] <= max) {
				continue;
			}
	
			dfs(dx,dy,max);
		}
	}
}
