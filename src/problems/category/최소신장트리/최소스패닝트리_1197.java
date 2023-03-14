package problems.category.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
6 9
1 2 7
1 3 11
1 6 5
2 4 6
2 3 3
3 4 10
3 5 15
4 5 7
5 6 9 
 */
public class 최소스패닝트리_1197 {
	
	static class Node{
		int nodeNum;
		int cost;
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph;
	static boolean[] visited;
//	static long min = Long.MAX_VALUE;
	static long min = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 노드, 간선
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		
		int E = Integer.parseInt(st.nextToken());
		
		// 선언
		graph = new ArrayList<ArrayList<Node>>();
		visited = new boolean[V+1];
		
		// 공간 생성
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		
		// 연결, 가중치
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, cost));
			graph.get(v2).add(new Node(v1, cost));
		}
		
		prim();
		
		System.out.println(min);
		
	}
	
	static void prim() {
//		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		
		queue.offer(new Node(1, 0));
		
		while(!(queue.isEmpty())) {
			Node curr = queue.poll();
			
			// 방문한 적 있으면 continue
			if(visited[curr.nodeNum]) continue;
			
			// 여기서 방문 여부 결정
			visited[curr.nodeNum] = true;
			
			min += curr.cost;
			
			
			for(Node item : graph.get(curr.nodeNum)) {
				
				if(!(visited[item.nodeNum])) {
					queue.offer(new Node(item.nodeNum, item.cost));
				}
			}
			
		}	
	}
	

}
