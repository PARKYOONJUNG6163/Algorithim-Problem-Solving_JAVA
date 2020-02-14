package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_7576 {
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static Queue<DOT> queue;
	public static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		queue = new LinkedList<>();
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) queue.add(new DOT(i,j)); // 익은 토마토 모으기
			}
		}
		
		int count = 0;
		if(queue.size() != N * M) {
			count = bfs();
		}

		boolean bool = true;
		for (int i = 0; i < arr.length; i++) { // 다 익지 못한 상황 체크
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					bool = false;
					break;
				}
			}
			if(!bool) break;
		}
		
		if(!bool) {
			System.out.println("-1");
		}else {
			System.out.println(count);
		}
		
	}
	
	public static int bfs() {
		int count = -1;
		while(!queue.isEmpty()) {
			Queue<DOT> temp = new LinkedList<>();
			count++;
			while(!queue.isEmpty()) {
				DOT d = queue.poll();
				
				for (int i = 0; i < dot.length; i++) {
					int dx = d.x + dot[i][0];
					int dy = d.y + dot[i][1];
					
					if(dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || arr[dx][dy] != 0) continue;
					
					arr[dx][dy] = 1;
					temp.add(new DOT(dx,dy));
				}
			}
			queue = temp;
		}
		return count;
	}
	
	public static class DOT{
		int x,y;
		
		public DOT(int x,int y) {
			this.x = x;
			this.y =y;
		}
	}
}
