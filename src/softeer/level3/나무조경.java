package softeer.level3;

import java.io.*;
import java.util.*;

public class 나무조경 {
    static int N;
    static int ans = -1;

    static int[][] map;
    static boolean[][] visited;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];



        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        // dfs 돌리기
        int maxDepth = 4;
        if(N == 2) {
            maxDepth = 2;
        }

        DFS(0, 0, maxDepth);


        System.out.println(ans);
    }


    private static void DFS(int depth, int sum, int maxDepth) {
        if(depth == maxDepth) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;

                for(int k = 0; k < 4; k++) {
                    int ny = dy[k] + i;
                    int nx = dx[k] + j;

                    if(!isAble(ny, nx)) continue;

                    visited[i][j] = true;
                    visited[ny][nx] = true;
                    DFS(depth + 1, sum + map[i][j] + map[ny][nx], maxDepth);
                    visited[i][j] = false;
                    visited[ny][nx] = false;
                }
            }
        }
    }

    private static boolean isAble(int ny, int nx) {
        return ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx];
    } // End of isAble()



}

