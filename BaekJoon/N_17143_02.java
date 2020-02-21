package SSAFY;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class N_17143 {
	public static int[][] dot = {{-1,0},{1,0},{0,1},{0,-1}};
	public static Queue<Shark> queue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt();
		
		queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int x= sc.nextInt();
			int y = sc.nextInt();
			int speed = sc.nextInt();
			int dir = sc.nextInt(); // 1»ó 2ÇÏ 3¿À 4¿Þ
			int size = sc.nextInt();
			queue.add(new Shark(x,y,speed,dir,size));
		}
		int result = 0;
		int index = 0;
		while(index <= C) {
			index++; // ³¬½Ã¿Õ ÇÑÄ­ ÀÌµ¿
			
			Shark remove_shark = null;
			for (Shark s : queue) { // Á×ÀÏ »ó¾î °í¸£±â
				if(s.y == index) {
					if(remove_shark == null) {
						remove_shark = s;
					}else {
						if(remove_shark.x > s.x) {
							remove_shark = s;
						}
					}
				}
			}
			
			if(remove_shark != null) { // »ó¾î Á×ÀÌ±â
				result+= remove_shark.size;
				queue.remove(remove_shark);
			}
			
			PriorityQueue<Shark> pq = new PriorityQueue<>();
			while(!queue.isEmpty()) { // »ó¾î ÀÌµ¿
				Shark s = queue.poll();
				int dx = s.x + (dot[s.dir][0]*s.speed);
				int dy = s.y + (dot[s.dir][1]*s.speed);
				
				if(dx < 1 || dy < 1 || dx > R || dy > C) {
					if(s.dir == 1 || s.dir == 3) {
						s.dir +=1;
					}else {
						s.dir -=1;
					}
				}
				
				pq.add(s);
			}
			
			HashMap<String,Shark> hm = new HashMap<>(); // °°Àº °÷ °í±â Á×ÀÌ±â
			for(Shark s : pq) {
				String str = s.x+","+s.y;
				if(!hm.containsKey(str)) {
					hm.put(str, s);
				}
			}
			
			queue = new LinkedList<>(hm.values());
		}
	}
	
	public static class Shark implements Comparable<Shark>{
		int x,y,speed,dir,size;
		
		public Shark(int x,int y,int speed, int dir, int size) {
			this.x= x;
			this.y =y;
			this.speed = speed;
			this.dir= dir;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return this.size - o.size;
		}
	}
}
