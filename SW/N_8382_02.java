package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_8382_02 {
   public static int[][] dot = {{-1,0},{1,0},{0,-1},{0,1}};
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for (int test_case = 1; test_case <= T; test_case++) {
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         int sx = Integer.parseInt(st.nextToken());
         int sy = Integer.parseInt(st.nextToken());
         int ex = Integer.parseInt(st.nextToken());
         int ey = Integer.parseInt(st.nextToken());
         
         int answer = Integer.MAX_VALUE;

         // x가 마이너스면 1 x가 플러스면 0
         // y가 마이너스면 3 y가 플러스면 2
         if(sx < ex) {
            int x = sx;
            int y = sy;
            int count = 0;
            int dir = 1;
            int temp_dir = 2;
            while(true) {
               if(count >= answer) break;
               if(x == ex && y == ey) {
                  answer = Math.min(answer, count);
                  break;
               }
               
               x += dot[dir][0];
               y += dot[dir][1];
               if(dir == 0 || dir == 1) { // 상하
                  if(y <= ey) {
                     dir = 3;
                  }else if(y > ey){
                     dir = 2;
                  }
               }else { // 좌우
                  if(x <= ex) {
                     dir = 1;
                  }else if(x > ex){
                     dir = 0;
                  }
               }
               count++;
            }
         }
         if(sx > ex) {
            int x = sx;
            int y = sy;
            int count = 0;
            int dir = 0;
            int temp_dir = 2;
            while(true) {
               if(count >= answer) break;
               if(x == ex && y == ey) {
                  answer = Math.min(answer, count);
                  break;
               }
               
               x += dot[dir][0];
               y += dot[dir][1];
               if(dir == 0 || dir == 1) { // 상하
                  if(y <= ey) {
                     dir = 3;
                  }else if(y > ey){
                     dir = 2;
                  }
               }else { // 좌우
                  if(x <= ex) {
                     dir = 1;
                  }else if(x > ex){
                     dir = 0;
                  }
               }
               count++;
            }
         }
         if(sy < ey) {
            int x = sx;
            int y = sy;
            int count = 0;
            int dir = 3;
            int temp_dir = 0;
            while(true) {
               if(count >= answer) break;
               if(x == ex && y == ey) {
                  answer = Math.min(answer, count);
                  break;
               }
               
               x += dot[dir][0];
               y += dot[dir][1];
               if(dir == 0 || dir == 1) { // 상하
                  if(y <= ey) {
                     dir = 3;
                  }else if(y > ey){
                     dir = 2;
                  }
               }else { // 좌우
                  if(x <= ex) {
                     dir = 1;
                  }else if(x > ex){
                     dir = 0;
                  }
               }
               count++;
            }
         }
         if(sy > ey) {
            int x = sx;
            int y = sy;
            int count = 0;
            int dir = 2;
            int temp_dir = 0;
            while(true) {
               if(count >= answer) break;
               if(x == ex && y == ey) {
                  answer = Math.min(answer, count);
                  break;
               }
               
               x += dot[dir][0];
               y += dot[dir][1];
               if(dir == 0 || dir == 1) { // 상하
                  if(y <= ey) {
                     dir = 3;
                  }else if(y > ey){
                     dir = 2;
                  }
               }else { // 좌우
                  if(x <= ex) {
                     dir = 1;
                  }else if(x > ex){
                     dir = 0;
                  }
               }
               count++;
            }
         }
         
         if(answer == Integer.MAX_VALUE) answer = 0;
         System.out.println("#"+ test_case +" " + answer);
      }
   }
}
