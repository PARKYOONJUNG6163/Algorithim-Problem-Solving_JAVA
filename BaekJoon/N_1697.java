package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dot = {-1,1,2};
		boolean[] visited= new boolean[1000001];
		Queue<DOT> queue= new LinkedList<>();
		visited[N] = true;
		queue.add(new DOT(N,0));
		while(!queue.isEmpty()) {
			DOT now = queue.poll();
			if(now.d == M) {
				System.out.println(now.time);
				break;
			}
			
			for (int i = 0; i < dot.length; i++) {
				int d;
				if(i == 2) {
					d = now.d * dot[i];
				}else {
					d = now.d + dot[i];
				}
				
				if(d < 0 || d > 100000 || visited[d]) continue;
				
				visited[d] = true;
				queue.add(new DOT(d, now.time+1));
			}
		}
	}
	
	public static class DOT{
		int d,time;
		
		public DOT(int d,int time) {
			this.d = d;
			this.time =time;
		}
	}
}
