package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {

	static int[] stair;
	static Integer[] dp;

	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		stair = new int[N+1];
		dp = new Integer[N+1];

		for(int i = 1; i <= N; i++){
			int score = Integer.parseInt(br.readLine());

			stair[i] = score;
		}

		dp[0] = stair[0];
		dp[1] = stair[1];

		if(N >= 2){
			dp[2] = stair[1] + stair[2];

		}

		find(N);

		System.out.println(dp[N]);
	}

	static int find(int N){
		if(dp[N] == null){

			dp[N] = Math.max(find(N - 3) + stair[N - 1], find(N - 2)) +stair[N];
		}

		return dp[N];
	}


}
