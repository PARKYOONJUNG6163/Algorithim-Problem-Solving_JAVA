package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1806 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		while(true) {
			if(sum >= S) {
				sum -= arr[start++];
				answer = Math.min(end-start+1, answer);
			}else if(end == N) {
				break;
			}else {
				sum += arr[end++];
			}
		}
		
		System.out.println(answer == Integer.MAX_VALUE? 0 : answer);
	}

}
