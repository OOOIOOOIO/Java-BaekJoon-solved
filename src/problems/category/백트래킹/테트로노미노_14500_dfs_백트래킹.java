package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로노미노_14500_dfs_백트래킹 {


    static int N;
    static int M;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] map;
    static int max = Integer.MIN_VALUE;


    public static void dfs(int y, int x, int sum, int depth){

        // 4개 만들어지면 끝내기
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // map 안에 있을 때
            if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M){

                // 아직 방문하지 않았을 때
                if(!visited[nextY][nextX]){

                    // ㅜ, ㅏ, ㅓ, ㅗ 일 경우
                    if(depth == 2){
                        visited[nextY][nextX] = true;
                        dfs(y, x, sum + map[nextY][nextX], depth + 1);
                        visited[nextY][nextX] = false;
                    }
                    visited[nextY][nextX] = true;
                    dfs(nextY, nextX, sum + map[nextY][nextX], depth + 1);
                    visited[nextY][nextX] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs 돌리기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);


    }

}

