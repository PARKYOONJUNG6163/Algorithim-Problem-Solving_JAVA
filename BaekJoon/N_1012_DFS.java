package BaekJoon;
// 116ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_1012_DFS {
	public static boolean[][] arr;
	public static int answer;
	public static boolean[][] visited;
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 배추 개수
			
			arr = new boolean[N][M];
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				int[] temp = new int[2];
				st = new StringTokenizer(br.readLine());
				temp[1] = Integer.parseInt(st.nextToken());
				temp[0] = Integer.parseInt(st.nextToken());
				arr[temp[0]][temp[1]] = true;
				list.add(temp);
			}
			
			answer = 0;
			visited = new boolean[N][M];
			for (int[] temp : list){
				if(!visited[temp[0]][temp[1]]) {
					go(temp[0], temp[1]);
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
	
	public static void go(int x,int y) {
		visited[x][y] = true;
		for (int i = 0; i < dot.length; i++) {
			int dx = x + dot[i][0];
			int dy = y + dot[i][1];
			
			if(dx <0||dy<0||dx>=arr.length||dy>=arr[0].length||!arr[dx][dy]||visited[dx][dy]) continue;
			
			go(dx,dy);
		}
	}
}
