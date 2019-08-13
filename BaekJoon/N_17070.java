package BFSDFS;

import java.util.Scanner;

public class N_17070 {
	static int dot[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 } }; // ������,�밢��,�Ʒ���
	static int[][] arr;
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		dfs(new DOT(0, 1),"R");
		dfs(new DOT(0, 1),"DI");
		
		System.out.println(count);
	}

	public static void dfs(DOT p, String way) {
		int dx = p.x;
		int dy = p.y;
		switch(way) {
			case "R" :
				if(checkR(dx,dy)) { // ���� Ȯ��
					dx += dot[0][0];
					dy += dot[0][1];
					if(dx == arr.length-1 && dy == arr.length-1) { // N,N�̸� ��������
						count++;
						return;
					}
					dfs(new DOT(dx, dy),"R");	
					dfs(new DOT(dx, dy),"DI");
				}
				break;
			case "D":
				if(checkD(dx,dy)) { // ���� Ȯ��
					dx += dot[2][0];
					dy += dot[2][1];
					if(dx == arr.length-1 && dy == arr.length-1) { // N,N�̸� ��������
						count++;
						return;
					}
					dfs(new DOT(dx, dy),"D");	
					dfs(new DOT(dx, dy),"DI");
				}
				break;
			case "DI": // �밢��
				if(checkDI(dx,dy)) { // �밢�� Ȯ��
					dx += dot[1][0];
					dy += dot[1][1];
					if(dx == arr.length-1 && dy == arr.length-1) { // N,N�̸� ��������
						count++;
						return;
					}
					dfs(new DOT(dx, dy),"R");	
					dfs(new DOT(dx, dy),"DI");
					dfs(new DOT(dx, dy),"D");
				}
				break;
		}

	}
	
	public static boolean checkDI(int x, int y) {
		for (int i = 0; i < 3; i++) {
			int dx = dot[i][0] + x;
			int dy = dot[i][1] + y;
			if(dx >= arr.length || dy >= arr.length || arr[dx][dy] != 0) return false;						
		}
		return true;
	}
	
	public static boolean checkD(int x, int y) {
		int dx = dot[2][0] + x;
		int dy = dot[2][1] + y;
		if(dx >= arr.length || dy >= arr.length || arr[dx][dy] != 0) return false;			
		return true;
	}
	
	public static boolean checkR(int x, int y) {
		int dx = dot[0][0] + x;
		int dy = dot[0][1] + y;
		if(dx >= arr.length || dy >= arr.length || arr[dx][dy] != 0) return false;							
		return true;
	}

	static class DOT {
		int x, y;

		public DOT(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
