package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 낚시왕_17143_X {

    static class Shark{
        int num;
        int y;
        int x;
        int speed;
        int dir;
        int size;
        boolean catched;

        public Shark(int num, int y, int x, int speed, int dir, int size){
            this.num = num;
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.dir = dir; // 1:위, 2:아래, 3:오른쪽, 4:왼쪽
            this.size = size;
            this.catched = false;
        }

        public void changeDir(int cDir){
            if(cDir == 1){
                this.dir = 2;
            }
            else if(cDir == 2){
                this.dir = 1;
            }
            else if(cDir == 3){
                this.dir = 4;
            }
            else{
                this.dir = 3;
            }

        }
        public void changeX(int x){
            this.x = x;
        }
        public void changeY(int y){
            this.y = y;
        }

        public void changePos(int y, int x){
            this.y = y;
            this.x = x;
        }

        public void catched(){
            if(!this.catched) this.catched = !this.catched;
        }

    }

    static int R, C, M;
    static int r, c, s, d, z;
    static ArrayList<Shark> sList = new ArrayList<>();
    static int[][] map;
    static int time = 0;
    static int sum = 0;
    static int[] dy = new int[]{0, -1, 1, 0, 0}; //상, 하, 우, 좌
    static int[] dx = new int[]{0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 상어수

        map = new int[R+1][C+1];
        sList.add(new Shark(0, 0, 0, 0, 0, 0)); // 0번은 X, 1번부터 시작

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken()); // 행
            c = Integer.parseInt(st.nextToken()); // 열
            s = Integer.parseInt(st.nextToken()); // 속력
            d = Integer.parseInt(st.nextToken()); // 방향
            z = Integer.parseInt(st.nextToken()); // 크기

            sList.add(new Shark(i, r, c, s, d, z));
            map[r][c] = i; // shark num 마킹

        }

        for(int j = 1; j <= C; j++){
            fishing(j);
            move();
        }




    }


    // 낚시하기
    private static void fishing(int j){
        for(int i = 1; i <= R; i++){
            if(map[i][j] != 0){
                int sharkNum = map[i][j];
                Shark shark = sList.get(sharkNum);
                sum += shark.size;
                map[i][j] = 0;
                shark.catched();
            }
        }
    }


    // 상어 움직이기
    private static void move(){
        for(Shark shark : sList){
            // 잡히지 않은 애들만
            if(!shark.catched){
                // 좌우로 움직이는 애들, C
                int check = 0;
                if(shark.dir == 3 || shark.dir == 4){


                    // 방향 그대로 움직이기
                    if(check == 0){

                    }
                    else if(check % 2 == 1){ // 홀수

                    }
                    else{ // 짝수

                    }
                }
                else{ // 상하로 움직이는 애들, R

                }
            }
        }
    }




}

