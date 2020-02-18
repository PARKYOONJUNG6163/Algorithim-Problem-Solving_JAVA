package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_1260_Scan {
	public static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		arr = new int[N+1][N+1]; // 인접행렬
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
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
