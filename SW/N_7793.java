package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7793 {
	static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			Queue<DOT> go = new LinkedList<>();
			Queue<DOT> devil = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = st.nextToken().toCharArray();
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == '*') devil.offer(new DOT(i,j));					
					else if(arr[i][j] == 'S') go.offer(new DOT(i,j));
				}
			}
			
			int answer = 0;
			boolean check = false;
			start : while(!go.isEmpty()) {
				answer++;	
				Queue<DOT> temp_devil = new LinkedList<>();
				while(!devil.isEmpty()) {
					DOT dv = devil.poll();
					for (int i = 0; i < dot.length; i++) {
						int dx = dv.x + dot[i][0];
						int dy = dv.y + dot[i][1];
						
						if(dx < 0 || dy<0|| dx >= arr.length || dy >= arr[0].length || arr[dx][dy] != '.') continue;
						
						arr[dx][dy] = '*';
						temp_devil.offer(new DOT(dx,dy));
					}						
				}
				devil = temp_devil;
				
				Queue<DOT> temp_go = new LinkedList<>();
				while(!go.isEmpty()) {
					DOT d = go.poll();
					for (int i = 0; i < dot.length; i++) {
						int dx = d.x + dot[i][0];
						int dy = d.y + dot[i][1];
						
						if(dx < 0 || dy < 0|| dx >= arr.length || dy >= arr[0].length || arr[dx][dy] == '*') continue;
						if(arr[dx][dy]== 'D') {
							check = true;
							break start;
						}
						if(arr[dx][dy] == '.') {
							arr[dx][dy] = 'S';
							temp_go.offer(new DOT(dx,dy));						
						}
					}						
				}
				go = temp_go;
			}
			
			if(check) {
				System.out.println("#" + test_case + " " + answer);
			}else {
				System.out.println("#" + test_case + " " + "GAME OVER");
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
