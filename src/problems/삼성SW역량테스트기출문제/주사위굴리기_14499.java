package problems.삼성SW역량테스트기출문제;

import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M, X, Y;
    static int[][] map;
    static int[] dice;

    // 동 서 남 북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];  // 처음 주사위의 모든 면은 0

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int order = Integer.parseInt(st.nextToken());
            Simulation(order - 1);
        }

        System.out.println(sb);
    }

    static void Simulation(int dir) {
        int nx = X + dx[dir];
        int ny = Y + dy[dir];

        // 범위를 벗어난 경우 스킵
        if(nx < 0 || ny < 0 || nx >= N || ny >= M)
            return;

        int tmp = dice[5];
        switch (dir) {
            // 동
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            // 서
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            // 남
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;

            // 북
            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
        }

        sb.append(dice[0]).append("\n");

        // 좌표 업데이트
        X = nx;
        Y = ny;

        // 0인경우 주사위 바닥 -> 맵
        if(map[X][Y] == 0) {
            map[X][Y] = dice[5];
        }

        // map이 0이 아닌 경우 맵 -> 주사위 복사, 맵은 0으로 된다.
        else {
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
    }
}

public class 주사위굴리기_14499 {


    static int N, M;
    static int x, y; // 주사위
    static int K;
    static int[][] map;
    static int[] dy = new int[]{0, 0, 0, -1, 1}; // 동 서 북 남
    static int[] dx = new int[]{0, 1, -1, 0, 0};

    static int[] dice = new int[7]; // 초기 0
    static int[][] dicePos = new int[][]{ // [밑면][방향] = 다음 밑면  [5] = 윗면
            {0, 0, 0, 0, 0, 0}, // 0
            {0, 3, 4, 2, 5, 6}, // 1
            {0, 3, 4, 6, 1, 5}, // 2
            {0, 6, 1, 2, 5, 4}, // 3
            {0, 1, 6, 2, 5, 3}, // 4
            {0, 3, 4, 1, 6, 2}, // 5
            {0, 3, 4, 5, 2, 1}, // 6
    };
    static ArrayList<Integer> movingList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // map

        // map 제작
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        // 주사위 움직임 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(st.nextToken());
            movingList.add(num);

        }

        // 자사위 굴리기
        int currX = x;
        int currY = y;
        int base = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < movingList.size(); i++){
            int dir = movingList.get(i);
            int nextY = currY + dy[dir];
            int nextX = currX + dx[dir];

            // 벗어났을 때
            if(nextY > N || nextY < 0 || nextX > M || nextX < 0){

                continue;
            }
            else{
                base = dicePos[base][dir]; // 움직여서 밑면 바꿈

                if(map[nextY][nextX] == 0){
                    map[nextY][nextX] = dice[base]; // 밑면을 map에 복사
                }
                else{
                    dice[base] = map[nextY][nextX];
                    map[nextY][nextX] = 0;
                }

                sb.append(dice[dicePos[base][5]] +"\n"); // 움직인 후 윗면 출력

                currY = nextY;
                currX = nextX;
            }


        }
        System.out.println(sb);

    }





}

































