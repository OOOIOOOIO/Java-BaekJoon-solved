package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신_벨멘포드_11657 {
	
	static StringBuilder sb = new StringBuilder();
	static long[] dp;
	static ArrayList<Edge> graph ;
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	
	
	static class Edge{
		int node_1;
		int node_2;
		int cost;
		
		public Edge(int node_1, int node_2, int cost) {
			this.node_1 = node_1;
			this.node_2 = node_2;
			this.cost = cost;
		}
	}
	

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		// 도시
		N = Integer.parseInt(st.nextToken());
		// 버스
		M = Integer.parseInt(st.nextToken());
		
		// 선언
		dp = new long[N+1];
		graph = new ArrayList<Edge>(); 
		
		Arrays.fill(dp, INF);
		
		// 연결
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1  = Integer.parseInt(st.nextToken());
			int v2  = Integer.parseInt(st.nextToken());
			int cost  = Integer.parseInt(st.nextToken());
			
			graph.add(new Edge(v1, v2, cost));
			
		}
	
		if(bellmanFord(1)) {
			for(int i = 2; i <= N; i++) {
				if(dp[i] == INF) sb.append(-1).append("\n");
				else sb.append(dp[i]).append("\n");
			}
		}
		else {
			sb.append(-1).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static boolean bellmanFord(int start) {
		
		dp[start] = 0;
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 0; j < M; j++ ) {
				int curr = graph.get(j).node_1;
				int next = graph.get(j).node_2;
				int cost = graph.get(j).cost;
				
				// 동떨어진 노드?
				if(dp[curr] == INF) continue;
				
				if(dp[next] > (dp[curr] + cost)) {
					
					// 음수 사이클
					if(i == N) return true;

					dp[next] = dp[curr] + cost;
				}
			}
		}
		
		
		return false;
	}
	
}




