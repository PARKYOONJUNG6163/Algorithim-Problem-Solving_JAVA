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
			int s = sc.nextInt(); // ����
			int n = sc.nextInt(); // ���� ��

			if (s == 1) { // ����
				for (int j = 1; j < arr.length; j++) {
					if (j % n == 0) { // �ڱⰡ ���� ���� ����̸�
						arr[j] = Math.abs(arr[j] - 1); // ����ġ ���� ����
					}
				}
			} else { // ����
				arr[n] = Math.abs(arr[n] - 1); // ����ġ ���� ����
				int left = n - 1;
				int right = n + 1;
				while (true) {
					if (left <= 0 || right >= arr.length || arr[left] != arr[right])
						break;
					arr[left] = Math.abs(arr[left] - 1); // ����ġ ���� ����
					arr[right] = Math.abs(arr[right] - 1); // ����ġ ���� ����
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
