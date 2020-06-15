package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5215_02 {
	public static int[][] food;
	public static int L;
	public static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			food = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			for (int i = 1; i <= N; i++) {
				comb(N,i,0,0);				
			}
			
			System.out.println("#"+test_case+" " + answer);
		}
	}

	// n���� ����(����)�� r��ġ(����)�� �����غ���
	public static void comb(int n, int r,int cal,int score) {		
		if(cal > L) return;
		if (r == 0) { // ���̻� ���� ���� ���� ���
			answer = Math.max(answer, score);
			return;
		}
		if (n < r) { // ���� �̴°� �Ұ����� ���
			return;
		}

		// ����
		comb(n - 1, r - 1, cal + food[n-1][1], score+food[n-1][0]);
		// ����
		comb(n - 1, r, cal, score);
	}
}
