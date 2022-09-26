package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8
 */
public class 웜홀_1865 {
	
	static class Node{
		int nodeNum;
		int cost;
		
		public Node() {;};
		
		public Node(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}
		
	}
	
	static int INF = 987654321;
	static int TC;
	static int N;
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
	
		while(TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 노드 수
			int M = Integer.parseInt(st.nextToken()); // 도로 수
			int W = Integer.parseInt(st.nextToken()); // 웜홀 수
			
			// 초기화

			graph = new ArrayList<ArrayList<Node>>();
			
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Node>());
			}
			
			
			// 도로
			for(int i = 1; i <= M + W; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken()); 
				int node2 = Integer.parseInt(st.nextToken()); 
				int cost = Integer.parseInt(st.nextToken()); 
				
				if(i <= M) {
					graph.get(node1).add(new Node(node2, cost));
					graph.get(node2).add(new Node(node1, cost));
				}
				else {
					graph.get(node1).add(new Node(node2, -cost));
					
				}
				
			}
			
			
			boolean flag = true;
			
			// 출발지가 정해지지 않았으므로 모든 노드 출발점으로. 만약 1번이라도 싸이클이 있다면 YES
			for(int i = 1; i <= N; i++) {
				if(bellmanFord(i)) {
					sb.append("YES\n");
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append("NO\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static boolean bellmanFord(int start) {
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean isUpdate = false; // 수정사항이 있는지
		
		// V-1 번 검사
		for(int j = 1; j < N; j++) {
			isUpdate = false;
			
			// 모든 엣지 검사
			for(int i = 1; i <= N; i++) {
				for(Node node : graph.get(i)) {
					
					if(dist[i] == INF) continue;
					
					if(dist[node.nodeNum] > dist[i] + node.cost) {
//						이렇게 하면 시간 초과
//						if(j == N) return false;
						
						dist[node.nodeNum] = dist[i] + node.cost;
						isUpdate = true;
					}
				}
			}
			
			if(!isUpdate) break; // 수정사항이 없으면 끝내기
			
		}
		
		// 1번 검사 : 마지막 음수 싸이클 검사 --> 총 V번
		if(isUpdate) { // V-1 번째(바로 이전) 업데이트가 있을 때만 검사한다. 
						//--> 왜? 어차피  똑같은 짓을 한 번 더 하는 것이기 때문에 더이상 수정사항이 없다면 검사할 필요가 없다!!
			for(int i = 1; i <= N; i++) {
				for(Node node : graph.get(i)) {
					if(dist[i] == INF) continue;
					
					if(dist[node.nodeNum] > dist[i] + node.cost) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
}
