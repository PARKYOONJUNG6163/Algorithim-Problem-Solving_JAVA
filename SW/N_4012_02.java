package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_4012_02 {
	public static int[][] food;
	public static boolean[] check;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			for (int i = 0; i < food.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < food[i].length; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			check = new boolean[N];
			go(0,0);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	public static void go(int index,int count) {
		if(count == food.length/2) {
			int total1 = 0;
			int total2 = 0;
			for (int i = 0; i < check.length; i++) {
				if(!check[i]) {
					for (int j = i+1; j < check.length; j++) {
						if(!check[j]) {
							total1 += food[i][j] + food[j][i];							
						}
					}
				}else {
					for (int j = i+1; j < check.length; j++) {
						if(check[j]) {
							total2 += food[i][j] + food[j][i];							
						}
					}					
				}
			}
			answer = Math.min(answer, Math.abs(total1-total2));
			return;
		}
		
		for (int i = index; i < food.length; i++) {
			if(!check[i]) {
				check[i] = true;
				go(i+1,count+1);
				check[i] = false;
			}
		}
	}
}

