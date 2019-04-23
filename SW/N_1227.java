package SWExpertAcademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_1227 {
	static int dot[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상하좌우
	static boolean check[][];
	static DOT start;
	static DOT end;
	static int[][] arr;
	static Queue<DOT> queue;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			arr = new int[100][100];
			result = 0;
			queue = new LinkedList<DOT>();
			
			for (int i = 0; i < 100; i++) { // 배열 생성및 구분
				String temp = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
					if (arr[i][j] == 2) {
						start = new DOT(i, j);
						queue.add(new DOT(i,j));
					}
					if (arr[i][j] == 3)
						end = new DOT(i, j);
				}
			}
			check = new boolean[100][100];
			bfs();
			System.out.println("#"+N+" "+result);
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			DOT d = queue.poll();
			check[d.x][d.y] = true;
			for (int i = 0; i < dot.length; i++) {
				int dx = d.x + dot[i][0];
				int dy = d.y + dot[i][1];
				
				if(dx == end.x && dy == end.y) {
					result = 1;
					return;
				}
				
				if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr.length)
					continue;
				
				if(!check[dx][dy] && arr[dx][dy] == 0) {
					queue.add(new DOT(dx,dy));
				}
			}
		}
	}
	
	static class DOT {
		int x, y;

		public DOT(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}