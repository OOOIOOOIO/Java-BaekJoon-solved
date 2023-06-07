package problems.category.백트래킹;

import java.util.*;
import java.io.*;
public class 알파벳_1987 {

    static int R;
    static int C;
    static int[][] map;
    static boolean[] alpha;
    static int[] dy = {-1, 1, 0, 0}; // 상 좌 하 우
    static int[] dx = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 알파벳은 26개 A = 65, a = 97
        alpha = new boolean[26];

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = temp.charAt(j) - 'A';
            }
        }

        backTracking(0, 0, 1);

        System.out.println(max);

    }

    static void backTracking(int y, int x, int cnt){
        alpha[map[y][x]] = true; // 이동시 true

        max = Math.max(max, cnt);

        // 4방향을 돈다
        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            // 범위
            if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C){
                if(!alpha[map[nextY][nextX]]){
                    alpha[map[y][x]] = true; // 이동시 true
                    backTracking(nextY, nextX, cnt+1); // ++, +1은 다르다
                    alpha[map[nextY][nextX]] = false;
                }
            }
        }
    }
}

