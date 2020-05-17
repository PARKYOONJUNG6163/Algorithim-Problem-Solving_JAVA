package SWExpertAcademy;

import java.util.Scanner;

public class N_7234 {
	public static int[][] dot = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[][] arr = new int[N][N];
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < B; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x - 1][y - 1]++;
				
				for (int j = 0; j < dot.length; j++) {
					int dx = x - 1;
					int dy = y - 1;
					for (int j2 = 0; j2 < 2; j2++) {
						dx = dx + dot[j][0];
						dy = dy + dot[j][1];

						if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length)
							continue;

						arr[dx][dy]++;
						result = Math.max(result,arr[dx][dy]);
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}
}
