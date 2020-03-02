package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2814 {
	public static int answer;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = arr[y][x] = 1;
			}
			answer = Integer.MIN_VALUE;
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				go(i,1);
			}
			System.out.println("#"+test_case +" "+answer);
		}
	}
	
	public static void go(int v,int count) {
		answer = Math.max(answer, count);
		visited[v] = true;
		for (int i = 1; i < arr.length; i++) {
			if(!visited[i] && arr[v][i] == 1) {
				go(i,count+1);
				visited[i] = false;
			}
		}
	}
}
