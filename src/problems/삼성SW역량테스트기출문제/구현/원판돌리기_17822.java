package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 원판돌리기_17822{


    static int N, M, T;

    static int[][] plate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        plate = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 0:시계방향 | 1:반시계방향
            int k = Integer.parseInt(st.nextToken());

            // 회전
            rotate(x, d, k);
        }


        // 접한 애들 삭제
        delete();

        // 평균값 구하기
        int ans = getAvg();

        System.out.println(ans);

    }

    // 회전
    private static void rotate(int x, int d, int k){

        // 원판
        for(int i = x; i <= N; i *= 2){
            // 회전수
            for(int j = 0; j < k; j++){
                // 시계 방향
                if(d == 0){
                    int temp = plate[i][N];
                    for(int r = 1; r < N; r++){
                        plate[i][r+1] = plate[i][r];

                    }
                    plate[i][1] = temp;
                }
                else{ // 반시계 방향
                    int temp = plate[i][1];
                    for(int r = N; r > 1; r--){
                        plate[i][r-1] = plate[i][r];
                    }
                    plate[i][N] = temp;
                }

            }
        }

    }

    private static void delete(){
        // 원판 안에 인접
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                // 왼쪽 끝
                if(j == 1){
                    boolean flagA = false;
                    boolean flagB = false;
                    if(plate[i][j] > 0 && plate[i][N] > 0 && plate[i][j] == plate[i][N]){
                        flagA = true;
                    }

                    if(plate[i][j] > 0 && plate[i][j+1] > 0 && plate[i][j] == plate[i][j+1]){
                        flagA = true;
                    }

                    if(flagA){
                        plate[i][j] = -1;
                        plate[i][N] = -1;
                    }
                    if(flagB){
                        plate[i][j] = -1;
                        plate[i][j+1] = -1;
                    }


                }
                // 오른쪽 끝
                else if(j == N){
                    boolean flagA = false;
                    boolean flagB = false;
                    if(plate[i][j] > 0 && plate[i][N-1] > 0 && plate[i][j] == plate[i][N-1]){
                        flagA = true;
                    }

                    if(plate[i][j] > 0 && plate[i][1] > 0 && plate[i][j] == plate[i][1]){
                        flagA = true;
                    }

                    if(flagA){
                        plate[i][j] = -1;
                        plate[i][N-1] = -1;
                    }
                    if(flagB){
                        plate[i][j] = -1;
                        plate[i][1] = -1;
                    }

                }
                else{
                    boolean flagA = false;
                    boolean flagB = false;
                    if(plate[i][j] > 0 && plate[i][j-1] > 0 && plate[i][j] == plate[i][j-1]){
                        flagA = true;
                    }

                    if(plate[i][j] > 0 && plate[i][j+1] > 0 && plate[i][j] == plate[i][j+1]){
                        flagA = true;
                    }

                    if(flagA){
                        plate[i][j] = -1;
                        plate[i][j-1] = -1;
                    }
                    if(flagB){
                        plate[i][j] = -1;
                        plate[i][j+1] = -1;
                    }

                }
            }

        }


        // 바깥 원통 비교
        for(int i = 1; i <= M; i++){
            for(int j = 1; j < N; j++){ // +1할거임
                if(plate[i][j] > 0){
                    if(plate[i][j] == plate[i][j+1]){
                        plate[i][j] = -1;
                        plate[i][j+1] = -1;
                    }
                }

            }
        }



    }


    private static int getAvg(){
        //일단 평균 구하기
        int cnt = 0;
        int sum = 0;
        int[] score = new int[N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(plate[i][j] > 0){
                    cnt++;
                    sum += plate[i][j];
                }
            }
            score[i] = sum;
        }

        int avg = sum / cnt;

        // 점수 구하기
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(score[i] > avg){
                score[i]--;
            }
            else if(score[i] < avg){
                score[i]++;
            }

            ans += score[i];

        }


        return ans;

    }



}




