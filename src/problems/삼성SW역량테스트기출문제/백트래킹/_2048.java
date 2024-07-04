package problems.삼성SW역량테스트기출문제.백트래킹;

import java.util.*;
import java.io.*;


public class _2048{

    static int N;
    static int ans = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split(" ");

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }


        game(0);
        System.out.println(ans);


    }


    private static void game(int cnt){
        if(cnt == 5){
            findMax();
            return;
        }

        int[][] copyArr = new int[N][N];

        // 원본복사(깊)
        for(int i = 0; i < N; i++){
            copyArr[i] = map[i].clone();
        }

        for(int i = 0; i < 4; i++){
            move(i); // 방향
            game(cnt+1); // 재귀

            // 원본으로 다시 만들기
            for(int j = 0; j < N; j++){
                map[j] = copyArr[j].clone();
            }
        }


    }

    private static void move(int dir){


        if(dir == 0){ //상
            for(int i = 0; i < N; i++){
                int idx = 0; // 값을 넣을 위치, 초기 위치
                int block = 0; // 최근 옮긴 블록 수

                for(int j = 0; j < N; j++){
                    if(map[j][i] != 0){ //
                        if(block == map[j][i]){ // 같은 거 만났을 때
                            map[idx - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;

                        }
                        else{
                            block = map[j][i];
                            map[j][i] = 0;
                            map[idx][i] = block;
                            idx++;
                        }
                    }
                }
            }
        }
        else if(dir == 1){//하
            for(int i = 0; i < N; i++){
                int idx = N - 1; // 값을 넣을 위치
                int block = 0; // 최근 옮긴 블록 수

                for(int j = N-1; j >= 0; j--){
                    if(map[j][i] != 0){ //
                        if(block == map[j][i]){ // 같은 거 만났을 때
                            map[idx + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;

                        }
                        else{
                            block = map[j][i];
                            map[j][i] = 0;
                            map[idx][i] = block;
                            idx--;
                        }
                    }
                }
            }

        }
        else if(dir == 2){//좌
            for(int i = 0; i < N; i++){
                int idx = 0; // 값을 넣을 위치
                int block = 0; // 최근 옮긴 블록 수

                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0){ //
                        if(block == map[i][j]){ // 같은 거 만났을 때
                            map[i][idx-1] = block * 2;
                            block = 0;
                            map[i][j] = 0;

                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][idx] = block;
                            idx++;
                        }
                    }
                }
            }

        }
        else{//우
            for(int i = 0; i < N; i++){
                int idx = N - 1; // 값을 넣을 위치
                int block = 0; // 최근 옮긴 블록 수

                for(int j = N-1; j >= 0; j--){
                    if(map[i][j] != 0){ //
                        if(block == map[i][j]){ // 같은 거 만났을 때
                            map[i][idx+1] = block * 2;
                            block = 0;
                            map[i][j] = 0;

                        }
                        else{
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][idx] = block;
                            idx--;
                        }
                    }
                }
            }

        }

    }

    private static void findMax() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ans = Math.max(ans, map[i][j]);
            }
        }
    }





}