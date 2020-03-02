package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1247 {
	public static DOT[] custom;
	public static boolean[] visited;
	public static DOT home;
	public static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			DOT work = new DOT(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home= new DOT(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			custom = new DOT[N];
			visited = new boolean[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				custom[i] = new DOT(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			go(work.x,work.y,0,0);
			System.out.println("#"+test_case +" "+answer);
		}
	}
	
	public static void go(int x,int y,int dist,int count) {
		if(count >= visited.length) {
			answer = Math.min(answer, dist+Math.abs(home.x-x) + Math.abs(home.y-y));
			return;
		}
		
		for (int i = 0; i < custom.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				go(custom[i].x,custom[i].y,dist+Math.abs(custom[i].x-x) + Math.abs(custom[i].y-y),count+1);
				visited[i]= false;				
			}
		}
	}
	
	public static class DOT{
		int x,y;
		
		public DOT(int x,int y) {
			this.x = x;
			this.y =y;
		}
	}
}
