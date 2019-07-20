package SWExpertAcademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_5650 {
	static int[][] arr;
	static int result;
	static String[] wormHole;
	static Queue<DOT> queue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			queue = new LinkedList<>();
			wormHole = new String[10]; // �ִ� 5��
			result = 0;
			
			for (int i = 0; i < N; i++) { // �迭 ������ ����
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 0) { // �ɺ� ���� �� �ִ� ��ġ
						queue.add(new DOT(i,j,0));
					}else if(arr[i][j] > 5) { // ��Ȧ�̸�
						String str = i+","+j;
						if(wormHole[arr[i][j] - 1] == null) {
							wormHole[arr[i][j] - 1] = str;	
						}else {
							wormHole[arr[i][j] - 6] = str;		
						}
					}
				}
			}
			selectFinbol();
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static void selectFinbol() {
		while(!queue.isEmpty()) { // ��ġ ����
			DOT d = queue.poll(); 
			
			for(int i =0;i<4;i++) { // ���� ����
				moveFinbol(d.x,d.y,d.x,d.y,i);
			}
		}
	}
	
	//��Ȧ �ݺ� ���� �ٽ� ¥�� ��
	public static void moveFinbol(int sx,int sy,int x,int y,int dir) { 
		boolean check = false; // ó�� ��� üũ
		int score = 0;
		String[] temp;
		DOT d = null;
		while(!check || ((!(sx == x && sy == y)) && arr[x][y] != -1)) { // ó�� ��ġ�� Ȥ�� ��Ȧ�̸� ����
			check = true;	
			int tx = x;
			int ty = y;
			
			if(arr[x][y] > 5) { // ��Ȧ�̸�
				if(wormHole[arr[x][y]-1].equals(x+","+y)) { // ���� ��Ȧ�� �ݴ����� �ƴϸ� �ݴ��� ��Ȧ�� ���
					temp = wormHole[arr[x][y]-6].split(",");
				}else { // ���� ��Ȧ�� �ݴ����̸�
					temp = wormHole[arr[x][y]-1].split(",");
				}
				x = Integer.parseInt(temp[0]);
				y = Integer.parseInt(temp[1]);
				tx = x;
				ty = y;
			}
			
			if(dir == 0) { // ��
				if(arr[x][y] != 0 && arr[x][y] < 6) { // ���̸�
					d = meetBlock(x, y,dir);
					dir = d.dir;
					x = d.x;
					y = d.y;
					score++;
				}else  { // ����� �̸�
					x = x - 1;
				}
			}else if(dir == 1) { // ��
				if(arr[x][y] != 0 && arr[x][y] < 6) { // ���̸�
					d = meetBlock(x, y,dir);
					dir = d.dir;
					x = d.x;
					y = d.y;
					score++;
				}else { // ����� �̸�
					x = x + 1;
				}
			}else if(dir == 2) { // ��
				if(arr[x][y] != 0 && arr[x][y] < 6) { // ���̸�
					d = meetBlock(x, y,dir);
					dir = d.dir;
					x = d.x;
					y = d.y;
					score++;
				}else { // ����� �̸�
					y = y - 1;
				}
			}else { // ��
				if(arr[x][y] != 0 && arr[x][y] < 6) { // ���̸�
					d = meetBlock(x, y,dir);
					dir = d.dir;
					x = d.x;
					y = d.y;
					score++;
				}else { // ����� �̸�
					y = y + 1;
				}
			}
			
			if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) { // ���̸� ���� �ݴ��, ��ġ �������, ���� ����
				if(dir == 0 || dir == 2) {
					dir = dir + 1;
				}else if(dir == 1 || dir == 3) {
					dir = dir - 1;
				}
				score++;
				x = tx;
				y = ty;
			}
		}
		result = Math.max(score, result);
	}

	public static DOT meetBlock(int x, int y,int dir) { // �� ������ ���� �ٲ��ֱ�
		if(dir == 0) { // ��
			if(arr[x][y] == 2) { // �밢�� �κ�
				return new DOT(x,y+1,3);
			}else if(arr[x][y] == 3){
				return new DOT(x,y-1,2);
			}else {
				return new DOT(x+1,y,1);
			}
		}else if(dir == 1) { // ��
			if(arr[x][y] == 1) { // �밢�� �κ�
				return new DOT(x,y+1,3);
			}else if(arr[x][y] == 4){
				return new DOT(x,y-1,2);
			}else {
				return new DOT(x-1,y,0);
			}
		}else if(dir == 2) { // ��
			if(arr[x][y] == 1) { // �밢�� �κ�
				return new DOT(x-1,y,0);
			}else if(arr[x][y] == 2){
				return new DOT(x+1,y,1);
			}else {
				return new DOT(x,y+1,3);
			}
		}else{ // ��
			if(arr[x][y] == 3) { // �밢�� �κ�
				return new DOT(x+1,y,1);
			}else if(arr[x][y] == 4){
				return new DOT(x-1,y,0);
			}else {
				return new DOT(x,y-1,2);
			}
		}

	}
	
	
	public static class DOT{
		int x,y,dir;
		
		public DOT(int x,int y,int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}

