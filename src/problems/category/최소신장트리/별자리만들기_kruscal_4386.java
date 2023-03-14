package problems.category.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
3
1.0 1.0
2.0 2.0
2.0 4.0
 */
public class 별자리만들기_kruscal_4386 {
	
	static int n;
	static double sum;
	static double[][] map;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	static class Edge implements Comparable<Edge>{
		int node_1;
		int node_2;
		double cost;
		
		public Edge(int node_1, int node_2, double cost) {
			this.node_1 = node_1;
			this.node_2 = node_2;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			
			return (int)(this.cost - o.cost);
		}
	}
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		// 선언
		map = new double[n+1][2];
		parent = new int[n+1];
		edgeList = new ArrayList<Edge>();
		
		// 좌표 받기
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
				
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		
		// 한 좌표와 모든 좌표의 거리 계산 및 연결
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <= n; j++) {
				double dist = Math.sqrt(Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
				edgeList.add(new Edge(i, j, dist));
				edgeList.add(new Edge(j, i, dist));
			}
		}
		
		// 서로소로 초기화
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		// 크루스칼에서는 이렇게 정렬한다.
		Collections.sort(edgeList);
		
		// 크루스칼 로직
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			// 같은 부모가 아니라면
			if(!(isSameParent(edge.node_1, edge.node_2))) {
				// Collections.sort를 통해 이미 정렬을 하였기 때문에 최소 거리이다.
				sum += edge.cost;
				union(edge.node_1, edge.node_2);
			}
			
		}
		
		System.out.printf("%.2f", sum);
	}
	
	// 본인의 부모를 찾는 메서드
	static int find(int v) {
		if(parent[v] == v) {
			return v;
		}
		
		return parent[v] = find(parent[v]);
	}
	
	static void union(int v1, int v2) {
		
		// 부모를 찾는다
		v1 = find(v1);
		v2 = find(v2);
		
		// 사이클이 아닐 때
		if(v1 != v2) {
			if(v1 > v2) parent[v1] = v2;
			
			else parent[v2] = v1;
		}
	}
	
	static boolean isSameParent(int v1, int v2) {
		
		// 부모를 찾는다
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 == v2) return true;
		
		else return false;
	}
}
