package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6109 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 위면 행 0 아래면 행 N-1 왼쪽이면 열 0 오른쪽이면 열 N-1
			if(dir.equals("up")) {
				for (int j = 0; j < N; j++) {
					int end = 0;
					for (int i = 1; i < N; i++) {
						int start = i;
						while(true) {
							if(start <= end || arr[start][j] == 0) break;
							if(arr[start-1][j] == 0) { // 비어있으면 그냥 옮기기만
								arr[start-1][j] = arr[start][j];
								arr[start][j] = 0; // 비워
							}else if(arr[start][j] == arr[start-1][j]) {
								arr[start-1][j] = arr[start][j] * 2; // 값변경
								arr[start][j] = 0; // 비엇다
								end = start;
								break;
							}
							start -= 1;
						}
					}
				}
			}else if(dir.equals("down")) {
				for (int j = 0; j < N; j++) {
					int end = N-1;
					for (int i = N-2; i >= 0; i--) {
						int start = i;
						while(true) {
							if(start >= end || arr[start][j] == 0) break;
							if(arr[start+1][j] == 0) { // 비어있으면 그냥 옮기기만
								arr[start+1][j] = arr[start][j];
								arr[start][j] = 0; // 비워
							}else if(arr[start][j] == arr[start+1][j]) {
								arr[start+1][j] = arr[start][j] * 2; // 값변경
								arr[start][j] = 0; // 비엇다
								end = start;
								break;
							}
							start += 1;
						}
					}					
				}
			}else if(dir.equals("left")) {
				for (int i = 0; i < N; i++) {
					int end = 0;
					for (int j = 1; j < N; j++) {
						int start = j;
						while(true) {
							if(start <= end || arr[i][start] == 0) break;
							if(arr[i][start-1] == 0) { // 비어있으면 그냥 옮기기만
								arr[i][start-1] = arr[i][start];
								arr[i][start] = 0; // 비워
							}else if(arr[i][start] == arr[i][start-1]) {
								arr[i][start-1] = arr[i][start] * 2; // 값변경
								arr[i][start] = 0; // 비엇다
								end = start;
								break;
							}
							start -= 1;
						}
					}					
				}
			}else {
				for (int i = 0; i < N; i++) {
					int end = N-1;
					for (int j = N-2; j >= 0; j--) {
						int start = j;
						while(true) {
							if(start >= end || arr[i][start] == 0) break;
							if(arr[i][start+1] == 0) { // 비어있으면 그냥 옮기기만
								arr[i][start+1] = arr[i][start];
								arr[i][start] = 0; // 비워
							}else if(arr[i][start] == arr[i][start+1]) {
								arr[i][start+1] = arr[i][start] * 2; // 값변경
								arr[i][start] = 0; // 비엇다
								end = start;
								break;
							}
							start += 1;
						}
					}					
				}
			}
			
			System.out.println("#"+test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
}
