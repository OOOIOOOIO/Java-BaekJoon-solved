package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2n타일링_11726 {
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];

		
		if(n < 3) {
			if(n == 1) {
				System.out.println(1);
				
			}
			else {
				System.out.println(2);
				
			}
		}
		else {
			
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2];
				dp[i] %= 10007;
			}
			
			System.out.println(dp[n]);
		}
		
		
		
	}


	static int N;
	static Integer[] dp2;
	public static void main2(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp2 = new Integer[N+2];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(recur(N));
	}

	public static int recur(int N){

		if(dp2[N] != null){
			return dp[N];
		}

		return dp[N] = (recur(N-1) + recur(N-2)) % 10007;
	}
}
