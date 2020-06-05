package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_1194 {
	public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int[] keyNum = {1,2,4,8,16,32};
	public static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		Queue<DOT> queue = new LinkedList<>();
		boolean[][][] visited =new boolean[N][M][65];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == '0') {
					queue.add(new DOT(i,j,0,0));				
					visited[i][j][0] = true;
				}
			}
		}

		int answer = -1;
		while(!queue.isEmpty()) {
			DOT d = queue.poll();
			
			if(arr[d.x][d.y] == '1') {
				answer = d.cnt;
				break; // 도착 지점
			}
			
			for (int i = 0; i < dot.length; i++) {
				int dx = d.x + dot[i][0];
				int dy = d.y + dot[i][1];
				
				if(dx<0|| dy<0 || dx>=arr.length || dy>=arr[0].length || arr[dx][dy] == '#') continue;
				
				sb = new StringBuffer(Integer.toBinaryString(d.key));
				if(arr[dx][dy] >= 'A' && arr[dx][dy] <='F') { // 대문자
					int key = arr[dx][dy] - 'A';
//					if(!d.contatinsKey(keyNum[key])) continue;
					String str = sb.reverse().toString();
					if(str.length() <= key || str.charAt(key) == '0') continue;
					
					if(!visited[dx][dy][d.key]) {
						visited[dx][dy][d.key] = true;
						queue.add(new DOT(dx,dy,d.cnt+1,d.key));
					}
				}else if(arr[dx][dy] >= 'a' && arr[dx][dy] <='f') { // 소문자
					int key = arr[dx][dy] - 'a';
					int tmpKey = d.key;
					String str = sb.reverse().toString();
					if(str.length() <= key || str.charAt(key) == '0') {
						tmpKey += keyNum[key];
					}
//					if(!d.contatinsKey(keyNum[key])) {
//						tmpKey += keyNum[key];
//					}
					if(!visited[dx][dy][tmpKey]) {
						visited[dx][dy][tmpKey] = true;
						queue.add(new DOT(dx,dy,d.cnt+1,tmpKey));						
					}
				}else{
					if(visited[dx][dy][d.key]) continue;
					visited[dx][dy][d.key] = true;
					queue.add(new DOT(dx,dy,d.cnt+1,d.key));
				}
			}
		}
		System.out.println(answer);
	}
	
	public static class DOT{
		int x,y,cnt,key;

		public DOT(int x,int y,int cnt,int key) {
			this.x = x;
			this.y= y;
			this.cnt = cnt;
			this.key = key;
		}
		
//		boolean contatinsKey(int k) {
//			if(key % (k*2)/k == 1) return true;
//			return false;
//		}
	}
}
