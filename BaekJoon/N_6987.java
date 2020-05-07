package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_6987 {
	public static int[][] arr;
	public static int[][] score;
	public static int answer;
	public static int[] left = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	public static int[] right = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 4; test_case++) { // 1~4줄
			arr = new int[6][3]; // 나라, 승무패
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken()); // 승
				arr[i][1] = Integer.parseInt(st.nextToken()); // 무
				arr[i][2] = Integer.parseInt(st.nextToken()); // 패
			}
			
			answer = 0;
			score = new int[6][3];
			go(0);
			System.out.print(answer + " ");
		}
		System.out.println();
	}
	
	public static void go(int count){
		if(answer == 1) return; // 가능한 결과상태이므로 끝내기
		if(count == 15) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] != score[i][j]) {
						return;
					}
				}
			}
			answer = 1;
			return;
		}
		
		// left가 이김
		score[left[count]][0]++;
		score[right[count]][2]++;
		go(count+1);
		score[left[count]][0]--;
		score[right[count]][2]--;
		
		// left가 무승부
		score[left[count]][1]++;
		score[right[count]][1]++;
		go(count+1);
		score[left[count]][1]--;
		score[right[count]][1]--;
		
		// left가 짐
		score[left[count]][2]++;
		score[right[count]][0]++;
		go(count+1);
		score[left[count]][2]--;
		score[right[count]][0]--;
	}

}
