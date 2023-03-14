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

public class 최소비용구하기_1916 {
	
	static class Node{
		int nodeNum;
		int cost;
		
		public Node() {;}
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
		
	}
	
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 초기화
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		
		// 연결
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(new Node(node2, cost));
			
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		dijkstra(start, target);
		
		System.out.println(dist[target]);
		
		
	}
	
	static void dijkstra(int start, int target) {
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		dist[start] = 0;
		
		queue.offer(new Node(start, 0));
		
		while(!(queue.isEmpty())) {
			
			Node curr = queue.poll();
			
			if(curr.nodeNum == target) return;
			
			// 
			if(dist[curr.nodeNum] < curr.cost) continue;
			
			for(Node next : graph.get(curr.nodeNum)) {
				
				if(dist[next.nodeNum] > curr.cost + next.cost) { // 2. dist[curr.nodeNum]이 아니라 curr.cost이다.
					dist[next.nodeNum] = curr.cost + next.cost;  // 3.  사실 dist[curr.nodeNum] 이여도 상관 없는데 Node 객체를 사용하기 때문에 이렇게 쓴다!
					queue.offer(new Node(next.nodeNum, dist[next.nodeNum])); // 1. 넘겨줄 때 dist[]로 넘겨주기 때문에
				
				}
				
			}
			
		}
		
		
		
		
	}
}
