package BaekJoon;

import java.util.Scanner;

public class N_3109 {
	public static int[][] dot = {{-1,1},{0,1},{1,1}}; // 오위, 오, 오아
	public static char[][] arr;
	public static int result;
	public static boolean bool;
	public static boolean[][] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		arr =new char[R][C];
		check = new boolean[R][C];
		for (int i = 0; i < arr.length; i++) {
			String[] str = sc.next().split("");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = str[j].charAt(0);
				if(arr[i][j] == 'x') check[i][j] = true;
			}
		}
		result = 0;
		for (int i = 0; i < arr.length; i++) {
			bool = false;
			go(i,0);
			if(bool) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static void go(int x,int y) {
		for (int i = 0; i < dot.length; i++) {
			if(bool) return;
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dy == arr[0].length-1) {
				bool = true;
				return;
			}
			if(dx < 0 || dy <= 0 || dx > arr.length-1 || dy >= arr[0].length-1 || check[dx][dy] || arr[dx][dy] == 'x') {
				continue;
			}
			
			check[dx][dy] = true;
			go(dx,dy);
		}
	}
}
