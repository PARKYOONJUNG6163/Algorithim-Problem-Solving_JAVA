package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1495 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // °î °³¼ö
		int S = Integer.parseInt(st.nextToken()); // ½ÃÀÛ º¼·ý
		int M = Integer.parseInt(st.nextToken()); // ³ÑÀ¸¸é x
		
		st = new StringTokenizer(br.readLine());
		int[] volume = new int[N+1];
		for (int i = 1; i <= N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] memo = new boolean[N+1][M+1];
		memo[0][S] = true;
		int answer = -1;
		
		for (int i = 1; i < memo.length; i++) { // N
			for (int j = 0; j < memo[i].length; j++) { // M
				if(memo[i-1][j]) {
					if(j-volume[i]>=0) memo[i][j-volume[i]] = true;
					if(j+volume[i]<=M) memo[i][j+volume[i]] = true;
				}
			}
		}
		
		for (int i = memo[0].length-1; i >= 0; i--) {
			if(memo[N][i]) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
