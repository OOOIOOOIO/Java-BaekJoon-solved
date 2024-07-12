package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 톱니바퀴_14891{

    static class Gear{
        int num;
        int left;
        int right;

        public Gear(int num, int left, int right){
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void updateGear(int left, int right){
            if(left == 0){
                this.left = 8;
                this.right = right;
            }
            else if(right == 0){
                this.right = 8;
                this.left = left;
            }
            else if(left == 0 && right == 0){
                this.left = 8;
                this.right = 8;
            }
            else{
                this.left = left;
                this.right = right;
            }
        }
    }

    static int K;
    static int[][] map = new int[5][9];
    static int[] history = new int[5];
    static ArrayList<Gear> gearList = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i = 1; i < 5; i++){
            String temp[] = br.readLine().split("");

            for(int j = 1; j < 9; j++){
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        K = Integer.parseInt(br.readLine());

        // 초기값
        for(int i = 0; i < 5; i++){
            gearList.add(new Gear(i, 7, 3));
        }

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            solve(gearNum, dir);
        }

        for(int i = 1; i <= 4; i++){
            getScore(i);
        }


        System.out.println(sum);
    }


    private static void solve(int gearNum, int dir){

        // 현재 기어에서
        // 좌 우 확인 범위,
        Gear currGear = gearList.get(gearNum);

        //좌 확인
        checkLeftGear(currGear, currGear.num-1, dir);
        //우 확인
        checkRightGear(currGear, currGear.num+1, dir);

//        System.out.println(history[1] + " | " + history[2] + " | " + history[3] + " | " + history[4]);
        // 확인 후 회전
        for(int i = 1; i <= 4; i++){

            rotate(i);
        }


    }

    private static void checkLeftGear(Gear currGear, int nextGearNum, int currDir){
        if(nextGearNum < 1){
            return;
        }

        Gear nextGear = gearList.get(nextGearNum);


        // 같다면 현재만 돌리고 이후는 움직이지 않는다.
        if(map[currGear.num][currGear.left] == map[nextGear.num][nextGear.right]){
            history[currGear.num] = currDir;

        }
        else{ // 다르다면 현재, 다음 모두 돌린다
            int nextDir = (currDir * -1);
            history[currGear.num] = currDir;
            history[nextGear.num] = nextDir;
            checkLeftGear(nextGear, nextGear.num - 1, nextDir);

        }

    }


    private static void checkRightGear(Gear currGear, int nextGearNum, int currDir){
        if(nextGearNum > 4){
            return;
        }

        Gear nextGear = gearList.get(nextGearNum);


        // 같다면 현재만 돌리고 이후는 움직이지 않는다.
        if(map[currGear.num][currGear.right] == map[nextGear.num][nextGear.left]){
            history[currGear.num] = currDir;

        }
        else{ // 다르다면 현재, 다음 모두 돌린다
            int nextDir = (currDir * -1);
            history[currGear.num] = currDir;
            history[nextGear.num] = nextDir;

            checkRightGear(nextGear, nextGear.num + 1, nextDir);

        }

    }


    // 현재의 왼쪽과 다음의 오른쪽 비교
    private static void rotate(int gearNum){
        Gear gear = gearList.get(gearNum);

        if(history[gear.num] == 1){ // 시계 방향
            gear.updateGear((gear.left - 1) % 8, (gear.right - 1) % 8);
        }
        else if(history[gear.num] == -1){ // 반시계 방향
            gear.updateGear((gear.left + 1) % 8, (gear.right + 1) % 8);
        }

        // 초기화
        history[gear.num] = 0;

    }


    private static void getScore(int idx){

        int tw = (gearList.get(idx).left + 2) % 8;

        if(tw == 0) tw = 8;

        if(map[idx][tw] == 1){
            if(idx == 1){
                sum += 1;
            }
            else if(idx == 2){
                sum += 2;
            }
            else if(idx == 3){
                sum += 4;
            }
            else{
                sum += 8;
            }
        }
    }


}