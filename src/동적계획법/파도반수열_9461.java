package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열_9461 {
	static long progression(long[] dp, int n) {
		if(dp[n] != 0) {
			return dp[n];
		}
		else {
//			return dp[n] = dp[n-1] + dp[n-5];
			return dp[n] = progression(dp, n-1) + progression(dp, n-5);
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// 수열 : progression
		long[] dp = null;
		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 1){
				sb.append(1).append("\n");
			}
			else if(num == 2){
				sb.append(1).append("\n");
			}
			else if(num == 3){
				sb.append(1).append("\n");
			}
			else if(num == 4){
				sb.append(2).append("\n");
			}
			else if(num == 5){
				sb.append(2).append("\n");
			}
			else {
				dp = new long[num + 1];
				dp[1] = 1;
				dp[2] = 1;
				dp[3] = 1;
				dp[4] = 2;
				dp[5] = 2;
				sb.append(progression(dp, num)).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}

