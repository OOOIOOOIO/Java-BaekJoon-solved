package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class 행성터널_kruscal_2887 {
	
	static class Node{
		int nodeNum;
		int x;
		int y;
		int z;
		
		public Node(int nodeNum, int x, int y, int z) {
			this.nodeNum = nodeNum;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int cost;
		
		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
	        if(this.cost < o.cost)
	        	return -1;
	        else if(this.cost == o.cost)
	        	return 0;
	        else
	        	return 1;
//			return (int)(this.cost - o.cost); // 이렇게 하면 정수가 아닐 경우 0으로 처리된다 쓰바
		}
	}
	
	
	static int N;
	static ArrayList<Node> node;
	static ArrayList<Edge> graph;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 행성 수
		N = Integer.parseInt(br.readLine());
		
		// 선언
		node = new ArrayList<Node>();
		graph = new ArrayList<Edge>();
		parent = new int[N+1];
		
		
		// 위치 받기
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			node.add(new Node(i, x, y, z));
			
		}
		
		// 서로소 집합
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		
		// 가중치 및 노드 연결
		/* 
		 	일반 크루스칼 처럼 이중 반복으로 돌리면 메로리 초과가 뜬다.
		 	어차피 3개의 좌표 중 최소값이 최단거리이므로 각각 정렬하여 가중치를 구한다.
		 	이 때 가장 중요한 것은 Node 클래스의 nodeNum이다.
		 	단순히 좌표만 정렬한 후  v1, v2에 i를 넘기는 것이 아닌 
		 	각 좌표의 위치를 넘기는 것이므로 nodeNum을 사용해야한다.
		 	그래야 어떤 노드의 좌표와 어떤 노드의 좌표의 거리인 지 알테니까.
		*/
		
		// x
		Collections.sort(node, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.x - o2.x;
			};
		});
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(node.get(i).x - node.get(i+1).x);
			
			
			graph.add(new Edge(node.get(i).nodeNum, node.get(i+1).nodeNum, cost));
		}
		
		// y
		Collections.sort(node, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.y - o2.y;
			};
		});
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(node.get(i).y - node.get(i+1).y);
			
			
			graph.add(new Edge(node.get(i).nodeNum, node.get(i+1).nodeNum, cost));
		}
		
		// z
		Collections.sort(node, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return o1.z - o2.z;
			};
		});
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(node.get(i).z - node.get(i+1).z);
			
			
			graph.add(new Edge(node.get(i).nodeNum, node.get(i+1).nodeNum, cost));
		}
		
		// 정렬
		Collections.sort(graph);
		
		// 합
		int sum = 0;
		
		
		// kruscal 로직
		for(int i = 0; i < graph.size(); i++) {
			Edge edge = graph.get(i);
			
			if(!(isSameParent(edge.v1, edge.v2))) {
				
				sum += edge.cost;
				union(edge.v1, edge.v2);
				
			}
		}
		
		System.out.println(sum);
	}
	
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		else {
			return parent[v] = find(parent[v]);
		}
	}
	
	static void union(int v1, int v2) {
		v1 =find(v1);
		v2 = find(v2);
		if(v1 != v2) {
			if(v1 < v2) {
				parent[v2] = v1;
			}
			else {
				parent[v1] = v2;
			}
		}
	}
	
	static boolean isSameParent(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 == v2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
