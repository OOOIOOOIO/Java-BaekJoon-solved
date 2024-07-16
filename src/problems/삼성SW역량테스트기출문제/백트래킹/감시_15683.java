package problems.삼성SW역량테스트기출문제.백트래킹;

import java.util.*;
import java.io.*;

public class 감시_15683 {

    static class CCTV {
        int type;
        int x;
        int y;

        public CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    static List<CCTV> cctvs;
    static int[][] board, copyBoard;
    static int[] directions;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int numOfCCTV, n, m;
    static int min = Integer.MAX_VALUE;

    private static void dfs(int level) {
        if(level == numOfCCTV) {
            copyBoard();

            for (int i = 0; i < numOfCCTV; i++) {
                int d = directions[i];
                CCTV cctv = cctvs.get(i);

                observeCCTV(d, cctv);
            }

            checkSquareArea();

        } else {
            for (int i = 0; i < 4; i++) {
                directions[level] = i;
                dfs(level+1);
            }
        }
    }

    /**
     * cctv의 감시 방향이 d일 때 각 cctv의 방향 개수에 맞추어 감시
     */
    private static void observeCCTV(int d, CCTV cctv) {
        if (cctv.type == 1) {
            observeDirection(cctv, d);
        } else if (cctv.type == 2) {
            if (d == 0 || d == 2) {
                observeDirection(cctv, 0);
                observeDirection(cctv, 2);
            } else {
                observeDirection(cctv, 1);
                observeDirection(cctv, 3);
            }
        } else if (cctv.type == 3) {
            if (d == 3) {
                observeDirection(cctv, 0);
                observeDirection(cctv, 3);
            } else {
                observeDirection(cctv, d);
                observeDirection(cctv, d +1);
            }
        } else if (cctv.type == 4) {
            if (d == 0) {
                observeDirection(cctv, 0);
                observeDirection(cctv, 1);
                observeDirection(cctv, 3);
            } else if (d == 1) {
                observeDirection(cctv, 0);
                observeDirection(cctv, 1);
                observeDirection(cctv, 2);
            } else if(d == 2) {
                observeDirection(cctv, 1);
                observeDirection(cctv, 2);
                observeDirection(cctv, 3);
            } else if (d == 3) {
                observeDirection(cctv, 2);
                observeDirection(cctv, 3);
                observeDirection(cctv, 0);
            }
        } else if (cctv.type == 5) {
            observeDirection(cctv, 0);
            observeDirection(cctv, 1);
            observeDirection(cctv, 2);
            observeDirection(cctv, 3);
        }
    }

    /**
     * cctv를 direction 방향으로 감시한다.
     * @param direction 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
     */
    private static void observeDirection(CCTV cctv, int direction) {
        int nx = cctv.x + dx[direction];
        int ny = cctv.y + dy[direction];

        while(nx >= 0 && nx < n && ny >= 0 && ny < m && copyBoard[nx][ny] != 6) {
            copyBoard[nx][ny] = -1;

            nx += dx[direction];
            ny += dy[direction];
        }
    }

    /**
     * 사각지대의 개수를 구한다.
     */
    private static void checkSquareArea() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyBoard[i][j] == 0) {
                    count++;
                }
            }
        }

        min = Math.min(min, count);
    }

    private static void copyBoard() {
        copyBoard = new int[n][m];

        for (int i = 0; i < n; i++) {
//            System.arraycopy(board[i], 0, copyBoard[i], 0, m);
            copyBoard[i] = board[i].clone();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] >= 1 && board[i][j] <= 5) {
                    cctvs.add(new CCTV(board[i][j], i, j));
                }
            }
        }

        directions = new int[cctvs.size()];
        numOfCCTV = cctvs.size();

        dfs(0);

        System.out.println(min);
    }
}