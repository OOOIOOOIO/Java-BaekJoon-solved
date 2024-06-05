package problems.category.동적계획법;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DanceDance_2342 {
    static int ans = 0;
    static int[] arr;
    static int[][][] dp; //1,2,3,4 방향 = [5]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[5][5][arr.length];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }


        System.out.println(solve(0,0,0));
    }

    private static int solve(int left, int right, int idx){

        if(arr[idx] == 0) return 0;

        if(dp[left][right][idx] != -1) return dp[left][right][idx];

        dp[left][right][idx] = Math.min(solve(arr[idx], right, idx + 1) + getScore(left, arr[idx]),
                solve(left, arr[idx], idx + 1) + getScore(right, arr[idx]));

        return dp[left][right][idx];


    }

    private static int getScore(int currPos, int nextPos){
        if(currPos == 0) return 2; // 중심, 2점

        int move = Math.abs(currPos - nextPos);
        int score = 0;

        if(move == 2){ // 반대, 4점
            score = 4;
        }
        else if(move == 1 || move == 3){ // 인점, 3점
            score = 3;
        }
        else if(move == 0){ // 동일, 1점
            score = 1;
        }

        return score;
    }


}

