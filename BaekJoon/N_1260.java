package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1260 {
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1]; // 인접행렬
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		System.out.print(V+" ");
		boolean[] visited = new boolean[N+1];
		visited[V] = true;
		dfs(V, visited);
		
		System.out.println();
		
		System.out.print(V+" ");
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited = new boolean[N+1];
		visited[V] = true;
		bfs(queue, visited);
	}
	
	public static void dfs(int V,boolean[] visited) {
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i] && arr[V][i] == 1) {
				System.out.print(i + " ");
				visited[i] = true;
				dfs(i,visited);
			}
		}
	}
	
	public static void bfs(Queue<Integer> queue,boolean[] visited) {
		while(!queue.isEmpty()) {
			int w = queue.poll();
			
			for (int i = 1; i < visited.length; i++) {
				if(!visited[i] && arr[w][i] == 1) {
					System.out.print(i + " ");
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}
}