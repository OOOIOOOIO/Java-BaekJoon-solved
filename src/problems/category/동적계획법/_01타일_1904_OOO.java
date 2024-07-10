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
/*
N=1  1

N=2  2

N=3  3

N=4  5
1 : q=2, r=0  1
2 : q=1, r=2  3 
3 : q=0, r=4  1


N=5  8
1 : q=2, r=1  3 
2 : q=1, r=3  4
3 : q=0, r=5 1
r = 0 || q = 0 

N=6  13
1 : q=3, r=0  1
2 : q=2, r=2  6 
3 : q=1, r=4  5 
4 : q=0, r=6  1

 */
