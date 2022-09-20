package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class 우주신과교감_kruscal_1774 {
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		double cost;
		
		public Edge(int v1, int v2, double cost) {
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
	static int n, m;
	static ArrayList<Edge> graph;
	static int[][] map;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 선언
		map = new int[n+1][2];
		graph = new ArrayList<Edge>();
		parent = new int[n+1];
		
		// 좌표 받기
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
				
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		// 서로소 집합 생성
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		
		// 이미 연결되어 있는 애들
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			union(v1, v2);
		}
		
		// 한 좌표와 모든 좌표의 거리 계산 및 연결
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <= n; j++) {
				double dist = Math.sqrt(Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
				graph.add(new Edge(i, j, dist));
				graph.add(new Edge(j, i, dist));
			}
		}
		
		
		
		// 최단거리로 정렬
		Collections.sort(graph);
		
		// 합
		double sum = 0;
		
		
		// 잘 정렬 되었는지 확인
//		for(int i = 0; i < graph.size(); i++) {
//			System.out.println( graph.get(i).v1 +" "+ graph.get(i).v2 +" : "+ graph.get(i).cost);
//		}
		
		
		// kruscal 로직
		for(int i = 0; i < graph.size(); i++) {
			Edge edge = graph.get(i);
			
			if(!(isSameParent(edge.v1, edge.v2))) {
				// 어디랑 어디가 연결되었는지 확인
//				System.out.println(edge.v1 +" " + edge.v2 + " : " +edge.cost);
				
				sum += edge.cost;
				
				union(edge.v1, edge.v2);
			}
		}
		
		// 출력
		System.out.printf("%.2f", sum);
//		System.out.printf(String.format("%.2f", sum)+ "\n");
		
		
	}
	
	// 본인의 부모를 찾는 메서드
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		
		return parent[v] = find(parent[v]);
	}
	
	
	static void union(int v1, int v2) {
		
		v1 = find(v1);
		v2 = find(v2);
		
		// 사이클이 아닐 경우
		if(v1 != v2) {
			if(v1 > v2) parent[v1] =v2;
			else parent[v2] = v1;
		}
	}
	
	// 같은 집합인지 찾기
	static boolean isSameParent(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 == v2) return true;
		else return false;
	}
}

