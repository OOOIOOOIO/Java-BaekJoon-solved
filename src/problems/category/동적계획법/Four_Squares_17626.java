package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Four_Squares_17626 {

    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
       int N = Integer.parseInt(br.readLine());
//        int N = 11339;

        dp = new int[N+1]; // 1부터 시작
        dp[0] = 0;
        dp[1] = 1;


        for(int i = 2; i <= N; i++){ // 브루트포스 다 돌림
            int min = Integer.MAX_VALUE;
            for(int j  = 1; j*j <= i; j++){ // 여기서 제곱 조건
                int rest = (int)(i - Math.pow(j,2)); // 나머지
                min = Math.min(min, dp[rest]); //
            }

            dp[i] = min+1; // rest가 0일 경우 1회 시도했으니 + 1
        }

        System.out.println(dp[N]);

    }
}

