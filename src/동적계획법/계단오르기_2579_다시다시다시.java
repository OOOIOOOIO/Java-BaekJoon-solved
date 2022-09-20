package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579_다시다시다시 {
	
	static int[] dp;
	static int[] stair;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n];
		stair = new int[n];
		
		for(int i = 0; i < n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		
		
	
	}
	
	static void solve() {
		
	}
	
}
