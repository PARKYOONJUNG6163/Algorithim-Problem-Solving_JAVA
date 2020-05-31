package BaekJoon;

import java.util.Scanner;

public class N_1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int s = sc.nextInt(); // 성별
			int n = sc.nextInt(); // 받은 수

			if (s == 1) { // 남자
				for (int j = 1; j < arr.length; j++) {
					if (j % n == 0) { // 자기가 받은 수의 배수이면
						arr[j] = Math.abs(arr[j] - 1); // 스위치 상태 변경
					}
				}
			} else { // 여자
				arr[n] = Math.abs(arr[n] - 1); // 스위치 상태 변경
				int left = n - 1;
				int right = n + 1;
				while (true) {
					if (left <= 0 || right >= arr.length || arr[left] != arr[right])
						break;
					arr[left] = Math.abs(arr[left] - 1); // 스위치 상태 변경
					arr[right] = Math.abs(arr[right] - 1); // 스위치 상태 변경
					left -= 1;
					right += 1;
				}
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}

}
