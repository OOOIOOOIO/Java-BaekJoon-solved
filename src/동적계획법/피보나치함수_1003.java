package 동적계획법;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
	
	static int fibo(int[] dp, int n) {
		if(n == 1 || n == 2) {
			return dp[n] = 1;
		}
		else if(dp[n] != 0) {
			return dp[n];
		}
		else {
			return dp[n]= fibo(dp, n-1) + fibo(dp, n-2);
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			if(N > 2) {
				fibo(dp, N);
				sb.append(dp[N-1] + " " + fibo(dp, N) +"\n");
			}
			else if(N == 0){
				sb.append(1 + " " + 0+"\n");
			}
			else if(N == 1){
				sb.append(0 + " " + 1+"\n");
			}
			else if(N == 2){
				sb.append(1 + " " + 1+"\n");
			}
		}
		System.out.println(sb);
	}
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class 피보나치함수_1003 {
 
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0){
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.println(sb);
	}
	
	static Integer[] fibonacci(int N) {
		// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if(dp[N][0] == null || dp[N][1] == null) {
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			// N = 2일 때 ,fibonacci(2-1) = dp[1]이다. 
			// 따라서 fibonacci(2-1)[0] = dp[1][0]이 된다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
 
	}
 
}
*/