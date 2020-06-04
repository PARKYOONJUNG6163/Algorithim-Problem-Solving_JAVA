package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_1766 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] adj = new List[N];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] count = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			count[B]++;
			adj[A].add(B);
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < count.length; i++) {
			if(count[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print((n+1)+ " ");
			for (int i = 0; i < adj[n].size(); i++) {
				count[adj[n].get(i)]--;
				if(count[adj[n].get(i)] == 0) queue.offer(adj[n].get(i));
			}
		}
	}

}
