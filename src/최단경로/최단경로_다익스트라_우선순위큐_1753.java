package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import 최단경로.미확인도착지_9370.Node;

public class 최단경로_다익스트라_우선순위큐_1753 {
	
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
	static int[] dp; // weight
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
			if(dp[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dp[i]);
		}
	}
	

	
	static void dijkstra(int start, int target) {
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			};
		});
		
		// 시작 노드 
		queue.offer(new Node(start, 0));
		
		// 시작노드의 가중치를 먼저 설정한다. 시작노드부터 시작노드이므로 가중치가 0이다.
		dp[start] = 0;
		
		
		while(!(queue.isEmpty())) {
			
			// 현재 노드 번호 -> item(연결되어있는 노드들)
			Node curr = queue.poll();
			
			// 시작노드가 목표노드인 경우 탈출
//			if(curr.nodeNum == target) {
//				sb.append(dp[curr.nodeNum]);
//				return;
//			}
			
			// curr은 현재  비용을 갖고 있는 노드이다. 즉 해당 노드의 비용보다 dp에 저장되어 있는 최단거리가 더 짧다면 
			// 현재 노드는 고려할 필요가 없으므로 continue를 해준다.
			if(dp[curr.nodeNum] < curr.cost) {
				continue;
			}
			
			// 현재노드와 연결되어 있는 노드의 수 만큼
			for(int i = 0; i < graph.get(curr.nodeNum).size(); i++) {
				Node next = graph.get(curr.nodeNum).get(i);
				
				if(dp[next.nodeNum] > curr.cost + next.cost) {
			
					dp[next.nodeNum] = curr.cost + next.cost;
					
					// 현재 노드까지의 거리를  cost로 넘겨준다
					queue.offer(new Node(next.nodeNum, dp[next.nodeNum]));
				}
			}

/* 같은 의미 			
			for(Node item : graph.get(curr.nodeNum)) {
				Node next = item;
				
				if(dp[next.nodeNum] > curr.cost + next.cost) {
					
					dp[next.nodeNum] = curr.cost + next.cost;
					
					queue.offer(new Node(next.nodeNum, dp[next.nodeNum]));
				}
			}			
*/		
		}
	}
	
	
	
	
	
}







