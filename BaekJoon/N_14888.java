package BaekJoon;

import java.util.Scanner;

public class N_14888 {
	static int[] num;
	static int[] operator;
	static long max;
	static long min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		num = new int[N];
		operator = new int[4];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
			count += operator[i];
		}
		int[] temp = new int[4];
		max = -987654321;
		min = 987654321;
		calculation(temp, 1, count, num[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calculation(int[] temp,int num_index,int count,long n1) {
		if(num_index == num.length) {
			max = Math.max(max, n1);
			min = Math.min(min, n1);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(i == 0 && temp[i] != operator[i]) {
				temp[i]++;
				calculation(temp,num_index+1,count,n1+(long)num[num_index]);
				temp[i]--;
			}else if(i == 1 && temp[i] != operator[i]) {
				temp[i]++;
				calculation(temp,num_index+1,count,n1-(long)num[num_index]);
				temp[i]--;
			}else if(i == 2 && temp[i] != operator[i]) {
				temp[i]++;
				calculation(temp,num_index+1,count,n1*(long)num[num_index]);
				temp[i]--;
			}else if(i == 3 && temp[i] != operator[i]) {
				temp[i]++;
				calculation(temp,num_index+1,count,n1/(long)num[num_index]);					
				temp[i]--;
			}
		}
	}
}
