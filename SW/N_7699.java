package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N_7699 {
	public static char[][] arr;
	public static HashSet<Character> hs;
	public static int answer;
	public static int maxNum;
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr = new char[R][C];
			HashSet<Character> temp = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = str.charAt(j);
					if(!temp.contains(arr[i][j])) temp.add(arr[i][j]);
				}
			}
			maxNum = temp.size();
			answer = 0;

			hs = new HashSet<>();
			hs.add(arr[0][0]);
			go(0,0);

			
			System.out.println("#"+ test_case +" " + answer);
		}
	}
	
	public static void go(int x, int y) {
		answer = Math.max(answer, hs.size());
		if(answer >= maxNum) return;
		for (int k = 0; k < dot.length; k++) {
			int dx = x + dot[k][0];
			int dy = y + dot[k][1];
			
			if(dx <0 || dy <0 || dx>= arr.length || dy >= arr[0].length || hs.contains(arr[dx][dy])) continue;
			
			hs.add(arr[dx][dy]);
			go(dx,dy);
			hs.remove(arr[dx][dy]);
		}
	}
}
