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
/*
2
5 4 2
1 2 3
1 2 6
2 3 2
3 4 4
3 5 3
5
4
6 9 2
2 3 1
1 2 1
1 3 3
2 4 4
2 5 5
3 4 3
3 6 2
4 5 4
4 6 3
5 6 7
5
6 
 
 */
public class 미확인도착지_9370 {
	static class Node{
		int nodeNum;
		int cost;
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
	}
	
	static int[] dp;
	static ArrayList<ArrayList<Node>> graph;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			// 교차로(노드) / 도로(가중치)/ 목적지 후보 개수
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			// 예술가 출발 / g / h(경유지)
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // start
			int g = Integer.parseInt(st.nextToken()); // 경유지
			int h = Integer.parseInt(st.nextToken()); // 경유지
			
			
			// 선언
			graph = new ArrayList<ArrayList<Node>>();
			dp = new int[n+1];
			
			// 생성
			for(int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Node>());
			}
			
			// m개의 줄에 노드 노드 가중치
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				// 연결
				graph.get(a).add(new Node(b, d));
				graph.get(b).add(new Node(a, d));
			}
			
			Queue<Integer> result = new PriorityQueue<Integer>();
			
			// t개의 줄에 x, 목적지 후보
			for(int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine()); // target
				
				int[] way_1 = {s, g, h, x};
				int[] way_2 = {s, h, g, x};
				long sum_1 = 0;
				long sum_2 = 0;
				long sum_3 = 0;
				
				// 경유지에 따른 최단거리
				for(int j = 0; j < 3; j++) {
					sum_1 += dijkstra(way_1[j], way_1[j+1]);
				}
				
				for(int j = 0; j < 3; j++) {
					sum_2 += dijkstra(way_2[j], way_2[j+1]);
				}
				
				// 그냥 다이렉트 최단거리
				sum_3 += dijkstra(s, x);
				
				long shortcut = Math.min(sum_1, sum_2);
				
				// 우회해서 가는 경우가 다이렉트보다 더 빠르거나 같으면 옳게 가는거임
				if(shortcut <= sum_3) {
					result.offer(x);
				}
			}
			
			while(!(result.isEmpty())) {
				sb.append(result.poll()).append(" ");
			}
//			sb.append("====================");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra(int start, int target) {
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		
		queue.offer(new Node(start, 0));
		
		// dp 초기화
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// start 자기 자신은 0
		dp[start] = 0;
		
		while(!(queue.isEmpty())) {
			
			// 현재 노드
			Node curr = queue.poll();
			
			// 탈출
			if(curr.nodeNum == target) {
				
				return dp[target];
			}
			
			for(Node item : graph.get(curr.nodeNum)) {
				Node next = item;
				
				if(dp[next.nodeNum] > curr.cost + next.cost) {
					
					dp[next.nodeNum] = curr.cost + next.cost;
					
					queue.offer(new Node(next.nodeNum, dp[next.nodeNum]));
				}
			}
		}
		
		return dp[target];
	}
	
	
	
	
	
	
	
	
	
	
	
}
