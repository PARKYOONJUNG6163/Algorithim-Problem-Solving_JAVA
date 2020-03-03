package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_8382 {
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			
			int dx = Math.abs(sx - ex);
			int dy = Math.abs(sy - ey);
			if(dx == dy) answer = 2*dx;
			else {
				if(dx > dy) {
					answer = 2 * dy;
				}else {
					answer = 2 * dx;
				}
				
				int temp = Math.abs(dx-dy);
				if(temp%2 == 0) {
					answer += 2 * temp;
				}else {
					answer += 2 * temp -1;
				}
			}
			
			System.out.println("#"+ test_case +" " + answer);
		}
	}
}
