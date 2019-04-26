package SWExpertAcademy;

import java.util.Scanner;

public class N_1952 {
	static int[] cost;
	static int[] plan;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			cost = new int[4];
			for(int i=0;i<4;i++) {
				cost[i] = sc.nextInt();
			}
			
			plan = new int[12];
			for(int i=0;i<12;i++) {
				plan[i] = sc.nextInt();
			}
			
			result = Integer.MAX_VALUE;
			getMin(0,0);
			System.out.println("#"+test_case+" "+result);
		}
	}
	
	public static void getMin(int total,int i) {
		if(i > 11) {
			result = Integer.min(result, total);
			return;
		}
		
		if(plan[i] == 0) getMin(total,i+1);
		
		for(int j=0;j<cost.length;j++) {
			if(j == 0) { // 1일 이용권
				getMin(total + (cost[j] * plan[i]),i+1);
			}else if(j == 1) {
	     		getMin(total + cost[j],i+1);
			}else if(j == 2) {
				getMin(total + cost[j],i+3);
			}else if(j == 3 && i == 0){
				getMin(total + cost[j],12);
			}else {
				return;
			}
		}
	}
	
}
