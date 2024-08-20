package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 게리맨더링2_17779_X {
    static int N;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];


        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        solve(1, 1);

        System.out.println(ans);

    }


    // d1, d2 조합 생성
    private static void solve(int d1, int d2){

        // 범위를 벗어나면 끝내기
        if(d1 + d2 > N-1){
            return;
        }

        // x, y 돌리기
        makeXYList(d1, d2);

        solve(d1+1, d2);
        solve(d1, d2+1);
        solve(d1+1, d2+1);


    }

    // x, y 돌리기
    private static void makeXYList(int d1, int d2){
        int[][] tempMap = new int[N+1][N+1];

        // 구역 생성
        for(int y = d1 + 1; y <= N - d2; y++){
            for(int x = 1; x <= N - d1 - d2; x++){
                makeOne(x, y, d1, d2, tempMap);
                makeTwo(x, y, d1, d2, tempMap);
                makeThree(x, y, d1, d2, tempMap);
                makeFour(x, y, d1, d2, tempMap);
            }
        }

        getAns(tempMap);

    }

    // 최솟값 최댓값 구하기
    private static void getAns(int[][] tempMap){

        int[] sum = new int[6];

        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                // 5번 구역
                if(tempMap[i][j] == 0){
                    sum[5] += map[i][j];
                }
                else if(tempMap[i][j] == 1){ // 1번 구역
                    sum[1] += map[i][j];
                }
                else if(tempMap[i][j] == 2){ // 2번 구역
                    sum[2] += map[i][j];
                }
                else if(tempMap[i][j] == 3){ // 3번 구역
                    sum[3] += map[i][j];
                }
                else if(tempMap[i][j] == 4){ // 4번 구역
                    sum[4] += map[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < 6; i++){
            if(sum[i] > max) max = sum[i];

            if(sum[i] < min) min = sum[i];
        }

        ans = Math.min(ans, max - min);
    }

    // 1번 구역 생성
    private static void makeOne(int x, int y, int d1, int d2, int[][] tempMap){
        for(int r = 1; r < x + d1; r++){
            for(int c = 1; c <= y; c++){
                tempMap[r][c] = 1;
            }
        }
    }

    // 2번 구역 생성
    private static void makeTwo(int x, int y, int d1, int d2, int[][] tempMap){
        for(int r = 1; r <= x + d2; r++){
            for(int c = y + 1; c <= N; c++){
                tempMap[r][c] = 2;
            }
        }
    }

    // 3번 구역 생성
    private static void makeThree(int x, int y, int d1, int d2, int[][] tempMap){
        for(int r = x + d1; r <= N; r++){
            for(int c = 1; c <= y - d1 + d2; c++){
                tempMap[r][c] = 3;
            }
        }
    }

    // 4번 구역 생성
    private static void makeFour(int x, int y, int d1, int d2, int[][] tempMap){
        for(int r = x + d2 + 1; r <= N; r++){
            for(int c = y -d1 + d2; c <= N; c++){
                tempMap[r][c] = 4;
            }
        }
    }

    // 5번 구역 생성 -> 어차피 남은 곳



}
