package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_플로이드_1389 {
	static int[][] dp;
	static int N, M;
	static final int INF = 1073741823;// 1073741823.5 --> 1073741824 는 오류, INF + INF를 하면  int 최대값 넘어감(int max값 / 2 한 값)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		int[] result = new int[N+1];
		dp = new int[N+1][N+1];
		
		// 초기화
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) {
					dp[i][j] = 0;
					continue;
				}
				
				dp[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			dp[v1][v2] = 1;
			dp[v2][v1] = 1;
			
			
		}
		floyd_warshall();
		
		int min = INF;
		int minIdx = 0;
		
		for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += dp[i][j];
            }
 
            if (min > total) {
                min = total;
                minIdx = i;
            }
        }
		
		System.out.println(minIdx);
		
		
	}
	
	static void floyd_warshall() {
		
		for(int k = 1; k <= N; k++) { // 경유
			for(int i = 1; i <= N; i++){ // 출발
				for(int j = 1; j <= N; j++) { // 목적
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
	
	}
	
	
	
	
}
