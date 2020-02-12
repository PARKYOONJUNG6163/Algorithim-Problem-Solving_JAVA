import java.util.Scanner;

public class N_1873 {
	public static int[][] dot = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static char[] dir_str = { '^', 'v', '<', '>' };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] arr = new char[H][W];
			int sx = 0;
			int sy = 0;
			int sdir = 0;
			for (int i = 0; i < arr.length; i++) {
				String str = sc.next();
				String[] temp = str.split("");
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = temp[j].charAt(0);
					switch (arr[i][j]) {
					case '^':
						sx = i;
						sy = j;
						sdir = 0; // 상
						break;
					case 'v':
						sx = i;
						sy = j;
						sdir = 1; // 하
						break;
					case '<':
						sx = i;
						sy = j;
						sdir = 2; // 좌
						break;
					case '>':
						sx = i;
						sy = j;
						sdir = 3; // 우
						break;
					}
				}
			}

			int N = sc.nextInt();
			String str = sc.next();
			String[] input = str.split("");

			for (int i = 0; i < input.length; i++) {
				int dx = sx;
				int dy = sy;
				switch (input[i]) {
				case "U":
					sdir = 0;
					arr[sx][sy] = dir_str[sdir];
					dx = sx + dot[sdir][0];
					dy = sy + dot[sdir][1];

					if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length)
						continue;

					if (arr[dx][dy] == '.') { // 평지라면 들어간다
						arr[sx][sy] = '.';
						arr[dx][dy] = dir_str[sdir];
						sx = dx;
						sy = dy;
					}
					break;
				case "D":
					sdir = 1;
					arr[sx][sy] = dir_str[sdir];
					dx = sx + dot[sdir][0];
					dy = sy + dot[sdir][1];

					if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length)
						continue;

					if (arr[dx][dy] == '.') { // 평지라면 들어간다
						arr[sx][sy] = '.';
						arr[dx][dy] = dir_str[sdir];
						sx = dx;
						sy = dy;
					}
					break;
				case "L":
					sdir = 2;
					arr[sx][sy] = dir_str[sdir];
					dx = sx + dot[sdir][0];
					dy = sy + dot[sdir][1];

					if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length)
						continue;

					if (arr[dx][dy] == '.') { // 평지라면 들어간다
						arr[sx][sy] = '.';
						arr[dx][dy] = dir_str[sdir];
						sx = dx;
						sy = dy;
					}
					break;
				case "R":
					sdir = 3;
					arr[sx][sy] = dir_str[sdir];
					dx = sx + dot[sdir][0];
					dy = sy + dot[sdir][1];

					if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length)
						continue;

					if (arr[dx][dy] == '.') { // 평지라면 들어간다
						arr[sx][sy] = '.';
						arr[dx][dy] = dir_str[sdir];
						sx = dx;
						sy = dy;
					}
					break;
				case "S": // 포탄 발사
					while (true) {
						dx += dot[sdir][0];
						dy += dot[sdir][1];
						if (dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length || arr[dx][dy] == '#') {
							dx -= dot[sdir][0];
							dy -= dot[sdir][1];
							break;
						}
						if (arr[dx][dy] == '*') {
							arr[dx][dy] = '.'; // 평지로
							break;
						}
					}
					break;
				}

			}
			
			System.out.print("#"+test_case +" ");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
