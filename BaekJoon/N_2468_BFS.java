package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2468 {
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

		int result = Integer.MIN_VALUE;
		while(max > 0) {
			int count =0;
			visited = new boolean[N][N];
			max--;

			Queue<DOT> queue = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(!visited[i][j] && arr[i][j] > max) {
						visited[i][j] = true;
						queue.add(new DOT(i,j));
						while(!queue.isEmpty()) {
							DOT d = queue.poll();
							visited[d.x][d.y] = true;
							for (int k = 0; k < dot.length; k++) {
								int dx = d.x + dot[k][0];
								int dy = d.y + dot[k][1];
								
								if(dx <0 || dy <0 || dx >= arr.length || dy >= arr[0].length || visited[dx][dy] || arr[dx][dy] <= max) {
									continue;									
								}
								visited[dx][dy] = true;
								queue.add(new DOT(dx, dy));
							}
						}
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}

	

	public static class DOT{
		int x,y;

		public DOT(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

}