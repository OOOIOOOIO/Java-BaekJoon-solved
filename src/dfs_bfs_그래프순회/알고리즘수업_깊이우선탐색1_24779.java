package dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색1_24779 {
	
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int idx = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		// 선언
		visited = new boolean[N+1];
		order = new int[N+1];
		graph = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
			
		}
		for(int i = 0; i <= N; i++) {
			Collections.sort(graph[i], new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}
		
		// 알고리즘 수업 깊이 우선 탐색 2
//		for(int i = 0; i <= N; i++) {
//			Collections.sort(graph[i], new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//			});
//		}
//		
		
		dfs(start);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(order[i]);
		}
	}
	
	static void dfs(int start) {
		
		visited[start] = true;
		order[start] = idx;
		idx++;
		
		for(int item : graph[start]) {
			if(!(visited[item])) {
				dfs(item);
			}
		}
		
	}
}
