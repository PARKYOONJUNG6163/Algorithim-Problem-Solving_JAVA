package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4534 {
	public static int answer;
	public static int[][] arr;
	public static int[] visited;
	public static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = arr[y][x] = 1;
			}
			answer = 0;
			count = 1;
			int v = 1;
			visited = new int[N+1]; // 1 흰색 2 검정
			visited[v] = 1;
			go(v);
			visited = new int[N+1]; 
			visited[v] = 2;
			go(v);
			System.out.println("#"+test_case +" "+(answer%1000000007));
		}
	}
	
	public static void go(int v) {
		if(count >= visited.length-1) {
			answer++;
			count-=1;
			return;
		}
		
		boolean check = false;
		int w = v;
		for (int i = 1; i < visited.length; i++) {
			if(visited[i] == 0 && arr[v][i] == 1) { // 방문x, 인접
				if(visited[v] == 1) { // 앞쪽이 흰색
					visited[i] = 1; // 흰색
					count+=1;
					go(i);
					w = i;
					if(visited[v] != 2) check = true;
				}
			}
		}
		if(check) {
			visited[w] = 2; // 검은색
			count+=1;
			go(w);
		}
	}

}
