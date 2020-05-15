package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_5643 {
	public static List<Integer>[] adj;
	public static List<Integer>[] adj2;
	public static int cnt;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			adj = new List[N];
			adj2 = new List[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
				adj2[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				adj[A].add(B);
				adj2[B].add(A);
			}
			
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				cnt = 0;
				visited = new boolean[N];
				getPrev(i);
				getNext(i);
				if(cnt == N-1) answer++;
			}

			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void getPrev(int idx) {
		visited[idx] = true;
		for (int i : adj[idx]) {
			if(!visited[i]) {
				cnt++;
				getPrev(i);	
			}
		}
	}
	
	public static void getNext(int idx) {
		visited[idx] = true;
		for (int i : adj2[idx]) {
			if(!visited[i]) {
				cnt++;
				getNext(i);	
			}
		}
	}

}
