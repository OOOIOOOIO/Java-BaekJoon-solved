package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {
	static Long[][] dp;
	static long[][] dp2;
	static int N;
	static final long MOD = 1000000000;
	
	// top-down
	static long stair(int digit, int value) {
		// 1자리수일 때 return 탐색 X
		if(digit == 1) {
			return dp[digit][value];
		}
		
		if(dp[digit][value] == null) {
			if(value == 0) {
				dp[digit][value] = stair(digit-1, 1);
			}
			else if(value == 9) {
				dp[digit][value] = stair(digit-1, 8);
			}
			else {
				dp[digit][value] = stair(digit-1, value-1) + stair(digit-1, value+1);
			}
		}
		
		// 모듈러 연산 여기서 한번 해줌으로써 long type의 범위를 벗어나지 않게 해준다.
		return dp[digit][value] % MOD;		
	}
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		long result = 0;
		long result2 = 0;
		
		// N+1 : 자리수가 1부터 시작하기 때문에 idx도 1부터 시작
		dp = new Long[N+1][10];
		dp2 = new long[N+1][10];
		
		// 한자리수들 1로 초기화
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
			dp2[1][i] = 1;
		}
		
		// top-down, value가 1부터 시작하니까 앞자리가 0으로 시작할 일이 없다.
		for(int i = 1; i < 10; i++) {
			result += stair(N, i);
		}
		
		System.out.println(result % MOD);
		
//		
//		bottom-up
//		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp2[i][j] = dp2[i-1][1] % MOD;
				}
				else if(j == 9) {
					dp2[i][j] = dp2[i-1][8] % MOD;
				}
				else {
					dp2[i][j] = (dp2[i-1][j-1] + dp2[i-1][j+1]) % MOD; 
				}
			}
		}
		
		for(int i = 1; i < 10; i++) {
			result2 += dp2[N][i];
		}
		
		System.out.println(result2 % MOD);
	}
}





