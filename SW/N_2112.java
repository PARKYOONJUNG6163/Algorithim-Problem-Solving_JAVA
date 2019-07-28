package SWExpertAcademy;

import java.util.Scanner;

public class N_2112 {
	static int result;
	static int K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int D = sc.nextInt();
			int W = sc.nextInt();
			K = sc.nextInt();
			int[][] arr = new int[D][W];
			result = Integer.MAX_VALUE;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			if(K == 1) { // K�� 1�̸� �˻��� �ʿ� x
				result = 0;
			}else {
				dfs(0,0,arr);				
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static void dfs(int index,int count,int[][] arr) {
		int[] temp = new int[arr[0].length];
		if(result <= count) return; // �ּҰ� ���� ũ�ų� ������ �ٷ� ���� �� ����� �ʿ� ������
		if(index >= arr.length) {
			if(checkFilm(arr)) { // ���� �˻� ���
				result = Math.min(result, count);
			}
			return;
		}
		
		dfs(index+1,count,arr); // �๰ ���� x
		
		for(int j=0;j<arr[0].length;j++) { // �ӽ� ����
			temp[j] = arr[index][j];
		}

		for(int j = 0;j<arr[0].length;j++) {
			arr[index][j]= 0;
		}
		dfs(index+1,count+1,arr); // �๰ ���� A
		
		for(int j = 0;j<arr[0].length;j++) {
			arr[index][j]= 1;
		}
		dfs(index+1,count+1,arr); // �๰ ���� B
		
		for(int j=0;j<arr[0].length;j++) { // �����ϱ�
			arr[index][j] = temp[j];
		}
		
	}

	public static boolean checkFilm(int[][] arr) {
		for(int j=0;j<arr[0].length;j++) {	
			int feature = arr[0][j];
			int count=1;
			boolean check = false;
			for(int i=1;i<arr.length;i++) {
				if(arr[i][j] != feature) { // �ٸ��� ī��Ʈ �ʱ�ȭ, Ư�� �ٲ��ֱ�
					count=1;
					feature = arr[i][j];
					continue;
				}
				count++;
				if(count == K) { // K���� �ٷ� �����ϵ���
					check = true;
					break;
				}
			}
			if(!check) return false; // �� ���̶� ��� ���ϸ� �ٷ� false����
		}
		return true;
	}
}
