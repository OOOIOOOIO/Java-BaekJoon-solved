package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_냅색문제_12865 {
	
	static int[] weight;
	static int[] value;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물건 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		weight = new int[N];
		value = new int[N];
		dp = new Integer[N][K+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());;
			value[i] = Integer.parseInt(st.nextToken());;
		}
		
		
		System.out.println(knapsack(N-1, K));
	}
	
	public static int knapsack(int i, int k) {
		
		// 범위 밖일 경우
		if(i < 0) return 0;
		
		// 아직 탐색하지 않았다면
		if(dp[i][k] == null) {
			
			// 무게를 넘어갈 경우
			if(weight[i] > k) {
				dp[i][k] = knapsack(i-1, k);
			}
			else {
				dp[i][k] = Math.max(value[i] + knapsack(i-1, k - weight[i]), knapsack(i-1, k));
			}
		}
		
		return dp[i][k];
	}
	
}
