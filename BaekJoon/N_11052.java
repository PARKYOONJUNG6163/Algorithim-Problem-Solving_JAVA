package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] price = new int[N+1];
		int[] memo = new int[N+1];
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			memo[i] = price[i];
		}
		
		for (int i = 1; i <= N; i++) { // °³¼ö
			for (int j = 1; j <= i; j++) {
				memo[i] = Math.max(price[j] + memo[i-j], memo[i]);
			}
		}
		System.out.println(memo[N]);
	}

}
