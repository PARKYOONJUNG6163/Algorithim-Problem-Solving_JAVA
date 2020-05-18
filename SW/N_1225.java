package SWExpertAcademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 0; test_case < 10; test_case++) {
			Queue<Integer> queue = new LinkedList<>();
			int tc = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				queue.offer(n);
			}
			
			boolean check = false;
			
			int minus = 1;
			while(true) {
				int n = queue.poll();
				n -= minus;
				if(n <= 0) {
					check = true;
					n = 0;
				}
				queue.offer(n);
				if(minus == 5) {
					minus = 1;
				}else {					
					minus +=1;
				}
				if(check) {
					break;
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i : queue) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}

