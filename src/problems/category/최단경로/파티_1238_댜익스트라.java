package problems.category.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238_댜익스트라 {
	
	static class Node implements Comparable<Node>{
		int nodeNum;
		int cost;
		public Node() {;}
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static ArrayList<ArrayList<Node>> graphGo;
	static ArrayList<ArrayList<Node>> graphBack;
	static int N, M, X;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 == 마을 수
		M = Integer.parseInt(st.nextToken()); // 도로
		X = Integer.parseInt(st.nextToken()); // 파티하는 마을
		
		// 초기화
		graphGo = new ArrayList<ArrayList<Node>>();
		graphBack = new ArrayList<ArrayList<Node>>();

		for(int i = 0; i <= N; i++) {
			graphGo.add(new ArrayList<Node>());
			graphBack.add(new ArrayList<Node>());
		}
		

		
		// 연결
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()); // 학생 수 == 마을 수
			int node2 = Integer.parseInt(st.nextToken()); // 파티하는 마을
			int cost = Integer.parseInt(st.nextToken()); // 도로

			// 연결
			graphGo.get(node1).add(new Node(node2, cost));
			graphBack.get(node2).add(new Node(node1, cost));

		}

		int[] go = dijkstra(graphGo);
		int[] back = dijkstra(graphBack);

		int result = 0;

		for (int i = 1; i <= N; i++) {
			result = Math.max(result, go[i] + back[i]);

		}

		System.out.println(result);

		
	}

	static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
		int[] dist = new int[N + 1];
//		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> queue = new PriorityQueue<>();

		Arrays.fill(dist, Integer.MAX_VALUE);

		// 시작점 추가
		queue.add(new Node(X, 0));
		dist[X] = 0;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

//			if (!visited[curr.nodeNum]) {
//				visited[curr.nodeNum] = true;
//			}

			if(dist[curr.nodeNum] < curr.cost) {
				continue;
			}

			for (Node next : graph.get(curr.nodeNum)) {
//			!visited[next.nodeNum] &&
				if (dist[next.nodeNum] > curr.cost + next.cost) {
					dist[next.nodeNum] = curr.cost + next.cost;

					queue.offer(new Node(next.nodeNum, dist[next.nodeNum]));
				}
			}
		}

		return dist;
	}

}
