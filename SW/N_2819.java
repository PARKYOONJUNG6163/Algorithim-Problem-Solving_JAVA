package SWExpertAcademy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class N_2819 {
	static int dot[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // »óÇÏÁÂ¿ì
	static String[][] arr;
	static List<String> list;
	static String str = "";
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			arr = new String[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			list = new ArrayList<String>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
						dfs(i,j,str,count);						
				}
			}
			
			HashSet<String> data = new HashSet<String>(list);
			list = new ArrayList<String>(data);
			System.out.println("#"+test_case+" "+list.size());
		}
	}

	public static void dfs(int x, int y, String str,int count) {
		if(count == 7) {
			list.add(str);
			return;
		}

		str += arr[x][y];
		count++;
		
		for (int i = 0; i < 4; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx < 0 || dy < 0 || dx >= arr.length || dy >= arr.length) continue;
			
			dfs(dx,dy,str,count);
		}
	}

}
