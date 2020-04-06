package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5607 {
	public static int MOD = 1234567891;
	public static long[] fact;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			fact = new long[1000001];
			fact[0] = 1;
			for (int i = 1; i <= 1000000; i++) {
				fact[i] = (fact[i-1]*i) % MOD;
			}
			
			long answer = (fact[N]*power((fact[R] * fact[N-R]) % MOD, MOD-2)) % MOD;
			
			System.out.println("#"+ test_case + " " + answer);
		}
	}
	
	public static long power(long n, int x) {
		if(x == 0) return 1;
		
		long temp = power(n, x/2);
		long temp2 = (temp*temp) % MOD;
		if(x % 2 == 0) return temp2; // x°¡ Â¦¼ö
		else return (temp2 * n) % MOD; // x°¡ È¦¼ö
	}
}
