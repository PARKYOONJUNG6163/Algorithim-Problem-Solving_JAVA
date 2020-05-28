package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_11559 {
	static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	static String[][] arr;
	static boolean[][] check;
	static List<Puyo> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			arr = new String[12][6];
			int result = 0;
			
			for (int i = 0; i < arr.length; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < temp.length; j++) {
					arr[i][j] = temp[j];
				}
			}

			while(true) {
				boolean flag = false;
				check = new boolean[12][6];
				
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if(!check[i][j] && !arr[i][j].equals(".")) {
							list = new ArrayList<>();
							list.add(new Puyo(i,j));
							dfs(i, j, arr[i][j]);
							if (list.size() >= 4) {
								flag = true;
								for (Puyo p : list) {
									arr[p.x][p.y] = ".";
								}
							}
						}
					}
				}
				
				if(!flag) {
					break;
				}else {
					result++;
					Fall();
				}
			}
			System.out.println(result);
	}
	
	public static void dfs(int x, int y, String color) {
		check[x][y] = true;
		for (int i = 0; i < dot.length; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || check[dx][dy] || !arr[dx][dy].equals(color)) continue;
			
			list.add(new Puyo(dx,dy));
			dfs(dx,dy,color);
		}
	}
	
	public static void Fall() {
		for (int i = arr.length-2; i >=0; i--) {
			for (int j = 0; j < arr[i].length; j++) {
				if(!arr[i][j].equals(".")) {
					int dx = i + 1;
					while(dx < arr.length && arr[dx][j].equals(".")) {
						dx += 1; // 아래로 떨어지기
					}		
					
					if(i != dx-1) {
						arr[dx-1][j] = arr[i][j];
						arr[i][j] = ".";						
					}
				}
			}
		}
	}

	public static class Puyo{
		int x,y;
		
		public Puyo(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

