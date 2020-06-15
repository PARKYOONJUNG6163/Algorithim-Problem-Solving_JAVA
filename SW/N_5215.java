package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5215 {
	public static int[][] food;
	public static int L;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			food = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			boolean[] visited = new boolean[N];
			powerSet(visited,0,0,0);
			
			System.out.println("#"+test_case+" " + answer);
		}
	}
	
	public static void powerSet(boolean[] visited,int idx,int cal,int score) {
		if(cal > L) return;
		if(idx == visited.length) {
			answer = Math.max(answer, score);
			return;
		}
		
		visited[idx] = true;
		powerSet(visited,idx+1,food[idx][1]+cal,food[idx][0]+score);
		
		visited[idx] = false;
		powerSet(visited,idx+1,cal,score);
	}
}
