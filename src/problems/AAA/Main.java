package problems.AAA;

import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화, 1부터 시작
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String[] temp = br.readLine().split("");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }

        visited[1][1] = true;
        dfs(1, 1, 1, false);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }



    private static void dfs(int y, int x, int cnt, boolean brokenWall){

        if(y == N && x == M){
            ans = Math.min(ans, cnt);
            return;
        }

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 1 && ny <= N && nx >= 1 && nx <= M){
                // 벽인데, 벽을 부순 적이 없는 경우
                if(map[ny][nx] == 1 && !visited[ny][nx] && !brokenWall){
                    brokenWall = true;
                    visited[ny][nx] = true;
                    dfs(ny, nx, cnt+1, brokenWall);
                    visited[ny][nx] = false;
                    brokenWall = false;
                }
                // 벽이 아닌 경우
                if(map[ny][nx] == 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    dfs(ny, nx, cnt+1, brokenWall);
                    visited[ny][nx] = false;
                }
            }
        }

    }

}