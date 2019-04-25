package SWExpertAcademy;

import java.util.Scanner;

public class N_1244 {
	static int N;
	static int[] arr;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			N = sc.nextInt();
			arr = new int[s.length()];
			result = 0;
			
			for (int i = 0; i < s.length(); i++) {
				arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
			}

			dfs(0,0);

			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static void dfs(int index, int count) {
		if(count == N) {
			result = Math.max(result, changeNum());
			return;
		}
		
		for(int i=index;i<arr.length;i++) {
			for(int j =i+1;j<arr.length;j++) {
				if(arr[i] <= arr[j]) {
					swap(i,j);
					dfs(i, count+1);
					swap(i,j);
				}
			}
		}
	}
	
	public static void swap(int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int changeNum() {
		String str = "";
		for(int i=0;i<arr.length;i++) {
			str += arr[i];
		}
		return Integer.parseInt(str);
	}
}
