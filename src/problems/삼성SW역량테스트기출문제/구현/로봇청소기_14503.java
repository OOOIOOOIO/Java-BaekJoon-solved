package problems.삼성SW역량테스트기출문제.구현;


import java.util.*;
import java.io.*;


public class 로봇청소기_14503{

    static int N, M;

    static int[][] map;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); //y
        int c = Integer.parseInt(st.nextToken()); //x
        int dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dfs(r, c, dir);

        System.out.println(cnt);
    }

    static int[] dy = new int[]{-1, 0, 1, 0}; // 북(0), 동(1), 남(2), 서(3)
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void dfs(int y, int x, int dir){
        map[y][x] = -1;

        //청소
        for(int i = 0; i < 4; i++){

            dir = (dir + 3) % 4;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(nx >= 0 && ny >= 0 && ny < N && nx < M) {
                if(map[ny][nx] == 0) {
                    cnt++;
                    dfs(ny, nx, dir);
                    return; // 노드하나에 대해 청소 끝나면 끝내기
                }
            }
        }

        //후진
        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && by < N && bx < M && map[by][bx] != 1) {
            dfs(by, bx, dir); //후진이니까 바라보는 방향은 유지
        }


    }


}

















































