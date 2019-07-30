package SWExpertAcademy;

import java.util.ArrayList;
import java.util.Scanner;

public class N_1767 { // �����¿�
	static int[][] dot = {{ -1, 0 }, { 1, 0 } , { 0, -1 },{ 0, 1 }};
	static ArrayList<DOT> corelist;
	static int result;
	static int core;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			corelist = new ArrayList<>();
			boolean[][] visit = new boolean[N][N];
			result = Integer.MAX_VALUE;
			core = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = sc.nextInt();
					// �ھ� �ֱ�,�����ڸ��� �̹� ����Ǿ����Ƿ� ���� ����
					if (num == 1) {
						visit[i][j] = true;
						if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
							corelist.add(new DOT(i, j));
						}
					}
				}
			}
			calLength(visit,0,0,0);
			System.out.println("#" + test_case+ " "+ result);
		}
	}

	public static void calLength(boolean[][] visit,int index,int len,int coreNum) {
		// ������ ��� �ھ� �����ص� ���� max�ھ� ���� ���Ѿ�� �� �ʿ� �����ϱ� return
		// �ð��� ��û �ٿ���
		if((corelist.size() - index + coreNum) < core) return;
		boolean[][] temp = new boolean[visit.length][visit.length];
		if(index == corelist.size()) {
			if(core < coreNum) {
				core = coreNum;
				result = len;
			}else if(core == coreNum) {
				result = Math.min(len, result);
			}
			return;
		}
		
		setArr(visit,temp);
		
		DOT d = corelist.get(index);
		for (int i = 0; i < 4; i++) { // �ھ� 4���� ����
			int count = 0;
			int dx = d.x + dot[i][0];
			int dy = d.y + dot[i][1];
			
			if(!checkRange(dx,dy)) continue;
			
			while(!temp[dx][dy]) {
				temp[dx][dy] = true;
				count++;
				dx += dot[i][0];
				dy += dot[i][1];
				if(!checkRange(dx,dy)) { // ��
					calLength(temp,index+1,len+count,coreNum+1);
					break;
				}
			}
			setArr(visit,temp);
		}
		calLength(temp,index+1,len,coreNum); // �ھ� ���� ���ϱ�
	}
	
	public static void setArr(boolean[][] visit,boolean[][] temp) {
		for(int i=0;i<visit.length;i++) { // �迭 �ʱ�ȭ
			System.arraycopy(visit[i], 0, temp[i], 0, visit[i].length);
		}
	}
	
	public static boolean checkRange(int dx,int dy) {
		if(dx < 0 || dy < 0 || dx >= N || dy >= N) return false;
		return true;
	}

	public static class DOT {
		int x, y;

		public DOT(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
