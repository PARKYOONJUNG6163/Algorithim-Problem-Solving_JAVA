package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_7208 {
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] color;
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			color = new int[N];
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken())-1;
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						adj[i].add(j);
					}
				}
			}

			visited = new boolean[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < adj.length; i++) {				
				dfs(i,1,0);
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static void dfs(int idx,int cnt,int result) {
		if(cnt == visited.length) {
			answer = Math.min(answer, result);
			return;
		}
		
		visited[idx] = true;
		for (int i : adj[idx]) {
			if (!visited[i]) {
				if (color[idx] == color[i]) {
					boolean[] chk = new boolean[4];
					int tmpCnt = 0;
					for (int tmp : adj[i]) {
						if(!chk[color[tmp]]) {
							chk[color[tmp]] = true;							
							tmpCnt++;
						}
					}
					
					if(tmpCnt == 4) { // 인접 색 모두 썻다면
						for (int j = 0; j < chk.length; j++) {
							if (color[idx] != j) {
								int tmp = color[i];
								color[i] = j;
								dfs(i,cnt+1,result+1);
								color[i] = tmp;
							}
						}
					}else {
						for (int j = 0; j < chk.length; j++) {
							if (!chk[j]) {
								int tmp = color[i];
								color[i] = j;
								dfs(i,cnt+1,result+1);
								color[i] = tmp;
							}
						}						
					}
				}else {
					dfs(i,cnt+1,result);					
				}
			}
		}
		visited[idx] = false;
	}
}
