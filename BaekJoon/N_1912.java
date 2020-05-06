package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] memo = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		memo[0] = arr[0];
		int answer = memo[0];
		for (int i = 1; i < memo.length; i++) {
			memo[i] = Math.max(memo[i-1] + arr[i], arr[i]);
			answer = Math.max(answer, memo[i]);
		}

		System.out.println(answer);
	}

}
