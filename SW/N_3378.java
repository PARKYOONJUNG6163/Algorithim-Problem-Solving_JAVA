package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_3378 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" 0 ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 스타일리쉬 마스터한 사람의 코드 줄 수
			int Q = Integer.parseInt(st.nextToken()); // 내 코드 줄 수
			int[] num = new int[6]; // (,),{,},[,]
			int R = 0;
			int C = 0;
			int S = 0;
			int[] sum = new int[4]; // A+B, A+C, B+C, A+B+C
			for (int i = 0; i < P; i++) {
				String str = br.readLine();
				int j;
				int count = 0; // 들여쓰기 수
				for (j = 0; j < str.length(); j++) {
					if (str.charAt(j) != '.') {
						break;
					}
					count++;
				}

				if (num[4] - num[5] != 0 && num[0] - num[1] == 0 && num[2] - num[3] == 0) {
					S = count / (num[4] - num[5]);
				} else if (num[0] - num[1] != 0 && num[2] - num[3] == 0 && num[4] - num[5] == 0) {
					R = count / (num[0] - num[1]);
				} else if (num[2] - num[3] != 0 && num[4] - num[5] == 0 && num[0] - num[1] == 0) {
					C = count / (num[2] - num[3]);
				}
				
				if (R != 0) {
					if (num[4] - num[5] == 0 && num[2] - num[3] != 0) {
						C = (count - R * (num[0] - num[1])) / (num[2] - num[3]);
					} else if (num[2] - num[3] == 0 && num[4] - num[5] != 0) {
						S = (count - R * (num[0] - num[1])) / (num[4] - num[5]);
					}
				}
				if (S != 0) {
					if (num[2] - num[3] == 0 && num[0] - num[1] != 0) {
						R = (count - S * (num[4] - num[5])) / (num[0] - num[1]);
					} else if (num[0] - num[1] == 0 && num[2] - num[3] != 0) {
						C = (count - S * (num[4] - num[5])) / (num[2] - num[3]);
					}
				} 
				if (C != 0) {
					if (num[4] - num[5] == 0 && num[0] - num[1] != 0) {
						R = (count - C * (num[2] - num[3])) / (num[0] - num[1]);
					} else if (num[0] - num[1] == 0 && num[4] - num[5] != 0) {
						S = (count - C * (num[2] - num[3])) / (num[4] - num[5]);
					}
				}
				
				if(R == 0&& C == 0 && S == 0 && num[2]-num[3] != 0 && (num[0]-num[1] == num[2]-num[3]) && (num[0]-num[1] == num[4]-num[5])) {
					if(count == 60) {
						R = 20;
						C = 20;
						S = 20;
					}else if(count == 3) {
						R = 1;
						C = 1;
						S = 1;
					}
					sum[3] = count / (num[2]-num[3]);
				}else if(R == 0 && C == 0 && num[0]-num[1] != 0 && (num[0]-num[1] == num[2]-num[3])) {
					sum[0] = count/ (num[0]-num[1]);
				}else if(R == 0 && S == 0 && num[0]-num[1] != 0 && (num[0]-num[1] == num[4]-num[5])) {
					sum[1] = count / (num[0]-num[1]);
			    }else if(S == 0 && C == 0 && num[2]-num[3] != 0 && (num[4]-num[5] == num[2]-num[3])) {
			    	sum[2] = count / (num[2]-num[3]);
			    }
				for (; j < str.length(); j++) {
					switch (str.charAt(j)) {
					case '(':
						num[0]++;
						;
						break;
					case ')':
						num[1]++;
						;
						break;
					case '{':
						num[2]++;
						;
						break;
					case '}':
						num[3]++;
						;
						break;
					case '[':
						num[4]++;
						;
						break;
					case ']':
						num[5]++;
						;
						break;
					}
				}
			}

			num = new int[6];
			for (int i = 0; i < Q-1; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					switch (str.charAt(j)) {
					case '(':
						num[0]++;
						;
						break;
					case ')':
						num[1]++;
						;
						break;
					case '{':
						num[2]++;
						;
						break;
					case '}':
						num[3]++;
						;
						break;
					case '[':
						num[4]++;
						;
						break;
					case ']':
						num[5]++;
						;
						break;
					}
				}
				
				if((R == 0 && num[0]-num[1] != 0)) {
					if(num[0]-num[1] == num[2]-num[3] && num[2]-num[3] != 0 && num[4]-num[5] == 0) {
						sb.append((num[0]-num[1]) * sum[0]).append(" ");	
					}else if(num[0]-num[1] == num[4]-num[5] && num[4]-num[5] == 0 && num[2]-num[3] != 0) {
						sb.append((num[0]-num[1]) * sum[1]).append(" ");
					}else {
						sb.append("-1 ");							
					}
				}else if(C == 0 && num[2]-num[3] != 0) {
					if(num[2]-num[3] == num[0]-num[1] && num[0]-num[1] != 0 && num[4]-num[5] == 0) {
						sb.append((num[2]-num[3]) *sum[0]).append(" ");	
					}else if(num[2]-num[3] == num[4]-num[5] && num[4]-num[5] == 0 && num[0]-num[1] != 0) {
						sb.append((num[2]-num[3]) * sum[2]).append(" ");
					}else {
						sb.append("-1 ");
					}
				}else if((S == 0 && num[4]-num[5] != 0)) {
					if(num[4]-num[5] == num[0]-num[1] && num[0]-num[1] != 0 && num[2]-num[3] == 0) {
						sb.append((num[4]-num[5]) * sum[1]).append(" ");	
					}else if(num[4]-num[5] == num[2]-num[3] && num[2]-num[3] == 0 && num[0]-num[1] != 0) {
						sb.append((num[4]-num[5]) * sum[2]).append(" ");
					}else {
						sb.append("-1 ");							
					}
				}else if(R == 0 && C == 0 && S == 0 && num[4]-num[5] == num[1]-num[0] && num[2]-num[3] == num[1]-num[0]){
					sb.append((num[0]-num[1]) * sum[3]).append(" ");
				}else {
					int result = R*(num[0]-num[1]) + C*(num[2]-num[3]) + S*(num[4]-num[5]);
					sb.append(result).append(" ");					
				}
			}
			String str = br.readLine();
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
