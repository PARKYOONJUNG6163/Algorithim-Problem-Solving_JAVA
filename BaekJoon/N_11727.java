package BaekJoon;

import java.util.Scanner;

public class N_11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] memo = new int[N+1];
		memo[1] = 1;		
		if(N == 2) {
			memo[1] = 1;
			memo[2] = 3;		
		}else if(N > 2){
			memo[1] = 1;
			memo[2] = 3;	
			for (int i = 3; i <= N; i++) {
				memo[i] = (2*memo[i-2] + memo[i-1]) % 10007;
			}
		}
		System.out.println(memo[N]);
	}

}
