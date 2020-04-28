package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1781 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HW[] arr = new HW[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int end =Integer.parseInt(st.nextToken()); // 데드라인
			int num =Integer.parseInt(st.nextToken()); // 컵라면수
			arr[i] = new HW(end,num);
		}
		
		Arrays.sort(arr);
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(arr[i].num);
			while(arr[i].end < pq.size()) pq.poll();
		}
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
	
	public static  class HW implements Comparable<HW>{
		int end, num;
		
		public HW(int end,int num) {
			this.end = end;
			this.num = num;
		}

		@Override
		public int compareTo(HW o) {
			// TODO Auto-generated method stub
			if(this.end == o.end) {
				return o.num - this.num;
			}
			return this.end - o.end;
		}
	}
}
