package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 최단경로_다익스트라_인접행렬_1753 {
	
	static class Node{
		int nodeNum;
		int cost;
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost  = cost;
		}
	}
	
	static int[][] graph;
	static int[] dp;
	static boolean[] visited;
	static int V;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		// 노드, 간선 개수
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		// graph 생성(1번부터 시작하므로 +1)
		graph = new int[V+1][V+1];
		
		
		// 시작노드
		int start = Integer.parseInt(br.readLine());
		
		
		// 노드 연결
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// v1 --> v2 연
			graph[v1][v2] = cost;
		}
		
		
		// 최단거리를 저장할 배열을 생성한다.
		dp = new int[V+1];
		visited = new boolean[V+1];
		
		
		// 다익스트라는 초깃값을 무한대로 설정한다.(여기선 정수 최댓값)
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		
		dijkstra(start, V);
		
		
		for(int i = 1; i <= V; i++) {
			System.out.println(dp[i]);
		}
	}
	
	static void dijkstra(int start, int target) {
		
		// 시작노드
		dp[start] = 0;
		
		// 아래 for(j)문에서 visited[1]이 true라면 for문이 돌아가지 않는다.
		// dp[1] = 0을 해줌으로써 for문을 돌며 minCost를 구할 수 있다.
//		visited[start] = true;
		
		// 시작노드를 넣고 탐색하기 때문에 총 횟수는 -1을 해주어야 한다.
		for(int i = 0; i < V-1; i++) {
			int minIdx = -1;
			int minCost = Integer.MAX_VALUE;
			
			// 아직 방문하지 않는 노드 중 현재 노드와 최단거리인 노드 찾기
			for(int j = 1; j <= V; j++) {
				if(!(visited[j]) && (dp[j] < minCost)) {
					minCost = dp[j];
					minIdx = j;
				}
			}
			
			// 목표노드인 경우 탈출
//			if(minIdx == target) return;

			// 최단거리인 노드를 방문표시한다.
			visited[minIdx] = true;
						
			
			for(int k = 1; k <= V; k++) {
				if(!(visited[k]) && graph[minIdx][k] != 0) {
					if(dp[k] > minCost + graph[minIdx][k]) {
						dp[k] = minCost + graph[minIdx][k];
					}
				}
			}
		}
	}
	
	
	
}













