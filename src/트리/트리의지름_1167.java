package 트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 	< 임의의 두 점 사이의 최장거리를 구하는 법> 
  트리의 지름 : 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것. 이어진 간선의 크기가 가장 큰 것 
 
  루트에서 가장 멀리 있는 노드와 그 노드에서 다시 가장 멀리 있는 노드와의 거리를 구하는 것이다.
  이러한 문제는 Node class를 이용해 노드의 정보를 저장하며 풀어야 한다.

*/
public class 트리의지름_1167{
	
	static class Node {
		// 노드의 번호와 간선크기(거리)
		int node, edge;

		public Node(int node, int edge) {
			this.node = node;
			this.edge = edge;
		}
	}
	
	static int max = 0; // 간선의 크기
	static int nodeNum, V; // 노드의 정보
	static boolean[] visited; 
	// []을 이용
	static ArrayList<Node>[] list; // Node class를 담고 있는 ArrayList가 담겨진 배열
	// ArrayList를 이용
	static ArrayList<ArrayList<Node>> adlist;
	
	// v : vertex(꼭지점)
	// edge : 간선(거리)
	public static void dfs(int v, int edge) {
		System.out.println(max + " " +nodeNum);
		// 현재의 edge가 max보다 크다면 node를 현재 vertex로 바꿔준다.
		if (edge > max) {
			max = edge;
			nodeNum = v; //가장 멀리 있는 노드 저장하기
		}

		visited[v] = true;
		
		
		// Node클래스 n에 현재 vertex의 정보를 넘겨주어, 만약 아직 방문하지 않았다면 재귀 호출을 이용해 밑으로 내려간다. 이때  n.edge(자식) 파라미터 edge(부모)를 더해주면서 내려간다.
		for (Node n : list[v]) {
			if (!visited[n.node]) {
				dfs(n.node, n.edge + edge); // 여기서 더해주면서 재귀를 돈다. 따라서 모든 경로를 돌면서 합이 커지면 그 값이 max, 아니면 루트에서 가장 먼 곳이 계속 max가 된다.
//				visited[n.node] = true; 얘 없어도 됨 중복임. 위에서 v로 체크했음
			}
		}
		
//		for (Node n : adlist.get(v)) {
//			if (!visited[n.node]) {
//				dfs(n.node, n.edge + edge);
//				visited[n.node] = true;
//			}
//		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// vertex 수
		V = Integer.parseInt(br.readLine());
		
		// index 1부터 시작
		list = new ArrayList[V + 1];
		
		adlist = new ArrayList<ArrayList<Node>>();
		
		// vertex 만들기
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
			
			adlist.add(new ArrayList<Node>());
		}

		// vertex 연결하기
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int nodenum = Integer.parseInt(st.nextToken());
			String str;
			while (!(str = st.nextToken()).equals("-1")) {
				int node = Integer.parseInt(str);
				int edge = Integer.parseInt(st.nextToken());
				list[nodenum].add(new Node(node, edge));
				
				adlist.get(nodenum).add(new Node(node, edge));
			}
		}
		
		// root에서 가장 먼 노드
		visited = new boolean[V + 1];
		dfs(1, 0);
		
//		dfs 돌기 전에 visted 새로 만들어주기. 같은 이름이지만 다른 공간이 거임
		// 가장 먼 노드에서 그 노드를 기준으로 가장 먼 노드
		visited = new boolean[V + 1];
		dfs(1, 0);
		System.out.println("결과 : " + max + " " + nodeNum);
		
		System.out.println("================");
		visited = new boolean[V + 1];
		dfs(nodeNum, 0);

		System.out.println("결과 : " + max + " " + nodeNum);
	}


}
