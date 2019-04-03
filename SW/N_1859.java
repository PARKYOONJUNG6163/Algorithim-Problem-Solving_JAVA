package SWExpertAcademy;

import java.util.Scanner;

public class N_1859 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N= sc.nextInt();
			long total = 0;
			int[] arr = new int[N];
			int max_Index = 0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			
			while(max_Index < arr.length) {
				int price = 0;
				int count = 0;
				int temp = max_Index;
				for(int i=temp;i<arr.length;i++) {
					if(arr[max_Index] < arr[i]) { // Á© ºñ½Ñ³¯ ±¸ÇÏ±â
						max_Index = i;
					}
				}
				if(temp == max_Index) {
					max_Index++;
					continue;
				}
				for(int i=temp;i<max_Index;i++) {
					count++;
					price += arr[i];
				}
				total += arr[max_Index++] * count - price;
			}
			System.out.println("#"+test_case+" "+total);
		}
	}
	}
