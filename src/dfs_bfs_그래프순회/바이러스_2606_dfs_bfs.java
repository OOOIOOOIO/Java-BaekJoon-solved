package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_2606_dfs_bfs {
	
	static ArrayList<Integer>[] graph;
	static ArrayList<ArrayList<Integer>> graph2;
	static boolean[] visited;
	static int cnt;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		// 컴퓨터 수
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 간선의 수
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		graph2 = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N+1];
		
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
			graph2.add(new ArrayList<Integer>());
			
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
			
			graph2.get(v1).add(v2);
			graph2.get(v2).add(v1);
		}
		
		dfs(1);
		bfs(1);
		
		System.out.println(cnt);
		
		
		
		
	}
	
	
	static void dfs(int root) {
		visited[root] = true;
		
		for(int item : graph2.get(root)) {
			if(!(visited[item])) {
				cnt++;
				dfs(item);
			}
		}
	}
	
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 시작 요소부터
		queue.offer(start);
		visited[start] = true;
		
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			// 현재 요소와 연결되어 있는 요소들
			for(int next : graph[curr]) {
				// 방문하지 않았다면
				if(!visited[next]) {
					queue.offer(next);
					++cnt;
					visited[next] = true;
				}
			}
			
		}
		
	}
	
	

}
