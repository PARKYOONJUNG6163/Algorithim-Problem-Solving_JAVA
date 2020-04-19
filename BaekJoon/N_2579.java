package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class N_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N+1];
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		int[] memo = new int[N+1];
		if(N == 1) {
			memo[1] = score[1];
		}else if(N==2) {
			memo[1] = score[1];
			memo[2] = Math.max(score[1]+score[2], score[2]);
		}else {
			memo[1] = score[1];
			memo[2] = Math.max(score[1]+score[2], score[2]);
			memo[3] = Math.max(score[1]+score[3], score[2]+score[3]);
			for (int i = 4; i <= N; i++) {
				memo[i] = Math.max(memo[i-3]+score[i-1]+score[i], memo[i-2]+score[i]);
			}
		}
		System.out.println(memo[N]);
	}

}
