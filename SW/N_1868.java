package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1868 {
	public static int[][] dot = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; // 상 부터 시계방향
	public static int[][] num;
	public static Queue<DOT> queue;
	public static char[][] arr;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			num = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = br.readLine().toCharArray();
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == '*') num[i][j] = -1;
				}
			}
			
			answer = 0;
			queue = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] != '.') continue;
					for (int k = 0; k < dot.length; k++) {
						int dx = i + dot[k][0];
						int dy = j + dot[k][1];
						
						if(dx <0 || dy <0 ||dx >=arr.length || dy>=arr[0].length) continue;
						
						if(arr[dx][dy] != '.') {
							num[i][j]++;					
						}
					}
				}
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == '.' && num[i][j] == 0) {
						queue.add(new DOT(i,j));
						arr[i][j]= '0';
						answer++;
						spreadNum();						
					}
				}
			}
			

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] != '.') continue;
					answer++;
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
		
	}
	
	public static void spreadNum() {
		while(!queue.isEmpty()) {
			DOT d = queue.poll();
			 
			for (int k = 0; k < dot.length; k++) {
				int dx = d.x + dot[k][0];
				int dy = d.y + dot[k][1];
				
				if(dx <0 || dy <0 ||dx >=arr.length || dy>=arr[0].length || arr[dx][dy] != '.') continue;
			
				arr[dx][dy]= '0';
				if(num[dx][dy] == 0) {
					queue.add(new DOT(dx,dy));					
				}
				
			}
		}
	}

	public static class DOT{
		int x,y;
		
		public DOT(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
	}
}
