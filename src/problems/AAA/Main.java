package problems.AAA;

import java.util.*;
import java.io.*;

public class Main{

    static class Foot{
        int right;
        int left;
        int score;

        public Foot(int right, int left){
            this.right = right;
            this.left = left;
            this.score = 0;
        }

        public void updateRight(int right){
            this.right = right;
        }

        public void updateLeft(int left){
            this.left = left;
        }

        public void sumScore(int score){
            this.score += score;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] move = br.readLine().split(" ");

        int ans = solve(move);

        System.out.println(ans);

    }

    /**

     L, R 두개 필요(현재 위치)
     그때그떄 최단거리 비교해서 최신화
     누적합

     */

    //순회
    public static int solve(String[] move){
        Foot foot = new Foot(0, 0);

        for(String m : move){
            int dir = Integer.parseInt(m);

            if(dir == 0) return foot.score;

            //둘 다 0일 경우 : 왼쪽부터
            if(foot.left == 0 && foot.right == 0){
                foot.updateLeft(dir);
                foot.sumScore(2);
            }
            //왼쪽이 0일 경우
            else if(foot.left == 0 && foot.right != 0){
                foot.updateLeft(dir);
                foot.sumScore(2);
            }
            //오른쪽이 0일 경우
            else if(foot.left != 0 && foot.right == 0){
                foot.updateRight(dir);
                foot.sumScore(2);
            }
            //그 외 -> 비교
            else{
                compare(dir, foot);
            }


        }

        return 0;

    }

    // 비교
    // LR둘 다 근접해 있을 경우 왼쪽 옮기기
    public static void compare(int dir, Foot foot){
        int left = foot.left;
        int right = foot.right;
        // 우선 같은 위치인지 확인
        if(dir == left){
            foot.sumScore(1);
            return;
        }

        if(dir == right){
            foot.sumScore(1);
            return;
        }

        // 인접해 있을 경우. 맞은편은 나올 수가 없지.
        if(dir == 1){
            if(left == 2 || left == 4){
                foot.updateLeft(dir);
                foot.sumScore(3);
            }
            else{
                foot.updateRight(dir);
                foot.sumScore(3);
            }
        }
        else if(dir == 2){
            if(left == 1 || left == 3){
                foot.updateLeft(dir);
                foot.sumScore(3);
            }
            else{
                foot.updateRight(dir);
                foot.sumScore(3);
            }

        }
        else if(dir == 3){
            if(left == 2 || left == 4){
                foot.updateLeft(dir);
                foot.sumScore(3);
            }
            else{
                foot.updateRight(dir);
                foot.sumScore(3);
            }
        }
        else {
            if(left == 1 || left == 3){
                foot.updateLeft(dir);
                foot.sumScore(3);
            }
            else{
                foot.updateRight(dir);
                foot.sumScore(3);
            }
        }


    }



}



