package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10775 {
	public static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		for (int i = 0; i < P; i++) {
			int num = Integer.parseInt(br.readLine());
			int p = findSet(num);
			if(p == 0) {
				break;
			}else {
				union(p, p-1);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = findSet(parent[x]);
		}
	}
	
	public static void union(int x,int y) {
		int px = findSet(x);
		int py = findSet(y);

		parent[px] = py;
	}
}
