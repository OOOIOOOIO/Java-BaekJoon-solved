package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 새로운게임2_17837{

    static class Chess{
        int y;
        int x;
        int dir;
        int seq;

        public Chess(int y, int x, int dir,){
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        public void move(int y, int x){
            this.y = y;
            this.x = x;
        }
        public void changeDir(){
            if(this.dir == 1) this.dir = 2;
            else if(this.dir == 2) this.dir = 1;
            else if(this.dir == 3) this.dir = 4;
            else this.dir = 3;

        }

    }

    static int N, K;
    static int[][] map;
    static int[] dy = new int[]{0, 0, 0, -1, 1}; // 우 : 1, 좌 : 2, 상 : 3, 하 : 4)
    static int[] dx = new int[]{0, 1, -1, 0, 0};
    static List<Chess> chessList = new ArrayList<>();

    /**
     흰 : 0, 빨 : 1, 파 : 2
     행, 열, 방향(우 : 1, 좌 : 2, 상 : 3, 하 : 4)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 맵
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        // 체스말
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            chessList.add(new Chess(y, x, dir));
        }



    }

    public static void solve(){

        int cnt = 0;

        while(cnt < 10001){
            // 모두 모여있는지 확인, 종료
            if(check()){
                System.out.println(cnt);
                return;
            }

            // 이동하려는 칸의 색 확인, 1번부터 ~~
            for(int i = 0; i < K; i++){
                Chess piece = chessList.get(i);

                // 이동할 칸 확인
                int currDir = piece.dir;
                int nextY = piece.y + dy[currDir];
                int nextX = piece.x + dx[currDir];

                // 색에 따라 action 취하기
                // 파
                if(nextY > N && nextX > N){
                    blue();
                }
                else if(map[nextY][nextX] == 2){
                    blue();
                }
                // 흰
                else if(map[nextY][nextX] == 0){
                    white();
                }
                // 빨
                else if(map[nextY][nextX] == 1){
                    red();
                }

            }

            // 횟수 증가
            cnt++;

        }


        // 종료
        if(cnt >= 10001){
            System.out.println(-1);

            return;
        }



    }

    // 흰
    // 이동할 때 올라탄 애들까지 모두 이동
    public static void white(){

    }

    // 빨
    // 이동 후 순서 바꾸기
    public static void red(){

    }

    // 파
    public static void blueAndOut(){

    }

    // 모두 모여있는지 확인
    public static boolean check(){
        int y = chessList.get(0).y;
        int x = chessList.get(0).x;

        for(int i = 1; i < K; i++){
            if(y != chessList.get(i).y || x != chessList.get(i)).x return false;
        }

        return true;
    }



}
