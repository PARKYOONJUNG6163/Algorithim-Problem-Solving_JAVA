package SWExpertAcademy;

import java.util.Scanner;

public class N_1861 {
	static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] arr;
	static int start;
	static int num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		
			num = Integer.MIN_VALUE;
			start = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					go(i,j,i,j,1);
					
				}
			}
			
			System.out.println("#" + test_case + " " + start + " " + num);
		}
	}
	
	public static void go(int sx, int sy,int x, int y,int count) {
		for (int i = 0; i < dot.length; i++) {
			int dx = x+dot[i][0];
			int dy = y+dot[i][1];
			
			if(dx < 0 || dy< 0 || dx >=arr.length || dy>=arr[0].length || arr[x][y]+1 != arr[dx][dy]) {
				if(count!= 1) {
					if(num == count) {
						start = Math.min(arr[sx][sy], start);
					}else if(num < count){
						num = Math.max(num, count);
						start = arr[sx][sy];
					}
				}
				continue;
			}
			
			go(sx,sy,dx,dy,count+1);

		}
	}
}
