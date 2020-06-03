package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int answer = 0;
		while(true) {
			if(sum >= M) { // sum이면 경우의수 
				if(sum == M) answer++;
				sum -= arr[start++];
			}else if(end == arr.length-1) { // end 끝이면 ㅂㅂ
				break;
			}else {
				sum += arr[++end];
			}
		}
		System.out.println(answer);
	}

}
