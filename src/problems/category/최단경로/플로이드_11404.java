package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4 
 */
public class 플로이드_11404 {
	
	static int n, m;
	static int INF = 1073741823;// 1073741823.5 --> 1073741824 는 오류 int 최대값 넘어감(int max값 / 2 한 값)
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		// 도시 수
		n = Integer.parseInt(br.readLine());
		
		// 버스
		m = Integer.parseInt(br.readLine());
		
		// 생성
		dp = new int[n+1][n+1];
		
		// 초기화
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					dp[i][j] = 0;
					continue;
				}

				dp[i][j] = INF;
				
			}
		}
		
		// 간선 연결
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
//			dp[v1][v2] = cost;
			// 경로가 중복되어 들어올 경우 최단거리 저장 
			dp[v1][v2] = Math.min(dp[v1][v2], cost);
			
		}
		
		floydWarshall();
		
		// 출력
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				// 경로가 없는 경우(동떨어진 노드) 0으로 만들어 주기
				if(dp[i][j] == INF) {
					dp[i][j] = 0;
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		
//		int형  max :2147483647
//		나누기 2를 한 값 : 1073741823.5
		
//		 INF 를 Integer.MAX_VALUE로 하면 경로를 찾으며 INF + INF를 할 경우 최대 범위를 벗어나서
//		-2147483647 가 나온다.
//		System.out.println(Integer.MAX_VALUE);
		
	}
	
	static void floydWarshall(){
		
		for(int k = 1; k <= n; k++) { // 경유
			for(int i = 1; i <= n; i++) { // 시작
				for(int j = 1; j <= n; j++) { // 끝
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
					
//					if(dp[i][j] > dp[i][k] + dp[k][j]) {
//						dp[i][j] = dp[i][k] + dp[k][j];
//					}
					
				}
			}
		}
		
	}
}
