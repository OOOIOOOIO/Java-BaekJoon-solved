package problems.category.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 
  	트리의 지름_1167과 마찬가지인 문제다. dfs를 어떻게 하는 지 이제 알았다!! bfs 공부하기이
 */
public class 트리의지름2_1967 {
	
		static class Node{
			int child;
			int edge;
			
			public Node(int child, int edge) {
				this.child = child;
				this.edge = edge;
			}
			
		}
		
		static ArrayList<Node>[] adList;
		static boolean[] visited;
		static int maxDist;
		static int nodeNum;
		
		static void dfs(int root, int edge) {
			if(edge > maxDist) {
				maxDist = edge;
				nodeNum = root;
			}
			
			visited[root] = true;
			
			for(Node childs : adList[root]) {
				if(!visited[childs.child]) {
					dfs(childs.child, childs.edge + edge);
				}
			}
			
		}
		
		
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 노드의 개수
		int n = Integer.parseInt(br.readLine());
		
		adList = new ArrayList[n+1];
		
		// vertex 생성
		for(int i = 0; i <= n; i++) {
			adList[i] = new ArrayList<Node>();
		}
		
		// vertex 이어주기
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			
			// 트리이기 때문에 양방향 연결
			adList[parent].add(new Node(child, edge));
			adList[child].add(new Node(parent, edge));
		}
		
		// root로부터  최장거리 노드 찾기
		visited = new boolean[n+1];
		dfs(1, 0);
		
		// root로부터 찾은 최정거리 노드로부터 다시 최장거리 노드 구하기
		visited = new boolean[n+1];
		dfs(nodeNum, 0);
		
		System.out.println(maxDist);
    }
	
}