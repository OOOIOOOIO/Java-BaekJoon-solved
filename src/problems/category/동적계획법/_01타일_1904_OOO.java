package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01타일_1904_OOO {
	static int[] dp = new int[1000000];

	static int check(int N) {
		if(dp[N] != 0) {
			return dp[N];
		}
		else {
			return dp[N] = (check(N-1) + check(N-2)) % 15746;
			
		}
	}
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N은 자리수
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		System.out.println(check(N));
	}

}
/**
 00, 1로만 만든다

 N
 1(1) : 1
 2(2) : 00, 11
 3(3) : 100, 001, 111
 4(5): 0011, 1001, 1100, 0000, 1111
 5(8) : 00111, 10011, 11001, 11100, 00001, 00100, 10000, 11111
 6(13) : 001111, 100111, 110011, 111001, 111100, 000011, 001001, 100001, 100100, 110000
 001100, 000000, 111111

 dp[n] = dp[n-1] + dp[n-2];
 */
