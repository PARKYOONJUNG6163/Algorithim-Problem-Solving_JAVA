package sw_expert_academy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class N_1211 {
	static int dot[][] = {{ -1, 0 }, { 1, 0 } }; // �����¿�
	static Queue<Integer> start;
	static int num;
	static int[][] dist;
	static boolean[][] check;
	static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int TN = sc.nextInt();
			int[][] arr = new int[100][100];
			start = new LinkedList<Integer>();
			result = new int[100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[j][i] = sc.nextInt();	
				}
				if(arr[i][0] == 1) { // ������ 1�� �͸� ���
					start.add(i);
				}
			}
			
			while(!start.isEmpty()) {
				check = new boolean[100][100];
				dist = new int[100][100];
				num = start.poll();
				dist[num][0] = 1;
				check[num][0] = true;
				dfs(num,0,arr);
			}
			
			int min_Index = 0;
			for(int i=1;i<100;i++) {
				if(result[min_Index] != 0 && result[i] != 0 && result[min_Index] >= result[i]) {
					min_Index = i;
				}
			}
			System.out.println("#"+TN+" "+min_Index);
		}
	}
	
	public static void dfs(int i,int j,int[][] arr) {
		if(j == 99) {
			result[num] = dist[i][99];
			return;
		}
		
		List<DOT> list = new ArrayList<DOT>();
		for(int a=0;a<2;a++) { // ���� �ִ� ���� ����Ʈ�� ���
			int dx = i + dot[a][0];
			int dy = j + dot[a][1];
			
			// ���� ����� �� ����
			if (dx < 0 || dx >= arr.length || dy < 0 || dy >= arr.length)
				continue;
			
			if(!check[dx][dy] && arr[dx][dy] != 0) {
				list.add(new DOT(dx,dy));
			}
		}
		
		if(!list.isEmpty()) {
			int x = list.get(0).x;
			int y = list.get(0).y;
			dist[x][y] += dist[i][j] + 1;
			check[x][y] = true;
			dfs(x,y,arr);
		}else {
			dist[i][j+1] = dist[i][j] + 1;
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