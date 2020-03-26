package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_16235_02 {
	public static int[][] dot = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}}; // 8방
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N]; // 추가할 양분의 양
		int[][] food = new int[N][N]; // 현재 나무 영양분
		for (int i = 0; i < N; i++) { // 배열 채우기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				food[i][j] = 5;
			}
		}
		
		PriorityQueue<Tree> queue = new PriorityQueue<>();
		for (int i = 0; i < M; i++) { // 나무
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			queue.add(new Tree(x,y,age));
		}
		
		Queue<Tree> die = new LinkedList<>(); // 죽는 나무들 담기
		while(K > 0) { // K년만큼 반복
			PriorityQueue<Tree> temp = new PriorityQueue<>(); // queue 임시배열
			while(!queue.isEmpty()) { // 봄, 가을
				Tree t = queue.poll();
				
				if(food[t.x][t.y] >= t.age) { // 먹을 양분 있음
					food[t.x][t.y] -= t.age; // 나무가 자신의 나이만큼 양분 먹기					
					t.age += 1; // 나이 1 증가
					temp.add(t);
					//가을
					if(t.age%5 == 0) { // 나이가 5의 배수
						for (int i = 0; i < dot.length; i++) {
							int dx = t.x + dot[i][0];
							int dy = t.y + dot[i][1];
							
							if(dx < 0 || dy < 0 || dx >= arr.length || dy >= arr[0].length) continue;
							
							temp.add(new Tree(dx,dy,1)); // 나이가 1인 나무 생성
						}
					}
				}else { // 먹을 양분 없음
					die.add(t);
				}
			}
			
			queue = new PriorityQueue<>(temp);
			while(!die.isEmpty()) { // 여름
				Tree t = die.poll();
				food[t.x][t.y] += t.age/2;
			}
			
			for (int i = 0; i < arr.length; i++) { // 겨울 양분추가
				for (int j = 0; j < arr[i].length; j++) {
					food[i][j] += arr[i][j];
				}
			}
			
			K--; // 1년 감소
		}
		
		System.out.println(queue.size());
	}
	
	public static class Tree implements Comparable<Tree>{
		int x,y,age;
		
		public Tree(int x,int y,int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
}
