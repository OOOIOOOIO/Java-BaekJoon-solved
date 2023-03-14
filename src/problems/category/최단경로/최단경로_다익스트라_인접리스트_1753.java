package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최단경로_다익스트라_인접리스트_1753 {
	
	static class Node{
		int nodeNum;
		int cost;
		Node next;
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
	}
	
	
//	static ArrayList<Node>[] graph; 이런 경우는 특정 노드를 구하지 않고 모든 노드를 순환할 때 사용하면 좋다
	
	static ArrayList<ArrayList<Node>> graph;
	static int[] dp;
	static boolean[] visited;
	static int V;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 노드, 간선 개수
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// graph 생성
		graph = new ArrayList<ArrayList<Node>>();
		
		
		// 시작노드
		int start = Integer.parseInt(br.readLine());
		
		
		// 노드 생성(1번부터 시작하므로 +1)
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 최단거리를 저장할 배열을 생성한다.
		dp = new int[V+1];
		visited = new boolean[V+1];
		
		
		// 연결
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// v1 --> v2 연
			graph.get(v1).add(new Node(v2, cost));
			
		}
		
		// 다익스트라는 초깃값을 무한대로 설정한다.(여기선 정수 최댓값)
		for(int i = 0; i <= V; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		
		dijkstra(start, V);
		
		for(int i = 1; i <= V; i++) {
			System.out.println(dp[i]);
		}
	}
	
	static void dijkstra(int start, int target) {
		
		// 시작노드
		dp[start] = 0;
		
		// 시작노드를 넣고 탐색하기 때문에 총 횟수는 -1을 해주어야 한다.
		for (int i = 0; i < V-1; i++) {
			
			int minCost = Integer.MAX_VALUE;
			int minIdx = 0;
			
			// 인덱스 0은 생각하지 않기 때문에 1부터 반복을 진행한다.
			for (int j = 1; j <= V; j++) {
				
				if (!visited[j] && dp[j] < minCost) {
					minCost = dp[j];
					minIdx = j;
				}
			}
			
			
			
			// 최단거리인 노드를 방문표시한다.
			visited[minIdx] = true;
			
			// 현재노드와 연결되어 있는 노드의 수 만큼
			for (int j = 0; j < graph.get(minIdx).size(); j++) {

				Node Node = graph.get(minIdx).get(j);

				if (dp[Node.nodeNum] > dp[minIdx] + Node.cost) {
					dp[Node.nodeNum] = dp[minIdx] + Node.cost;
				}
			}
		}
	}
	

		
}
