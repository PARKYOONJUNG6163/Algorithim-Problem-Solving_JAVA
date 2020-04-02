package SWExpertAcademy;
// 큰수는 나중에 더하고, 숫자 중 K개의 큰수들
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_6719 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			double answer = 0;
			int[] score = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			for (int i = score.length-K; i < score.length; i++) {
				answer = (answer + score[i])/2;
			}
			System.out.println("#"+test_case +" "+ answer);
		}
	}
	
}
