package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9760 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] card = new String[5];
			int[] suit_num = new int[4]; // S D H C
			int[] rank_num = new int[13]; // A T J Q K
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "High card"; // 1~8에 해당 x
			boolean suit_same = false;
			boolean cont = false;
			int[] num = new int[5]; // 동일한 3장 = 몇개 2장 = 몇개
			for (int i = 0; i < 5; i++) {
				card[i] = st.nextToken();
				
				// suit 관리
				if(card[i].charAt(0) == 'S') {
					suit_num[0]++;
					if(suit_num[0] == 5) suit_same = true;
				}else if(card[i].charAt(0) == 'D') {
					suit_num[1]++;
					if(suit_num[1] == 5) suit_same = true;
				}else if(card[i].charAt(0) == 'H') {
					suit_num[2]++;
					if(suit_num[2] == 5) suit_same = true;
				}else {
					suit_num[3]++;
					if(suit_num[3] == 5) suit_same = true;
				}
				
				// 랭크 관리
				if(card[i].charAt(1) == 'A') {
					rank_num[0]++;
				}else if(card[i].charAt(1) == 'T') {
					rank_num[9]++;
				}else if(card[i].charAt(1) == 'J') {
					rank_num[10]++;
				}else if(card[i].charAt(1) == 'Q') {
					rank_num[11]++;
				}else if(card[i].charAt(1) == 'K') {
					rank_num[12]++;
				}else { // 2~9
					rank_num[card[i].charAt(1) - 49]++;
				}
			}
			
			// 동일한 개수 구하기
			for (int i = 0; i < rank_num.length; i++) {
				if(rank_num[i] == 5) {
					num[4]++;
				}else if(rank_num[i] == 4) {
					num[3]++;
				}else if(rank_num[i] == 3) {
					num[2]++;
				}else if(rank_num[i] == 2) {
					num[1]++;
				}else if(rank_num[i] == 1) {
					num[0]++;
				}
			}
			
			// 연속 여부 찾기
			for (int i = 0; i < rank_num.length-3; i++) {
				if(rank_num[i] == 1) { // 연속이려면 값이 1
					int j = 1;
					for (; j < 5; j++) {
						if(i==9 && j == 4) break;
						if(rank_num[i+j] != 1) break;
					}
					if(suit_same && i == 9 && j == 4 && rank_num[0] == 1) cont = true;
					if(j == 5) cont = true; // 연속
				}
				if(cont) break;
			}
			
			
			
			// 결과 찾기
			if(suit_same && cont) { // 1
				answer = "Straight Flush";
			}else if(num[3] == 1) { // 2
				answer = "Four of a Kind";
			}else if(num[2] == 1 && num[1] == 1) {// 3
				answer = "Full House";
			}else if(suit_same) { // 4
				answer = "Flush";
			}else if(!suit_same && cont) { // 5
				answer = "Straight";
			}else if(num[2] == 1) { // 6
				answer = "Three of a kind";
			}else if(num[1] == 2) { // 7
				answer = "Two pair";
			}else if(num[1] == 1) { // 8
				answer = "One pair";
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	
}
