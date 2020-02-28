package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N_2115 {
	public static int[][] arr;
	public static int[] temp;
	public static int result;
	public static int M;
	public static int C;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<Honey> list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j+M <= arr[i].length; j++) {
					result = arr[i][j] * arr[i][j]; // 수익
					int sumC = arr[i][j]; // 채취한 꿀의 양
					int index = j+1;
					int count = 1; // 벌꿀 채집 개수
					temp = new int[M]; // 채취 가능 꿀의 양 검사
					int temp_index = 1;
					temp[0] = j;
					while(count < M) {
						temp[temp_index++] = index;
						sumC += arr[i][index];
						result += (arr[i][index] * arr[i][index]);
						count++;
						index++;
					}
					
					if(sumC > C) { // 채취 가능 꿀의 양 넘어가면
						result = 0;
						go(0,i,0,0); // 경우의 수로 최대 결과 찾기
					}
					
					list.add(new Honey(i+","+j,result)); // 수익 넣기
				}
			}
			
			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < list.size(); i++) {
				Honey hi = list.get(i);
				int ix = Integer.parseInt(hi.str.split(",")[0]);
				int iy = Integer.parseInt(hi.str.split(",")[1]);
				for (int j = i+1; j < list.size(); j++) {
					Honey hj = list.get(j);
					int jx = Integer.parseInt(hj.str.split(",")[0]);
					int jy = Integer.parseInt(hj.str.split(",")[1]);
					if(ix == jx && Math.abs(jy-iy) < M) continue;
					answer = Math.max(answer, hi.total + hj.total);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void go(int index,int row,int sumC,int total) {
		if(sumC <= C) { // 종료조건
			result = Math.max(total, result);
		}
		
		for (int i = index; i < temp.length; i++) {
			go(i+1,row, sumC+arr[row][temp[i]], total+(arr[row][temp[i]]*arr[row][temp[i]]));
		}
	}
	
	public static class Honey{
		String str;
		int total;
		public Honey(String str,int total) {
			this.str=  str;
			this.total = total;
		}
	}
}
