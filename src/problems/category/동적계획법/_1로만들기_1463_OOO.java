package problems.category.동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기_1463_OOO {

	static int N;
	static Integer[] dp; //[숫자] = 횟수


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(br.readLine());


		dp = new Integer[N+1]; // 처음 들어온 게 가장 적은 횟수이므로 null인 경우에만 확인할 수 있게

		// bottom-up임, 0,1은 0으로 초기화
		dp[0] = 0;
		dp[1] = 0;
		solve(N);

		System.out.println(dp[N]);



	}

	public static int solve(int num){

		if(dp[num] == null){

			if(num % 3 == 0 && num % 2 == 0){
				dp[num] = Math.min(solve(num-1) + 1, Math.min(solve(num/3) + 1, solve(num/2) + 1));
			}
			else if(num % 3 == 0){
				dp[num] = Math.min(solve(num/3) + 1, solve(num-1) + 1);
			}
			else if(num % 2 == 0){
				dp[num] = Math.min(solve(num/2) + 1, solve(num-1) + 1);
			}
			else{
				dp[num] = solve(num-1) + 1;
			}

		}



		return dp[num];



	}
	 
}