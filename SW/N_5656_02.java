package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_5656_02 {
	public static int[][] arr;
	public static int N;
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int answer;
	public static int total;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			total = 0;
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] != 0) total++;
				}
			}
			
			go(0);
			System.out.println("#"+test_case+" " + answer);
		}
	}
	
	public static void go(int count) {
		if(count >= N) {
			answer = Math.min(answer, total);
			return;
		}
		
		for (int i = 0; i < arr[0].length; i++) { // 던질 열 구하기
			int[][] temp = new int[arr.length][arr[0].length];
			int now_total = total;
			for (int k = 0; k < arr.length; k++) { // 임시 배열
				System.arraycopy(arr[k], 0, temp[k], 0, arr[0].length);
			}
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i] != 0) { // 벽돌 있으면 
					total -= removeBrick(j,i); // 벽돌 제거
					setBrick(); // 벽돌 셋팅하기
					break;
				}
			}
			go(count+1);
			for (int k = 0; k < arr.length; k++) { // 다시 원래 배열로
				System.arraycopy(temp[k], 0, arr[k], 0, arr[0].length);
			}
			total = now_total;
		}
	}
	
	public static int removeBrick(int x,int y) {
		int remove_num = 0;
		Queue<DOT> queue = new LinkedList<>();
		queue.add(new DOT(x,y));
		
		while(!queue.isEmpty()) {
			DOT d = queue.poll();
			int num = arr[d.x][d.y];
			if(arr[d.x][d.y] == 0) {
				continue;
			}
			arr[d.x][d.y] = 0; // 벽돌 제거 됨
			remove_num++;
			for (int i = 0; i < dot.length; i++) {
				for (int j = 1; j < num; j++) {
					int dx = d.x + (dot[i][0]*j);
					int dy = d.y + (dot[i][1]*j);
					
					if(dx <0 || dy <0 || dx >= arr.length || dy >= arr[0].length) break;
					if(arr[dx][dy] == 0) continue;
					if(arr[dx][dy] > 1) {
						queue.add(new DOT(dx,dy));
					}else{
						arr[dx][dy] = 0; // 벽돌 제거 됨
						remove_num++;
					}
				}
			}
		}
		return remove_num;
	}
	
	public static void setBrick() {
		for (int i = arr.length-2; i >= 0; i--) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0) {
					int index = -1;
					for (int k = i+1; k < arr.length; k++) {
						if(arr[k][j] == 0) {
							index = k;
						}
					}
					if(index != -1) {
						arr[index][j] = arr[i][j];
						arr[i][j] = 0;
					}
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
