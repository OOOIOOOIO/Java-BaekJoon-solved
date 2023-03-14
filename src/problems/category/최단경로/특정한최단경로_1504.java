package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정한최단경로_1504 {
	static class Node{
		int nodeNum;
		int cost;
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
	}
	
	static int N;
	static int[] dp;
	static ArrayList<ArrayList<Node>> graph;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		// 노드 개수
		N = Integer.parseInt(st.nextToken());
		
		// 간선 개수
		int E = Integer.parseInt(st.nextToken());
		
		// 선언
		graph = new ArrayList<ArrayList<Node>>();
		dp = new int[N+1];
		
		//공간 생성
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		

		
		
		// 연결
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, cost));
			graph.get(v2).add(new Node(v1, cost));
			
		}
		
		// 임의의 두점
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1, 두, 점, N
		int[] way_1 = {1, v1, v2, N};
		int[] way_2 = {1, v2, v1, N};
		long sum_1 = 0;
		long sum_2 = 0;
		
		
		for(int i = 0; i < 3; i++) {
			sum_1 += dijkstra(way_1[i], way_1[i+1]);
			
		}
		
		for(int i = 0; i < 3; i++) {
			sum_2  += dijkstra(way_2[i], way_2[i+1]);
			
		}
		
		long result = Math.min(sum_1, sum_2);
		
		if(result >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
		
		
	}
	
	static int dijkstra(int start, int end) {
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				
				return o1.cost - o2.cost;
			};
		});
		
		
		queue.offer(new Node(start, 0));
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[start] = 0;
		
		while(!(queue.isEmpty())) {
			
			Node curr = queue.poll();
			
			// target에 도착했음 종료
			if(curr.nodeNum == end) {
				return dp[curr.nodeNum];
			}

			
			// 얘 없어도 잘 돌아감
			// curr은 현재 최소 비용을 갖고 있는 노드이다. 즉 해당 노드의 비용보다 dp에 저장되어 있는 최단거리가 더 짧다면 
			// 현재 노드는 고려할 필요가 없으므로 continue를 해준다.
//			if(dp[curr.nodeNum] < curr.cost) {
//				continue;
//			}
			
			
			// 현재 노드와 연결된 애들 만큼 돌면서 우선 최단거리 구함
			for(int i = 0; i < graph.get(curr.nodeNum).size(); i++) {
				Node next = graph.get(curr.nodeNum).get(i);
				
				if(dp[next.nodeNum] > next.cost + curr.cost) {
					dp[next.nodeNum] = next.cost + curr.cost;
					
					queue.offer(new Node(next.nodeNum, dp[next.nodeNum]));
				}
			}
		}
		return dp[end];
	}
}





















