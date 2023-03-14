package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {
	static int[][] graph;
	static boolean[] visited;
	static boolean[] visited2;
	static int N, M, V;
	
	
	static void dfs(int root) {
		visited[root] = true;
		
		System.out.print(root + " ");
		
		for(int i = 1; i <= N; i++) {
			if(graph[root][i] == 1 && !(visited[i])) {
				dfs(i);
			}
		}
		
		

	}
	
	static void bfs(int root) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited2[root] = true;
		
		queue.offer(root);
		
		while(!(queue.isEmpty())) {
			
			int a = queue.poll();
			
			System.out.print(a + " ");
			
			for(int i = 1; i <= N; i++) {
				if(graph[a][i] == 1 && !(visited2[i])) {
					visited2[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		// 정점의 개수
		N = Integer.parseInt(st.nextToken());
		// 간선의 개수
		M  = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점의 번호
		V  = Integer.parseInt(st.nextToken());
		
		// 1부터 시작
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		visited2 = new boolean[N+1];
		
		
		// 간선 연결
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
}








