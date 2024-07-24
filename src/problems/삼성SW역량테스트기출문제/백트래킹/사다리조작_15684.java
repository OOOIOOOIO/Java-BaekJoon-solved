package problems.삼성SW역량테스트기출문제.백트래킹;

import java.util.*;
import java.io.*;

public class 사다리조작_15684 {
    private static int n, m, h, answer = 4;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 열
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken()); // 행

        map = new int[h + 1][n + 1];

        int row, col;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
            map[row][col + 1] = 2;
        }

        dfs(1, 0);

        System.out.println((answer != 4) ? answer : -1);
    }

    private static void dfs(int row, int count) {
        if (answer <= count) return;
        else {
            if (check()) {
                answer = count;
                return;
            }
        }

        for (int i = row; i < h + 1; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1; // 가로작대기 시작위치
                    map[i][j + 1] = 2; // 가로작대기 끝위치
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int row = 1, col = i;

            for (int j = 0; j < h; j++) {
                if (map[row][col] == 1) col++;
                else if (map[row][col] == 2) col--;

                row++;
            }

            if (col != i) return false;
        }

        return true;
    }
}
