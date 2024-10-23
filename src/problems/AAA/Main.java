package problems.AAA;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class Main{

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[] dp; //[숫자] = 횟수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[N] = 0; // 시작값
        solve(N, 0);

        System.out.println(dp[1]);



    }

    public static void solve(int num, int cnt){

        // 0이거나 0보다 작을 때 종료
        if(num <= 0){
            return;
        }

        // 1일 때 종료
        if(num == 1){
            dp[num] = Math.min(dp[num], cnt);
            return;
        }

        if(num % 3 == 0){
            dp[num] = Math.min(dp[num], cnt);
            solve(num/3, cnt+1);
        }

        if(num % 2 == 0){
            dp[num] = Math.min(dp[num], cnt);
            solve(num/2, cnt+1);
        }

        dp[num] = Math.min(dp[num], cnt);
        solve(num-1, cnt+1);






    }


}



