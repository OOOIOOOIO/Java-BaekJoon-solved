package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신_벨멘포드_11657 {
	
	static StringBuilder sb = new StringBuilder();
	static long[] distance;
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
		distance = new long[N+1];
		graph = new ArrayList<Edge>(); 
		
		Arrays.fill(distance, INF);
		
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
				if(distance[i] == INF) sb.append(-1).append("\n");
				else sb.append(distance[i]).append("\n");
			}
		}
		else {
			sb.append(-1).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
	static boolean bellmanFord(int start) {
		
		distance[start] = 0;
		
		// 모든 노드 V번 검사
		for(int i = 1; i <= N; i++) {
			
			// 모든 간선 검사
			for(int j = 0; j < M; j++ ) {
				int curr = graph.get(j).node_1;
				int next = graph.get(j).node_2;
				int cost = graph.get(j).cost;
				
				// 동떨어진 노드?
				if(distance[curr] == INF) continue;
				
				if(distance[next] > (distance[curr] + cost)) {
					
					// 음수 사이클 --> 이렇게 하면 시간초과 위험 있음
					if(i == N) return false;

					distance[next] = distance[curr] + cost;
				}
			}
		}
		
		
		return true;
	}
	
}

