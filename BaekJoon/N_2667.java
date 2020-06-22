package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_2667 {
	public static boolean[][] visited;
	public static int num;
	public static int[][] arr;
	public static int total;
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		num = 2;
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 1) {
					if(!visited[i][j]) {
						total = 0;
						go(i,j,num);
						list.add(total);
						num++;
					}
				}
			}	
		}
		
		System.out.println(num-2);
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	public static void go(int x,int y,int num) {
		total++;
		visited[x][y] = true;
		for (int i = 0; i < dot.length; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx< 0||dy<0||dx>=visited.length||dy>=visited.length||arr[dx][dy] != 1 || visited[dx][dy]) continue;
			
			arr[dx][dy] = num;
			go(dx,dy,num);
		}
	}
}
