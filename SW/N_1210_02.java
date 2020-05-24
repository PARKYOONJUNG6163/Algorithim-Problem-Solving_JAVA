package SWExpertAcademy;

import java.util.Scanner;

public class N_1210_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			String s = "";
			int end_x = 0;
			int end_y = 0;
			int result = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = sc.nextInt();
					if(i == 0 && arr[i][j] == 1) s = s + j + ",";
					if(arr[i][j] == 2) {
						end_x = i; 
						end_y = j;
					}
				}
			}
			
			String[] temp = s.split(",");
			int dir = 4; // 하
			boolean check = false;
			
			for (int i = 0; i < temp.length; i++) {
				boolean[][] check_arr = new boolean[100][100];
				int index = Integer.parseInt(temp[i]);
				int dx = 0;
				int dy = index;
				while(true) {
					check_arr[dx][dy] = true;
					if(dir == 1) {
						dy -= 1;
					}else if(dir == 2) {
						dy += 1;
					}else {
						dx += 1;
					}
					
					if(dx < 0 || dy < 0 || dx >= arr.length || dy > arr[0].length) break;
					
					// 다음 방향 정하기
					if(!(dy-1 < 0 || dy-1 >= arr.length) && arr[dx][dy-1] == 1 && !check_arr[dx][dy-1]) {
						dir = 1; // 좌로 변경
					}else if(!(dy+1 < 0 || dy+1 >= arr.length) && arr[dx][dy+1] == 1 && !check_arr[dx][dy+1]) {
						dir = 2; // 우로 변경
					}else {
						dir = 4;
					}

					if(dx == end_x && dy == end_y) {
						check = true; 
						result = index;
						break;
					}
				}
				if(check) break;
			}
			System.out.println("#" + T + " " + result);
			
		}
	}

}
