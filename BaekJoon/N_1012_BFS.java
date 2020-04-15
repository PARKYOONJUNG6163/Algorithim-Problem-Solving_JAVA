package BaekJoon;
// 128ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1012_BFS {
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
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				int[] temp = new int[2];
				st = new StringTokenizer(br.readLine());
				temp[1] = Integer.parseInt(st.nextToken());
				temp[0] = Integer.parseInt(st.nextToken());
				arr[temp[0]][temp[1]] = true;
				queue.offer(temp);
			}
			
			visited = new boolean[N][M];
			answer = 0;
			while(!queue.isEmpty()){
				int[] temp = queue.poll();
				if(visited[temp[0]][temp[1]]) continue;
				answer++;
				Queue<int[]> temp_queue = new LinkedList<>();
				visited[temp[0]][temp[1]] = true;
				temp_queue.offer(temp);
				while(!temp_queue.isEmpty()) {
					int[] t = temp_queue.poll();
					
					for (int i = 0; i < dot.length; i++) {
						int dx = t[0] + dot[i][0];
						int dy = t[1] + dot[i][1];
						
						if(dx<0||dy<0||dx>=arr.length||dy>=arr[0].length||!arr[dx][dy]||visited[dx][dy]) continue;
						
						visited[dx][dy] = true;
						int[] d = {dx,dy};
						temp_queue.offer(d);
					}
				}
			}
			
			System.out.println(answer);
		}
		
	}

}
