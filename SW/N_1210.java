package sw_expert_academy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class N_1210 {
	static int dot[][] = {{ -1, 0 }, { 1, 0 } }; // 상하좌우
	static Queue<Integer> start;
	static DOT end;
	static int num;
	static boolean[][] check;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int TN = sc.nextInt();
			int[][] arr = new int[100][100];
			start = new LinkedList<Integer>();
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[j][i] = sc.nextInt();
					
					if(arr[j][i] == 2) end = new DOT(i,j);				
				}
				if(arr[i][0] == 1) { // 시작이 1인 것만 담기
					start.add(i);
				}
			}
			
			while(!start.isEmpty()) {
				check = new boolean[100][100];
				num = start.poll();
				check[num][0] = true;
				dfs(num,0,arr);
			}
			
			System.out.println("#"+TN+" "+result);
		}
	}
	
	public static void dfs(int i,int j,int[][] arr) {
		if(j == end.x && i == end.y) {
			result = num;
			return;
		}
		
		if(j == 99) {
			return;
		}
		
		List<DOT> list = new ArrayList<DOT>();
		for(int a=0;a<2;a++) { // 갈수 있는 곳들 리스트에 담기
			int dx = i + dot[a][0];
			int dy = j + dot[a][1];
			
			// 범위 벗어나는 것 제거
			if (dx < 0 || dx >= arr.length || dy < 0 || dy >= arr.length)
				continue;
			
			if(!check[dx][dy] && arr[dx][dy] != 0) {
				list.add(new DOT(dx,dy));
			}
		}
		
		if(!list.isEmpty()) {
			int x = list.get(0).x;
			int y = list.get(0).y;
			check[x][y] = true;
			dfs(x,y,arr);
		}else {
			check[i][j+1] = true;
			dfs(i,j+1,arr);
		}
		
	}
	
	static class DOT{
		int x,y;
		
		public DOT(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}