package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9659 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case);
			int N = Integer.parseInt(br.readLine());
			int[][] save = new int[N+1][3]; // t a b
			for (int i = 2; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				save[i][0] = Integer.parseInt(st.nextToken());
				save[i][1] = Integer.parseInt(st.nextToken());
				save[i][2] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				long[] f = new long[N+1];
				f[0] = 1;
				int x = Integer.parseInt(st.nextToken());
				f[1] = x;
				for (int j = 2; j <= N; j++) {
					if(save[j][0] == 1) {
						f[j] = (f[save[j][1]] + f[save[j][2]]) % 998244353;
					}else if(save[j][0] == 2) {
						f[j] = (save[j][1] * f[save[j][2]])% 998244353;
					}else {
						f[j] = (f[save[j][1]] * f[save[j][2]]) % 998244353;
					}
				}
				System.out.print(" " + (f[N] % 998244353));
			}
			System.out.println();
		}
	}

}
