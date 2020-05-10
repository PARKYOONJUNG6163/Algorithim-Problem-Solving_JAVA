package SWExpertAcademy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N_1258 {
	static int[][] dot2 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] dot = { { 1, 0 }, { 0, 1 } }; // 아래 오른쪽
	static boolean[][] check;
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			ArrayList<Matrix> list = new ArrayList<>();
			
			check = new boolean[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == 0 ||check[i][j]) continue;
					int dx = i;
					int dy = j;
					int row = 1;
					int col = 1;
					while (true) {
						dx += dot[0][0];
						dy += dot[0][1];
						if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || arr[dx][dy] == 0
								|| check[dx][dy]) {
							break;
						}
						col++;
					}

					dx = i;
					dy = j;
					while (true) {
						dx += dot[1][0];
						dy += dot[1][1];
						if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || arr[dx][dy] == 0
								|| check[dx][dy]) {
							break;
						}
						row++;
					}
					int endx = col;
					int endy = row;
					list.add(new Matrix(endx, endy, endx*endy));
					go(i,j);
				}
			}
			Collections.sort(list);
			System.out.print("#" + test_case + " " + list.size() + " ");
			for(Matrix m : list) {
				System.out.print(m.x + " " + m.y + " ");
			}
			System.out.println();
		}
	}

	public static void go(int x, int y) {
		check[x][y] = true;

		for (int i = 0; i < dot2.length; i++) {
			int dx = x + dot2[i][0];
			int dy = y + dot2[i][1];
			if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || arr[dx][dy] == 0 || check[dx][dy]) {
				continue;
			}
			go(dx, dy);
		}
	}
	
	public static class Matrix implements Comparable<Matrix>{
		int x, y, size;
		
		public Matrix(int x,int y,int size) {
			this.x= x;
			this.y = y;
			this.size= size;
		}

		@Override
		public int compareTo(Matrix m) {
			// TODO Auto-generated method stub
			if(this.size > m.size) {
				return 1;
			}else if(m.size > this.size) {
				return -1;
			}else {
				return this.x - m.x;
			}
		}
	}
}

